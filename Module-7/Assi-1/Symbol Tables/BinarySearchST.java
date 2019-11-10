/**
 * @author Madhuri
 */

import java.util.*;
import java.lang.*;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int size;

    public BinarySearchST() {
        this.keys = (Key[]) new Comparable[2];
        this.vals = (Value[]) new Object[2];
        this.size = 0;
        
    }

    private void resize() {
        keys = Arrays.copyOf(keys, size + 1);
        vals = Arrays.copyOf(vals, size + 1);
    }
    
    /**
     * Inserts the specified key-value pair into the symbol table
     * If symbol table already contains the key-value then it 
     * overwrites the old value with the new value.
     * @param key
     * @param val
     * time complexity O(n)
     */
    public void put(final Key key, final Value val) {
        if (val == null) {
            delete(key);
            return;
        }
        int r = rank(key);
        if (r < size && keys[r].compareTo(key) == 0) {
            vals[r] = val;
            return;
        }
        if (size == keys.length) {
            resize();
        }
        for (int j = size; j > r; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[r] = key;
        vals[r] = val;
        size++;
    }
    
    /**
     * Returns the value associated with the given key in symbol table
     * @param key
     * @return value of the key
     * if not present returns null
     */
    public Value get(final Key key) {
        int r = rank(key);
        if (r < size && (keys[r].compareTo(key) == 0)) {
            return vals[r];
        }
        return null;
    }
    
    /**
     * Returns the no of keys in the symbol table
     * @param key
     */
    public int rank(final Key key) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int comp = key.compareTo(keys[mid]);
            if (comp < 0) {
                hi = mid - 1;
            } else if (comp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Key max() {
        return keys[size - 1];
    }

    public Key min() {
        return keys[0];
    }
    
    //returns the largest key in the symbol table less than or equal to key
    public Key floor(final Key key) {
        int rank = rank(key);
        if (rank == 0) {
            return null;
        }
        if (rank < size && key.compareTo(keys[rank]) == 0) {
            return keys[rank];
        } else {
            return keys[rank - 1];
        }
    }

    public void deleteMin() {
        delete(min());
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(final Key key) {
        return get(key) != null;
    }
    
    //removes the specific key and associated value 
    public void delete(final Key key) {
        if (isEmpty()) return;
        int rnk = rank(key);
        if (rnk == size || (keys[rnk].compareTo(key) != 0)) {
            return;
        }
        for (int j = rnk; j < size - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        size--;
        keys[size] = null;
        vals[size] = null;
    }
    
    //returns all the keys in the symbol table in a given range
    public Iterable keys() {
        Queue Q = new Queue();
        for(int i = 0; i < size; i++) {
            Q.enqueue(keys[i]);
        }
        return Q;
    }
}
