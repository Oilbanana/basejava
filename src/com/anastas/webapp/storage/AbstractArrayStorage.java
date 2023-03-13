package com.anastas.webapp.storage;

import com.anastas.webapp.exception.*;
import com.anastas.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
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
    @Override
    public final Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

    public final void doUpdate(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    public final void doSave(Resume r, Object searchKey) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow ", r.getUuid());
        }
        insertResume((Integer) searchKey, r);
        size++;
    }

    public final void doDelete(Object searchKey) {
        deleteResume((Integer) searchKey);
        size--;
        storage[size] = null;
    }

    //Вариативные методы
    protected abstract Integer getSearchKey(String uuid);

    protected abstract void insertResume(int index, Resume r);

    protected abstract void deleteResume(int index);
}
