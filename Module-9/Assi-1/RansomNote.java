/** Ransom note.
 * @author Madhuri
 */
import java.util.*;
 class RansomNote<Key, Value> {
    private static final int capacity = 4;

    private int n;           
    private int m;           
    private Key[] kys;      
    private Value[] vals;    


    /**
     * Initializes an empty symbol table.
     */
    public RansomNote() {
        this(capacity);
    }

    /**
     * Initializes an empty symbol table with the specified initial capacity.
     *
     * @param capacity the initial capacity
     */
    public RansomNote(int capacity) {
        m = capacity;
        n = 0;
        kys = (Key[])   new Comparable[m];
        vals = (Value[]) new Comparable[m];
    }


    public int size() {
        return n;
    }
    private void resize(int capacity) {
        RansomNote<Key, Value> temp = new RansomNote<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (kys[i] != null) {
                temp.put(kys[i], vals[i]);
            }
        }
        kys = temp.kys;
        vals = temp.vals;
        m = temp.m;
    }


    /**
     * Returns true if this symbol table is empty.
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this symbol table contains the specified key.
     *
     * @param  key the key
     * @return bool
     * time complexity O(1)
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    
    private int hash(Key key) {
        return (key.hashCode() &                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            0x7fffffff) % m;
    }


    /**
     * Inserts the specified key-value pair into the symbol table
     * @param  key the key
     * @param  val the value
     * time complexity O(N)
     */
    public void put(Key key, Value val) {

        if (val == null) {
            delete(key);
            return;
        }

        if (n >= m/2) resize(2*m);

        int i;
        for (i = hash(key); kys[i] != null; i = (i + 1) % m) {
            if (kys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        kys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * Returns the value associated with the specified key.
     * @param key the key
     * @return the value associated with key;
     *         null if no such value
     * time complexity O(N)
     */
    public Value get(Key key) {
        for (int i = hash(key); kys[i] != null ; i = (i + 1) % m)
            if (kys[i].equals(key))
                return vals[i];
        return null;
    }

    /**
     * Removes the specified key and its associated value from this symbol table
     * (if the key is in this symbol table).
     *
     * @param  key the key
     * time complexity O(2N)
     */
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return;

        
        int i = hash(key);
        while (!key.equals(kys[i])) {
            i = (i + 1) % m;
        }
        
        kys[i] = null;
        vals[i] = null;        
        i = (i + 1) % m;
        while (kys[i] != null) {
            
            Key   keyToHash = kys[i];
            Value valToHash = vals[i];
            kys[i] = null;
            vals[i] = null;
            n--;
            put(keyToHash, valToHash);
            i = (i + 1) % m;
        }
        n--;
        if (n > 0 && n <= m/8) resize(m/2);
    }

    public int freq(String[] arrayOfInput, String k) {
        int freq = 0;
        for(int i = 0; i < arrayOfInput.length; i++) {
            if(arrayOfInput[i].equals(k)) {
                freq++;
            }
        }
        return freq;
    }
    public static void main(String[] args) {
        RansomNote<String, Integer> st = new RansomNote<String, Integer>();
        String[] arr = {"MSIT", "IIIT", "ADS-1", "216-C", "IIITH","HYD","GACHIBOWLI"};
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            if(st.contains(arr[i])) {
                st.put(arr[i], (st.get(arr[i]) + 1));
            } else {
                st.put(arr[i], 1);
            }
        }
        System.out.println(st.get("MSIT"));
        System.out.println(st.get("IIIT"));
        System.out.println(st.get("ADS-1"));
        System.out.println(st.get("216-C"));
        System.out.println(st.get("IIITH"));
        System.out.println(st.get("HYD"));
        System.out.println(st.get("GACHIBOWLI"));
        System.out.println("enter the input:");
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        s.close();
        int count = 0;

        for (char ch : input.toCharArray()) {
            if (ch == ' ') {
                count++;
                }
        }
        String[] aStr = new String[count+1];
        aStr = input.split(" ", 10);
        
        boolean bool = false;
        for(int i = 0; i < aStr.length ; i++) {
            if(!st.contains(aStr[i])) {
                bool = false;
                System.out.println("false");
                break;
            } else if (st.contains(aStr[i]) && st.get(aStr[i]) >= st.freq(aStr, aStr[i])) {
                bool = true;
            }
        } if(bool == false) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }
}
