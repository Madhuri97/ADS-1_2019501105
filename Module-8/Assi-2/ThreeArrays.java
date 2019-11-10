import java.util.*;
/**
 * Implementation for 3 arrays BST.
 * @author Madhuri
 */
class ThreeArrays<Key extends Comparable<Key>>
{
    Key[] kys;
    Integer[] l;
    Integer[] r;
    int leftPt = 1;
    int rightPt = 1;

    public ThreeArrays()
    {
        kys = (Key[])new Comparable[40];
        l = new Integer[10];
        r = new Integer[10];
    }
    /**
     * inserts the keys and respective indices into the arrays
     * Time Complexity : O(N)
     * @param key key.
     */
    public void insert(Key key) {
        if (kys[1] == null) {
            kys[1] = key;
            return;
        }
        for (int i = 1; i < kys.length; ) {
            if (kys[i] != null && key.compareTo(kys[i]) > 0) {
                i = (2 * i) + 1;
            } else if (kys[i] != null && key.compareTo(kys[i]) < 0) {
                i = 2 * i;
            } else {
                kys[i] = key;
                if (i % 2 == 0) {
                    l[leftPt++] = i;
                }
                else {
                    r[rightPt++] = i;
                }
                break;
            }
        }
    }
    /**
     * @param key key.
     * @return string.
     * Time Complexity:O(n).
     */
    

    String toString(Key[] key) {
        String str = "";
        for (int i = 1; i < key.length; i++) {
            if (key[i] == null || key[i].equals(new Integer(0))) {
                str = str + -1 + " ";
                continue;
            }
            str = str + key[i] + " ";
        }
        return str;
    }

    public static void main(String[] args) {
        ThreeArrays obj = new ThreeArrays();
        obj.insert(6);
        obj.insert(4);
        obj.insert(12);
        obj.insert(16);
        obj.insert(2);
        obj.insert(33);
        obj.insert(9);
        obj.insert(21);
        obj.insert(3);
        obj.insert(23);
        obj.insert(19);
        obj.insert(17);
        
        System.out.println("keys = " + obj.toString(obj.kys));
        System.out.println("left = " + obj.toString(obj.l));
        System.out.println("right = " + obj.toString(obj.r));
        
    }
}