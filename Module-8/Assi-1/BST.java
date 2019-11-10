/**
 * @author Madhuri
 */

import java.util.*;
/**
 * BST Class to implement Inerface of Binary Search Tree
 */
public class BST<Key extends Comparable<Key>, Value> {
    private class Node {
        public Key key;
        public Value value;
        public Node left;
        public Node right;
        public int count;
        /**
         * Constructor for class Node
         * @param key
         * @param value
         * @param count
         */
        public Node(Key key, Value value, int count) {
            this.key = key;
            this.value = value;
            this.count = count;
        }
    }
    private Node root; 
    /**
     * Put Method to insert element into Tree
     * Time Complexity : O(N)
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node n, Key key, Value value) {
        if(n == null) {
            return new Node(key, value, 1);
        }
        int compare = key.compareTo(n.key);
        if(compare > 0) {
            n.right = put(n.right, key, value);
        } else if(compare < 0) {
            n.left = put(n.left, key, value);
        } else {
            n.value = value;
        }
        n.count = 1 + size(n.left) + size(n.right);
        return n;
    }
    /**
     * Get method to get the value of a particular key
     * Time Complexity : O(logN)
     * @param key
     * @return Value
     */
    public Value get(Key key) {
        Node n = root;
        while(n != null) {
            int compare = key.compareTo(n.key);
            if(compare > 0) {
                n = n.right;
            } else if(compare < 0) {
                n = n.left;
            } else {
                return n.value;
            }
        }
        return null;
    }
    /**
     * Size method to get the size of the Tree
     * Time Complexity : O(1)
     * @return count
     */
    public int size() {
        return size(root);
    }

    private int size(Node n) {
        if(n == null) {
            return 0;
        }
        return n.count;
    }
    /**
     * Floor method returns the Key that is largest key less than or equal to key
     * Time Complexity : O(LogN)
     * @param key
     * @return key
     */
    public Key floor(Key key) {
        Node d = floor(root, key);
        if(d == null) {
            return null;
        }
        return d.key;
    }

    private Node floor(Node n, Key key) { 
        if(n == null) {
            return null;
        }
        int compare = key.compareTo(n.key);
        if (compare == 0) {
            return n;
        }
        if(compare < 0) {
            return floor(n.left, key);
        }
        Node t = floor(n.right,key);
        if(t != null) {
            return t;
        } else {
            return n;
        }
    }
    /**
     * Time Complexity : O(LogN)
     * @param key
     * @return int number of keys less than key
     */
    public int rank(Key key) {
        return rank(key, root); 
    }

    private int rank(Key key, Node n) {
        if (n == null) {
            return 0;
        }
        int compare = key.compareTo(n.key);
        if (compare < 0) {
            return rank(key, n.left);
        } else if (compare > 0) {
            return 1 + size(n.left) + rank(key, n.right);
        } else {
            return size(n.left);
        }
    }
    /**
     * Method to delete the Minimum element form a given tree
     */
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node n) {
        if(n.left == null) {
            return n.right;
        }
        n.left = deleteMin(n.left);
        n.count = 1 + size(n.left) + size(n.right);
        return n;
    }
    /**
     * Method to delete the Maximum element from a given tree
     */
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node n) {
        if(n.right == null) {
            return n.left;
        }
        n.right = deleteMax(n.right);
        n.count = 1 + size(n.right) + size(n.left);
        return n;
    }
    /**
     * Method to delete the given Key
     * @param key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node n, Key key) {
        if(n == null) {
            return null;
        }
        int compare = key.compareTo(n.key);
        if (compare < 0) {
            n.left = delete(n.left, key);
        } else if (compare > 0) {
            n.right = delete(n.right, key);
        } else {
            if (n.right == null) {
                return n.left;
            }
            if (n.left == null) {
                return n.right;
            }
            Node t = n;
            n = min(t.right);
            n.right = deleteMin(t.right);
            n.left = t.left;
        }
        n.count = size(n.left) + size(n.right) + 1;
        return n;
    }
    /**
     * Method to get the Minimum element of a particular tree
     * @return Minimum value Key
     */
    public Key min() {
        return min(root).key;
    }
    
    private Node min(Node n) {
        if (n.left == null) {
            return n;
        } else {
            return min(n.left);
        }
    }
    /**
     * Method to get the Minimum element of a particular tree
     * @return Maximum value key
     */
    public Key max() {
        return max(root).key;
    }
    
    private Node max(Node n) {
        if (n.right == null) {
            return n;
        } else {
            return max(n.right);
        }
    }
    /**
     * Select Method returns key of rank k
     * @param k
     * @return Key of a Particular Rank
     */
    public Key select(int k) {
        Node n = select(root, k);
        return n.key;
    }

    private Node select(Node n, int k) {
        if (n == null) {
            return null;
        } 
        int t = size(n.left); 
        if(t > k) {
            return select(n.left,  k);
        } else if (t < k) {
            return select(n.right, k-t-1);
        } else {
            return n;
        }
    }
    /**
     * Ceiling Method is used to find smallest key greater than or equal to key
     * @param key
     * @return Key 
     */
    public Key ceiling(Key key) {
        Node n = ceiling(root, key);
        if (n == null) {
            return null;
        } else {
            return n.key;
        }
    }

    private Node ceiling(Node n, Key key) {
        if (n == null) {
            return null;
        }
        int compare = key.compareTo(n.key);
        if (compare == 0) {
            return n;
        }
        if (compare < 0) { 
            Node t = ceiling(n.left, key); 
            if (t != null) {
                return t;
            } else {
                return n;
            }
        } 
        return ceiling(n.right, key); 
    }
}
