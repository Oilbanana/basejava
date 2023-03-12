package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public abstract Resume get(String uuid);

    public abstract void update(Resume r);

    public abstract void save(Resume r);

    public abstract void delete(String uuid);
    protected abstract int getSearchIndex(String uuid);

}
