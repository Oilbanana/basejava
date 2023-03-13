package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> list = new ArrayList<>();
    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid))
                return i;
        }
        return -1;
    }

    @Override
    public Resume doGet(Object searchKey) {
        return list.get((Integer) searchKey);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void doUpdate(Resume r, Object searchKey) {
        list.set((Integer) searchKey, r);
    }

    @Override
    public void doSave(Resume r, Object searchKey) {
        list.add(r);
    }

    @Override
    public void doDelete(Object searchKey) {
        list.remove((Integer) searchKey);
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public int size() {
        return list.size();
    }


    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }


}
