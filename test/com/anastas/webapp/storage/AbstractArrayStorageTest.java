package com.anastas.webapp.storage;

import com.anastas.webapp.exception.NotExistStorageException;
import com.anastas.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
        Resume[] exceptedArray = {};
        Assertions.assertArrayEquals(exceptedArray, storage.getAll());
    }

    @Test
    void getAll() {
        Resume[] excepted = {RESUME_1, RESUME_2, RESUME_3};
        Assertions.assertArrayEquals(excepted, storage.getAll());
        assertSize(3);
    }

    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    void update() {
        Resume updatableResume = new Resume(UUID_1);
        storage.update(updatableResume);
        Assertions.assertSame(storage.get(updatableResume.getUuid()), updatableResume);
    }

    @Test
    void save() {
        storage.save(RESUME_4);
        assertGet(RESUME_4);
        assertSize(4);
    }

    @Test
    void delete() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.delete(UUID_2);
            assertGet(RESUME_2);
        }, "NotExistStorageException not thrown");
        assertSize(-1);
    }

    // Общие методы
    void assertSize(int expected) {
        Assertions.assertEquals(expected, storage.size());
    }

    void assertGet(Resume r) {
        Assertions.assertEquals(r, storage.get(r.getUuid()));
    }
}