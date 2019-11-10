/**
 * @author Madhuri
 * @param <Key>
 * @param <Value>
 */
public class SequentialSearchST<Key extends Comparable<Key>, Value> {
    private Node front;

    // a helper linked list data type
    private class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public SequentialSearchST() {

    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return  true if this symbol table contains key
     *          false otherwise
     * time complexity is O(1)
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * Returns the value associated with the given key in this symbol table.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *
     * time complexity is O(N)
     */
    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        if(front.key.compareTo(key) == 0){
            return exchange(front);
        }
        Node newNode = front;
        while(newNode != null) {
            if(newNode.next.key.compareTo(key) == 0){
                return exchange(newNode);
            }
            newNode = newNode.next;
        }
        return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old
     * value with the new value if the symbol table already contains the specified key.
     *
     * @param  key the key
     * @param  val the value
     * time complexity is O(N)
     */
    public void put(Key key, Value val) {
        Node node = new Node(key, val);
        // if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (front == null) {
            front = node;
            return;
        }
        Node newNode = front;
        while(newNode != null){
            if(newNode.key.compareTo(key) == 0) {
                newNode.val = val;
                return;
            }
            newNode = newNode.next;
        }
        Node oldfront = front;
        front = new Node(key,val);
        front.next = oldfront;
    }
    /**
     *
     * @param newNode
     * @return Value
     * time complexity is O(N)
     */
    private Value exchange(Node newNode) {
        Node temp = newNode.next;
        Value val = temp.val;
        newNode.next = newNode.next.next;
        Node node = front;
        while(node.next != null) {
            node = node.next;
        }
        node.next = temp;
        temp.next = null;
        return val;
    }



    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation {@code for (Key key : st.keys())}.
     *
     * @return all keys in the symbol table
     * time complexity is O(N)
     */
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        Node newNode = front;
        while(newNode != null) {
            queue.enqueue(newNode.key);
            newNode = newNode.next;
        }
        return queue;
    }
}
