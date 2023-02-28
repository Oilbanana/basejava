package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    // Общие методы
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    // Шаблонные методы ниже, использующие getIndex
    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index <= -1) {
            System.out.println("ERROR: Введите существующее резюме,а не " + uuid);
            return null;
        }
        return storage[index];
    }

    public final void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > -1) {
            storage[index] = r;
        } else {
            System.out.println("ERROR: Введите существующее резюме, а не " + r.getUuid());
        }

    }

    public final void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size > STORAGE_LIMIT) {
            System.out.println("ERROR: Хранилище переполнено.");
        }
        if (index <= -1) {
            insertResume(index, r);
            size++;
        } else {
            System.out.println("ERROR: Введите новое резюме, а не существующее: " + r.getUuid());
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (index > -1) {
            deleteResume(index);
            size--;
            storage[size] = null;
        } else {
            System.out.println("ERROR: Введите существующее резюме, а не " + uuid);
        }
    }

    //Вариативные методы
    protected abstract int getIndex(String uuid);

    protected abstract void insertResume(int index, Resume r);

    protected abstract void deleteResume(int index);
}
