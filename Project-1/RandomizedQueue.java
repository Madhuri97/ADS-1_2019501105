import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] a;
    private int n;
    public RandomizedQueue() {
        
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private int randomIndex() {
        if(isEmpty()) throw new NoSuchElementException();
        return Random.uniform(0,n);
    }

    public void enqueue(Item item) {
        if(item == null) throw new NullPointerException();
        a[n++] = item;
    }

    public Item dequeue() {
        if(isEmpty()) throw new NoSuchElementException("");
        int index = randomIndex();
        Item item = a[index];
        a[index] = a[n - 1];
        a[n - 1] = null;
        n--;
        return item;
    }

    public Item sample() {
        if(isEmpty()) throw new NoSuchElementException();
        return a[randomIndex()];
    }

    public Iterator<Item> iterator() {

    }

    public static void main(String[] args) {
        
    }
}