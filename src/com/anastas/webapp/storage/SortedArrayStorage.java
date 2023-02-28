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
    protected void insertResume(int index,Resume r) {
        storage[size] = r;
    }

    @Override
    protected void deleteResume(int index) {

    }
}
