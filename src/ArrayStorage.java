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
                System.out.println("Резюме с  таким id нет");
            }
        }
        return null;
    }

    void delete(String uuid) {
        int bufferForIndex;
        for (int i = 0; i < getIndexWithoutNull()-1 ; i++) {
            if (storage[i].uuid.equals(uuid)){

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

    int getIndexWithoutNull(){
        int i = 0;
        while (storage[i] != null){
            i++;
        }
        return i;
    }

}
