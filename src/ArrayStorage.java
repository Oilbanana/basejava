/**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[getIndexWithoutNull()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < getIndexWithoutNull(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int bufferForIndex = 0;                             //Переменная для хранение индекса удаленного резюме
        int bufferForLastIndex = getIndexWithoutNull();    //Переменная для хранения последнего индекса без Null (Она нужна, так как использую второй массив)
        for (int i = 0; i < bufferForLastIndex - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                bufferForIndex = i;
                storage[i] = null;
            }
        }

        for (int j = bufferForIndex; j < bufferForLastIndex; j++) {
            storage[j] = storage[j + 1];
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, getIndexWithoutNull());
    }

    int size() {
        return getIndexWithoutNull();
    }

    //Метод для опредления индекса без null в массиве Storage
    int getIndexWithoutNull() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }

}
