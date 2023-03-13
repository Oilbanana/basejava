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
    public final Resume get(String uuid) {
        int searchKey = getSearchKey(uuid);
        if (searchKey <= -1) {
            throw new NotExistStorageException(uuid);
        }
        return storage[searchKey];
    }

    public final void update(Resume r) {
        int searchKey = getSearchKey(r.getUuid());
        if (searchKey > -1) {
            storage[searchKey] = r;
        } else {
            throw new NotExistStorageException(r.getUuid());
        }
    }

    public final void save(Resume r) {
        int searchKey = getSearchKey(r.getUuid());
        if (searchKey >= 0) {
            throw new ExistStorageException(r.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow ", r.getUuid());
        } else {
            insertResume(searchKey, r);
            size++;
        }
    }

    public final void delete(String uuid) {
        int searchKey = getSearchKey(uuid);
        if (searchKey > -1) {
            deleteResume(searchKey);
            size--;
            storage[size] = null;
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    //Вариативные методы
    protected abstract Integer getSearchKey(String uuid);

    protected abstract void insertResume(int index, Resume r);

    protected abstract void deleteResume(int index);
}
