import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new DoubleHashTableImpl(5);
        hashTable.put(new Item(1, "Orange"), 150);
        hashTable.put(new Item(77, "Banana"), 100);
        hashTable.put(new Item(62, "Lemon"), 250);
        hashTable.put(new Item(21, "Potato"), 67);
        hashTable.put(new Item(55, "Milk"), 120);

        System.out.println("Size is " + hashTable.getSize());
        hashTable.display();


        Map<String, Integer> costByTitle = new HashMap<>();
        costByTitle.put("Banana", 75);
        costByTitle.put("Potato", 175);
        costByTitle.put("Orange", 275);

        for (String key : costByTitle.keySet()) {
            Integer cost = costByTitle.get(key);
            System.out.println(key + " = " + cost);
        }
    }
}
