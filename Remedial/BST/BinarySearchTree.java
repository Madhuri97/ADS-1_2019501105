public class BinarySearchTree <Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        Key key;
        Value val;
        Node left, right;
        // int size;

        public Node (Key key, Value val) {
            this.key = key;
            this.val = val;
            // this.size = size;
        }

        // public boolean isEmpty() {
        //     return size() == 0;
        // }

        // public int size() {
        //     return size;
        // }

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key){
            if(key == null) throw new IllegalArgumentException("calls get() with null key");
            if(x == null) return null;
            int cmp = key.compareTo(x.key);
            if(cmp < 0) return get(x.left, key);
            else if(cmp > 0) return get(x.right, key);
            else return x.val;
        }

        public void put(Key key, Value val) {
            if(val == null) {
                delete(key);
                return;
            }
            root = put(root, key, val);
        }

        private Node put(Node x, Key key, Value val) {
            if(x == null) return new Node(key, val);
            int cmp = key.compareTo(x.key);
            if(cmp < 0) x.left = put(x.left, key, val);
            else if(cmp > 0) x.right = put(x.right, key, val);
            else x.val = val;
            return x;
        }

        public void delete(Key key) { //R
            root = delete(root, key); //(S,R), (E,R), (R,R)
        }

        private Node delete(Node x, Key key) {
            if(x == null) return null; //F there is an element
            int cmp = key.compareTo(x.key); //S compared to R, E cmp to R, R comp to R
            if(cmp < 0) x.left = delete(x.left, key); //R is small than S move left again goes to left tree
            else if(cmp > 0) x.right = delete(x.right, key);//R is greater than E moves right
            else {
                if(x.right == null) return x.left; 
                if(x.left == null) return x.right;
                Node t = x;
                x = min(t.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            return x;
        }

        public Key min() {
            return min(root).key;
        }

        private Node min(Node x) {
            if (x.left == null) return x;
            else return min(x.left);
        }

        public Node deleteMin(Node x) {
            if(x.left == null) return x.right;
            x.left = deleteMin(x.left);
        }
    }
}