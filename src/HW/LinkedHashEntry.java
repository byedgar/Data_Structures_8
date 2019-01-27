package HW;

public class LinkedHashEntry {

    private int key;
    private String title;
    private int cost;
    private LinkedHashEntry next;


    LinkedHashEntry(int key, String title, int cost) {
        this.key = key;
        this.title = title;
        this.cost = cost;
        this.next = null;

    }


    public String getTitle() {
        return title;
    }
    public int getCost() {
        return cost;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }


    public int getKey() {
        return key;
    }


    public LinkedHashEntry getNext() {
        return next;
    }


    public void setNext(LinkedHashEntry next) {
        this.next = next;
    }

}