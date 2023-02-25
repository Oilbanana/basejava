package com.anastas.webapp.storage;
/*
 * Array based storage for Resumes
 */

import com.anastas.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            storage[index] = r;
        } else {
            System.out.println("ERROR: Введите существующее резюме, а не " + r.getUuid());
        }

    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (size > STORAGE_LIMIT) {
            System.out.println("ERROR: Хранилище переполнено.");
        }
        if (index == -1) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("ERROR: Введите новое резюме, а не существующее: " + r.getUuid());
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) != -1) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid))
                    return storage[i];
            }
        } else {
            System.out.println("ERROR: Введите существующее резюме,а не " + uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            storage[index] = storage[size - 1];
            size--;
            storage[size] = null;
        } else {
            System.out.println("ERROR: Введите существующее резюме, а не " + uuid);
        }

    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
