import java.util.NoSuchElementException;
import java.util.*;

/**
 * @author Madhuri
 * @reference Robert Sedgewick
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             

    private class Node {
        public Key key;           
        public Value val;         
        private Node left, right;  
        private int size;          

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {
    }
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    /**
     * return size of the binary serch tree
     * @return integer 
     */
    public int size() {
        return size(root);
    }
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }

    /**
     * this method is used to check if the 
     * tree consists of given key or not
     * @param key
     * @return true or false 
     */
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    /**
     * this method is used to get the corresponding 
     * value for a given key it starts searching from 
     * root element and gives the value of the given 
     * key by following binary search tree rules
     * @param key
     * @return Value for the corresponding key
     */
    public Value get(Key key) {
        return get(root, key);
    }
    private Value get(Node x, Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with a null key");
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    /**
     * this method is used to 
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with a null key");
        if (val == null) {
            delete(key);
            return;
        }
        root = put(root, key, val);
        assert isOrdered();
    }
    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * this method is used to delete the minimum 
     * value in the binarysearch tree
     */
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
        assert isOrdered();
    }
    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * this method is used to delete the maximum
     * value in the binarysearch tree
     */
    public void deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
        assert isOrdered();
    }
    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * this method is used to delete any value
     * in the given binary search tree.
     * @param key 
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
        assert isOrdered();
    }
    private Node delete(Node x, Key key) {
        if (x == null) return null;

        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else { 
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        } 
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    } 

    /**
     * this method is used to find the minimum value BST
     * @return minimum key value
     */
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    } 
    private Node min(Node x) { 
        if (x.left == null) return x; 
        else return min(x.left); 
    } 

    /**
     * this method is used to find the maximum value in BST.
     * @return maximum key value 
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    } 
    private Node max(Node x) {
        if (x.right == null) return x; 
        else return max(x.right); 
    } 

    /**
     * this method is used to check wether 
     * the binary search tree value are in 
     * between max and min or not
     * @return boolean 
     */
    public boolean isOrdered() {
        if (!isCheck()) System.out.println("Not in symmetric order");
            return isCheck();
    }
    private boolean isCheck() {
        return isCheck(root, null, null);
    }
    private boolean isCheck(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) < 0) return false;
        if (max != null && x.key.compareTo(max) > 0) return false;
        return isCheck(x.left, min, x.key) && isCheck(x.right, x.key, max);
    }
}
