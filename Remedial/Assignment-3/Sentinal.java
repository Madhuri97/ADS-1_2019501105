import java.util.Arrays;
/**
 * @author Madhuri
 */
public class Sentinal {
    int minimum;

    /**
     * this is selection sort used to find 
     * the minimum from the given array. 
     * @param A
     * @return minimum 
     */
    public int minSelSort(int[] A) {
        int n = A.length;
        for(int i = 0; i < n - 1; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                    minimum = min;
                }
            }
        }
        return minimum;
    }

    /**
     * in this insertion sort we reduced the 
     * comparision by fixing the 0th position with 
     * returned minimum value from selection sort.
     * @param A
     * @return sorted array
     */
    public int[] InsertionSort(int[] A) {
        int n = A.length;
        for(int k = 0; k < n; k++) {
            if(k == minimum) {
                int temp = A[k];
                A[k] = A[0];
                A[0] = temp;
            }
        }
        for(int i = 1; i < n; ++i) {
            int key = A[i];
            int j = i - 1;
            while(j >= minimum && A[j] > key) {
                A[j + 1] = A[j];
                j = j - 1;
            }    
            A[j + 1] = key;   
        }
        return A;
    }

    public static void main(String[] args) {
        Sentinal s = new Sentinal();
        int A[] = {6,2,1,8,5,3};
        System.out.println("the sorted array is: " + Arrays.toString(s.InsertionSort(A)));
    }
}
