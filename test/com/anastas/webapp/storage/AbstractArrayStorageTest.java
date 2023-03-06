package com.anastas.webapp.storage;

import com.anastas.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));

    }

    @Test
    void clear() {
        storage.clear();
        Assertions.assertEquals(0, storage.size());
    }

    @Test
    void getAll() {
        Resume[] excepted = {storage.get("uuid1"), storage.get("uuid2"), storage.get("uuid3")};
        Assertions.assertArrayEquals(excepted, storage.getAll());
    }

    @Test
    void size(){
        Assertions.assertEquals(3, storage.size());
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}