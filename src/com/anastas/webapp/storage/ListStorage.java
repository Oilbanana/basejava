package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private final List<Resume> list = new ArrayList<>();

    @Override
    public Resume get(String uuid) {
        return list.get(getSearchIndex(uuid));
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public void update(Resume r) {
        list.set(getSearchIndex(r.getUuid()),r);
    }

    @Override
    public void save(Resume r) {
        list.add(r);
    }

    @Override
    public void delete(String uuid) {
        list.remove(getSearchIndex(uuid));
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
    protected int getSearchIndex(String uuid) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid))
                index = i;
                return index;
        }
        return -1;
    }

}
