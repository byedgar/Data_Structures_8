public interface HashTable {

    boolean put(Item item, int cost);

    int get(Item item);

    boolean remove(Item item);

    int getSize();

    boolean isEmpty();

    void display();

}