package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

public interface Storage {
    void clear();

    void update(Resume r);

    void save(Resume r);

    Resume get(Resume r);

    void delete(Resume r);

    Resume[] getAll();

    int size();
}
