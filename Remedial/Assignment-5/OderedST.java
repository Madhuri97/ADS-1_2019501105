public class OderedST {
    public static int capacity = 2;
    public int [] keys;
    public int [] values;
    public int n = 0;

    OderedST(){
        this(capacity);
    }
    public OderedST(int capacity){
        keys = new int[capacity];
        values = new int[capacity];
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public int get(int key){
        if(isEmpty()) return -1;
        int i = rank(key);
        if(i<n && keys[i] == key) return values[i];
        return -1;
    }
    public int rank (int key){
        int lo = 0, hi = n-1;
        while(lo <= hi) {
        int mid = lo + (hi - lo) / 2;
           if (key < keys[mid]) {
              hi = mid - 1;
            } else if(key > keys[mid]) {
              lo = mid + 1;
            } else {
              return mid;
            }
       }
        return lo;    
    }
    public void put(int key, int value) {
        if (value == 0) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i<n && keys[i] == key) {
            values[i] = value;
            return;
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }
    public void delete(int key) {
        if(isEmpty()) return;
        int i = rank(key);
         if(i == n || keys[i] != key) {
             return;
        }
        for(int j = i; j < n-1; j++) {
            keys[j] = keys[j+1];
            values[i] = values[j+1];
        }
        n--;
        keys[n] = 0;
        values[n] = 0;
    }
    public static void main(String[] args) {
        OderedST st = new OderedST();
        st.put(87, 23);
        st.put(34, 56);
        System.out.println( st.get(87));
        System.out.println( st.get(34));
        st.delete(34);
        System.out.println( st.get(34));        
    }
}
