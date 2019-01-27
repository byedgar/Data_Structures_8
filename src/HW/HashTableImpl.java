package HW;

public class HashTableImpl implements HashTable {

    private int size;
    LinkedHashEntry[] table;

    HashTableImpl(int size) {
        this.size = size;
        table = new LinkedHashEntry[size];
        for (int i = 0; i < size; i++)
            table[i] = null;
    }


    @Override
    public void get(int key) {
        int hash = (key % size);
        if (table[hash] == null)
            System.out.println("nope");
        else {
            LinkedHashEntry entry = table[hash];
            while (entry != null && entry.getKey() != key) {
                entry = entry.getNext();
                System.out.println(entry.getTitle() + " " + entry.getCost());
            }


            if (entry == null)
                System.out.println("nope");
            else
                System.out.println(entry.getTitle() + " " + entry.getCost());

        }
    }


    @Override
    public void put(int key, String title, int cost) {

        int hash = (key % size);
        if (table[hash] == null)
            table[hash] = new LinkedHashEntry(key, title, cost);
        else {
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key)
                entry = entry.getNext();

            if (entry.getKey() == key) {
                entry.setTitle(title);
                entry.setCost(cost);
            } else
                entry.setNext(new LinkedHashEntry(key, title, cost));
        }

    }


    @Override
    public void remove(int key) {
        int hash = (key % size);
        if (table[hash] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.getNext() != null && entry.getKey() != key) {
                prevEntry = entry;
                entry = entry.getNext();
            }
            if (entry.getKey() == key) {
                if (prevEntry == null)
                    table[hash] = entry.getNext();
                else
                    prevEntry.setNext(entry.getNext());
            }

        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    void display() {

        for (int i = 0; i < size; i++) {
            int hash = (i % size);
            if (table[hash] != null) {
                LinkedHashEntry prevEntry = null;
                LinkedHashEntry entry = table[hash];
                System.out.println(entry.getKey() + " " +entry.getTitle() + " " + entry.getCost());
                while (entry.getNext() != null) {

                    entry = entry.getNext();
                    System.out.println(entry.getKey() + " " +entry.getTitle() + " " + entry.getCost());
                }
            }
        }
    }
}




