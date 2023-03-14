package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

import java.util.HashMap;

public class HashMapStorage extends AbstractStorage {
    private final HashMap<String, Resume> map = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public Resume doGet(Object searchKey) {
        return map.get((String) searchKey);
    }

    @Override
    public void doUpdate(Resume r, Object searchKey) {
        map.replace((String) searchKey, r);
    }

    @Override
    public void doSave(Resume r, Object searchKey) {
        map.put((String) searchKey, r);
    }

    @Override
    public void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }


    @Override
    protected boolean isExist(Object searchKey) {
        return map.containsKey((String) searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
