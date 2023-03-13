package com.anastas.webapp;

import com.anastas.webapp.model.Resume;
import com.anastas.webapp.storage.ArrayStorage;
import com.anastas.webapp.storage.Storage;

/**
 * Test for your com.anastas.webapp.storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid3");

     //   ARRAY_STORAGE.doSave(r1, );
     //   ARRAY_STORAGE.doSave(r2, );
     //   ARRAY_STORAGE.doSave(r3, );

      //  System.out.println("Get r1: " + ARRAY_STORAGE.doGet());
        System.out.println("Size: " + ARRAY_STORAGE.size());
     //   ARRAY_STORAGE.doUpdate(r2, );                                           //Вызов update
        //System.out.println("Get dummy: " + ARRAY_STORAGE.doGet());

        printAll();
       // ARRAY_STORAGE.doDelete();
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
