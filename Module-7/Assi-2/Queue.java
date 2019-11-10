/**
 * @author Madhuri
 */
import java.util.*;
/**
 * Here we implementing the iterable 
 * class to iterate all the items in the queue
 */
public class Queue<Item> implements Iterable<Item> {
    public Item[] a;
    public int n;
    public int front;
    public int rear;

    public Queue() {
        this.a = (Item[]) new Object[2];
        this.n = 0;
        this.front = 0;
        this.rear = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }
 
    public int size() {
        return n;
    }

    private void resize(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[(front + i) % a.length];
        }
        a = temp;
        front = 0;
        rear  = n;
    }
    /**
     * this is used to enqueue the item in the queue
     * @param item
     */
    public void enqueue(Item item) {
        if (n == a.length) resize(2*a.length);
        a[rear++] = item;
        if (rear == a.length) rear = 0;
        n++;
    }
    /**
     * this is used to dequeue the item which is in front place
     * @return item
     * 
     */
    public Item dequeue() {
        Item item = a[front];
        a[front] = null;
        n--;
        front++;
        if (front == a.length) front = 0;
        if (n > 0 && n == a.length/4) resize(a.length/2); 
        return item;
    }

    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext()  { return i < n;                               }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = a[(i + front) % a.length];
            i++;
            return item;
        }
    }

    public String toString(){
        String str = "";
        int i;
        for (i = 0; i < rear ; i++) {
            str += a[i] + " ";
        }
        return str;
    }
}
