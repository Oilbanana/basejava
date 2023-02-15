/**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size += 1;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
       Resume temp;
        /*if (size == 0) {
            System.out.println("Добавьте резюме для работы метода delete");
            return;
        }*/
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                 temp = storage[size-1];
                storage[size] = storage[i];
                storage[i] = temp;
                size--;

            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }

}
