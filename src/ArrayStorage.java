/**
 * Array based storage for Resumes
 */
import java.util.Arrays;
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage,null);
    }

    void save(Resume r) {
        storage[getIndexWithoutNull()]= r;
    }

    Resume get(String uuid) {
        for (Resume resume: storage){
            if(resume.uuid.equals(uuid)){
                return resume;
            }
            else {
                System.out.println("Резюме с таким id нет");
            }
        }
        return null;
    }

    void delete(String uuid) {
        int bufferForIndex=0;//Переменная для хранение индекса удаленного резюме
        int bufferForLastIndex= getIndexWithoutNull();
        for (int i = 0; i < bufferForLastIndex ; i++) {
            if (storage[i].uuid.equals(uuid)){
                bufferForIndex = i;
                storage[i] = null;
            }
            else{
                System.out.println("Резюме с таким id нет");
            }

            for (int j = bufferForIndex+1; j < bufferForLastIndex ; j++) {
                storage[j-1] = storage[j];
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return new Resume[0];
    }

    int size() {
        return 0;
    }

    //Метод для опредления индекса без null в массиве Storage
    int getIndexWithoutNull(){
        int i = 0;
        while (storage[i] != null){
            i++;
        }
        return i;
    }

}
