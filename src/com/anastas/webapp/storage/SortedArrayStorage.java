package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getSearchIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void insertResume(int insertIndex, Resume r) {
        insertIndex = -(insertIndex) - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
    }

    @Override
    protected void deleteResume(int index) {
        int indexForMove = size - index - 1;
        if (indexForMove > 0)
            System.arraycopy(storage, index + 1, storage, index, indexForMove);
    }
}
