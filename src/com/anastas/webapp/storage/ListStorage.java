package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> list = new ArrayList<>();

    @Override
    public Resume get(String uuid) {
        return list.get(getSearchKey(uuid));
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void update(Resume r) {
        list.set(getSearchKey(r.getUuid()), r);
    }

    @Override
    public void save(Resume r) {
        list.add(r);
    }

    @Override
    public void delete(String uuid) {
        list.remove(getSearchKey(uuid));
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
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid))
                return i;
        }
        return -1;
    }

}
