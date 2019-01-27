public class HashTableImpl implements HashTable {

    private class Entry {

        private Item key;
        private int value;

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

    }


    private static final int DEFAULT_LINE_STEP = 1;

    private static final int INVALID_INDEX = -1;
    private static final int INVALID_COST = -1;

    protected Entry[] data;

    protected int maxSize;
    protected int size;

    public HashTableImpl(int maxSize) {
        this.data = new Entry[maxSize * 2];
        this.maxSize = maxSize;
    }

    private int hashFunc(int key) {
        return key % data.length;
    }


    @Override
    public boolean put(Item item, int cost) {
        if (size == maxSize) {
            return false;
        }

        Entry entry = new Entry();
        entry.key = item;
        entry.value = cost;

        int index = hashFunc(item.hashCode());

        while (data[index] != null) {
            index += getStep(item.hashCode());
            index %= data.length;
        }

        data[index] = entry;

        size++;
        return true;
    }

    protected int getStep(int key) {
        return DEFAULT_LINE_STEP;
    }

    @Override
    public int get(Item item) {
        int index = indexOf(item);
        return index != INVALID_INDEX ? data[index].value : INVALID_COST;

    }

    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index != INVALID_INDEX) {
            data[index] = null;
            size--;
            return true;
        }

        return false;
    }

    private int indexOf(Item item) {
        int index = hashFunc(item.hashCode());

        int count = 0;
        while (data[index] != null) {
            Entry currentEntry = data[index];
            if (currentEntry.key.equals(item)) {
                return index;
            }

            if (count > data.length) {
                return INVALID_INDEX;
            }

            index += getStep(item.hashCode());
            index %= data.length;

            count++;
        }

        return INVALID_INDEX;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(String.format("%d = [%s]", i, data[i]));
        }
        System.out.println("-----------");
    }
}