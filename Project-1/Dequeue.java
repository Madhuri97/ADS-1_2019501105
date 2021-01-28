import java.util.Iterator;
import java.util.NoSuchElementException;

public class Dequeue<Item> implements Iterable<Item> {
    private int size = 0;
    public class Node {
        Node next;
        Node prev;
        Node first;
        Node last;
        Item item;
    }
    
    public Dequeue() {

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if(item == null) throw new NullPointerException("this method addFirst() is empty");
        Node oldFirst = first;
        first = new Node();
        first.next =oldFirst;
        first.item = item;
        if(size > 0) {
            oldFirst.prev = first;
        } else {
            last = first;
        }
        size++;
    }

    public void addLast(Item item) {
        if(item == null) throw new NullPointerException("this method() addLast throws exception if the item is null");
        Node oldLast = last;
        last = new Node();
        last.prev = oldLast;
        last.item = item;
        if(size > 0) {
            oldLast.next = last;
        } else {
            first = last;
        }
        size++;
    }

    public Item removeFirsItem() {
        if (isEmpty()) throw new NoSuchElementException("called removeFirstItem() with empty queue");
        Item item = first.item;
        if(size > 1) {
            first = first.next;
            first.prev = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    public Item removeLastItem() {
        if(isEmpty()) throw new NoSuchElementException("called removeLastItem() with empty queue");
        Item item = last.item;
        if(size > 1) {
            last = last.prev;
            last.next = null;
        } else {
            first = null;
            last = null;
        }
        size--;
        return item; 
    }

    public Iterator<Item> iterator() {
        return LIterator();
    }
    private class LIterator implements Iterator<Item> {
        private Node currNode = first;

        public boolean hasNext() {
            return currNode != null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        public Item next() {
            if(currNode == null) throw new NoSuchElementException();
            Item value = currNode.item;
            currNode = currNode.next;
            return value;
        }
    }

    public static void main(String[] args) {
        
    }
}