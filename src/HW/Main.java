package HW;

public class Main {
    public static void main(String[] args) {
        HashTableImpl hash =new HashTableImpl(10);
        hash.put(1,"Banana", 1000);
        hash.put(1,"Banana", 2000);
        hash.put(2,"Apple", 123);

        hash.get(1);

        hash.display();

    }
}
