package com.anastas.webapp.storage;
/*
 * Array based storage for Resumes
 */

import com.anastas.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertResume(int index, Resume r) {
        storage[size] = r;
    }

    @Override
    protected void deleteResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }
}
