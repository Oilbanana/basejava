/**
 * Array based storage for Resumes
 */

import java.util.Arrays;

public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    // private int size = getIndexWithoutNull();

    void clear() {
        Arrays.fill(storage, 0, getIndexWithoutNull(), null);
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
        int indexForDelete = -1;
        int bufferForLastIndex = getIndexWithoutNull();
        if (bufferForLastIndex == 0) {
            System.out.println("Добавьте резюме для работы метода delete");
            return;
        }
        for (int i = 0; i < bufferForLastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                indexForDelete = i;
                storage[i] = null;
            }
        }
        try {
            for (int j = indexForDelete; j < bufferForLastIndex; j++) {
                storage[j] = storage[j + 1];
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("----------------------------");
            System.out.println("Не найден нужный индекс попробуйте снова");
            System.out.println("-----------------------------");
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
        //return size;
    }

    //Метод для опредления последнего индекса без null в массиве Storage
    private int getIndexWithoutNull() {
        int i = 0;
        while (storage[i] != null) {
            i++;
        }
        return i;
    }

}
