package com.anastas.webapp.storage;
/*
 * Array based storage for Resumes
 */

import com.anastas.webapp.model.Resume;

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        boolean flagForSave = false; // флаг для сохранения резюме
        if (size > storage.length) {
            System.out.println("ERROR: Хранилище переполнено.");
        }
       /* for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("ERROR: Введите новое резюме, а не существующее: " + r.getUuid());
                flagForSave = true;
                break;
            }
        }
        if (!flagForSave) {
            storage[size] = r;
            size++;
        }*/
        if (!checkResumeIsPresent(r.getUuid())) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("ERROR: Введите новое резюме, а не существующее: " + r.getUuid());
        }
    }

    public Resume get(String uuid) {
        if (checkResumeIsPresent(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid))
                    return storage[i];
            }
        } else {
            System.out.println("ERROR: Введите существующее резюме,а не " + uuid);
        }
        return null;
    }

    public void delete(String uuid) {
        if (checkResumeIsPresent(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    storage[i] = storage[size - 1];
                    size--;
                    storage[size] = null;
                    break;
                }
            }
        } else {
            System.out.println("ERROR: Введите существующее резюме, а не " + uuid);
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private boolean checkResumeIsPresent(String uuid) {
        boolean flagForError = false;
        for (int i = 0; i <= size - 1; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                flagForError = true;
                return flagForError;
            }
        }
        return flagForError;
    }
}
