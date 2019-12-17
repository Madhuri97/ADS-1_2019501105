/**
 * @author Madhuri
 * @refernce Robert Sedgewick
 */
import java.util.Arrays;

public class MaxPQ {
    static int[] pq;
    private int n;
    int min;

    public MaxPQ() {
        MaxPQ.pq = new int[10];
        min = Integer.MAX_VALUE;
        n = 0;
    }

    /**
     * size of the array
     * @return n as size 
     */
    public int size() {
        return n;
    }

    /**
     * this method is used to insert the elements into
     * arrray in this the elements should starts from 1
     * in priority queue to reduce ambiguity.
     * time complexity O(n)
     * @param key
     */
    public void insert(int key) {
        if(min > key) min = key;
        pq[++n] = key;
        swim(n);
    }

    /**
     * used to set the inserted key in an order 
     * according to the rules of priority queue
     * time complexity O(h)
     * @param k
     */
    void swim(int k) {
        while (k > 1 && (pq[k/2] < pq[k])) {
            exch(k, k/2);
            k = k/2;
        }
    }

    /**
     * it is helper function which is used to 
     * exchange the elements.
     * @param i
     * @param j
     */
    void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * this is used to retrun the maximum element from the array
     * @return first element in the array
     * time complexity O(1)
     */
    public int max() {
        return pq[1];
    }

    /**
     * previously we stored the min element while insertng 
     * that min element is returned.
     * @return minimum element
     */
    public int min() {
        return min;
    }

    /**
     * this method is used to return deleted maximum element 
     * form the array and then we also use sink function
     * to maintain the order of the array elements.
     * time complexity O(n)
     * @return
     */
    public int delMax() {
        int max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = 0;
        return max;
    }

    /**
     * this is helper function used to maintain the array 
     * elements in order 
     * @param k
     */
    void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && (pq[j] < pq[j + 1])) {
                j++;
            }
            if (!(k < j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    
    public static void main(String[] args) {
        MaxPQ m = new MaxPQ();
        m.insert(2);
        m.insert(9);
        m.insert(1);
        m.insert(10);
        m.insert(15);
        m.insert(12);
        m.insert(6);
        m.insert(8);
        m.insert(3);
        System.out.println("inseted elements: " + Arrays.toString(pq));
        System.out.println(m.delMax());
        System.out.println(m.min());
        System.out.println(m.max());
    }
}
