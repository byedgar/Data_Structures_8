package HW;

public interface HashTable {
    void put(int key, String title, int cost);

    void get(int key);

    void remove(int key);

    boolean isEmpty();

}
