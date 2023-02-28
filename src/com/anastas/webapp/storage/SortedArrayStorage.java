package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertResume(int index, Resume r) {

        index = -(index) - 1;

        for (int i = index; i < size; i++) {
            if (i == size - 1)
                storage[i + 1] = storage[i];
            storage[i] = storage[i + 1];
        }
        storage[index] = r;
    }

    @Override
    protected void deleteResume(int index) {
        storage[index] = null;
        for (int i = size - 1; i > index; i--) {
            if (i == index + 1)
                storage[index] = storage[i];
            storage[i] = storage[i - 1];
        }
    }
}
