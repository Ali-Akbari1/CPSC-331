
import java.util.*;

public class HashTableSC<T extends Hashable> implements HashTableInterface<T>{
    private LinkedList<T>[] hashTable;
    private HashFunction f;

    public HashTableSC(HashFunction f, int m){
        hashTable = new LinkedList[m];
        this.f = f;
    }

    public void clear(){
        for (int i = 0; i < hashTable.length; i++){
            hashTable[i] = null;
        }
    }

    public void add(T item){
        int i = f.hash(item.key(), hashTable.length);


        if (hashTable[i] == null){
            hashTable[i] = new LinkedList<T>();
        }

        hashTable[i].add(item);
    }

    public void remove(T item){
        hashTable[f.hash(item.key(), hashTable.length)].remove(item.key());

    }

    
    public boolean contains(T item){
        int i = f.hash(item.key(), hashTable.length);

        if (hashTable[i] == null) return false;

        else return hashTable[i].contains(item);
    }
    
    // Retrieve Method
    public String retrieve(int id) {
        int i = f.hash(Integer.toString(id), hashTable.length);

        if (hashTable[i] == null) return "No student found.";
        else {
            for (T item : hashTable[i]) {
                if (((Student) item).getId() == id) {
                    return ((Student) item).getName();
                }
            }
            return "No student with this ID was found.";
        }
    }

    // To String method
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != null) {
                result.append(i).append(":");
                result.append(hashTable[i].toString());
                result.append("\n");
            }
            else{
                result.append(i).append("[]\n");
            }
        }
        return result.toString();
    }

    // Search Method
    public boolean search(int id) {
        int i = f.hash(Integer.toString(id), hashTable.length);

        if (hashTable[i] == null) return false;
        else {
            for (T item : hashTable[i]) {
                if (((Student) item).getId() == id) {
                    return true;
                }
            }
            return false;
        }
    }

    // Insert Method
    public void insert(int id, String name) {
        Student student = new Student(id, name);
        int i = f.hash(student.key(), hashTable.length);

        if (hashTable[i] == null) {
            hashTable[i] = new LinkedList<>();
        } else {
            for (T item : hashTable[i]) {
                if (item.key().equals(student.key())) {
                    ((Student) item).setName(name);
                    return;
                }
            }
        }

        hashTable[i].add((T) student);
    }

    // Implement delete method
    public void delete(int id) {
        int i = f.hash(Integer.toString(id), hashTable.length);

        if (hashTable[i] != null) {
            for (T item : hashTable[i]) {
                if (((Student) item).getId() == id) {
                    hashTable[i].remove(item);
                    return;
                }
            }
        }
        System.out.println("No student found with ID " + id);
    }

    // Hash value method
    public int hashValue(int id){
        return id % 8;

    }

}