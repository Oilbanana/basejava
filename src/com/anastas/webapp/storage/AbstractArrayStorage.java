package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    public static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume get(String uuid) {
        if (getIndex(uuid) != -1) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid))
                    return storage[i];
            }
        } else {
            System.out.println("ERROR: Введите существующее резюме,а не " + uuid);
        }
        return null;
    }

    public int size() {
        return size;
    }

    protected abstract int getIndex(String uuid);
}
