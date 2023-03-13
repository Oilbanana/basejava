package com.anastas.webapp.storage;

import com.anastas.webapp.exception.ExistStorageException;
import com.anastas.webapp.exception.NotExistStorageException;
import com.anastas.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract Resume doGet(Object searchKey);

    public abstract void doUpdate(Resume r, Object searchKey);

    public abstract void doSave(Resume r, Object searchKey);

    public abstract void doDelete(Object searchKey);

    protected abstract Object getSearchKey(String uuid);

    protected abstract boolean isExist(Object searchKey);

    public void save(Resume r) {
        doSave(r, getNotExistingSearchKey(r.getUuid()));
    }

    public void update(Resume r) {
        doUpdate(r, getExistingSearchKey(r.getUuid()));
    }

    public void delete(Resume r) {
        doDelete(getExistingSearchKey(r.getUuid()));
    }

    public Resume get(Resume r) {
        return doGet(getExistingSearchKey(r.getUuid()));
    }

    private Object getExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!(isExist(searchKey)))
            throw new NotExistStorageException(uuid);
        else
            return searchKey;
    }

    private Object getNotExistingSearchKey(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey))
            throw new ExistStorageException(uuid);
        else
            return searchKey;

    }


}
