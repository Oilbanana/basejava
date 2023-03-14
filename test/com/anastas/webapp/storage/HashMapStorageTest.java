package com.anastas.webapp.storage;

import static org.junit.jupiter.api.Assertions.*;

class HashMapStorageTest extends AbstractStorageTest {
    public HashMapStorageTest() {
        super(new HashMapStorage());
    }
}