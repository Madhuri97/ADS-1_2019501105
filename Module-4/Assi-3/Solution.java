/**
 * @author Madhuri
 */
import java.util.Random;
class Solution {
	
	public static int[] quickSort(int[] arr) {
		// StdRandom.shuffle(arr);
		sort(arr, 0, arr.length - 1);
		return arr;
	}
	
	private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	private static void sort(int[] arr, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);
	}
	
	private static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {            
            while (arr[++i] < arr[lo]) {
                if (i == hi) break;
            }            
            while (arr[lo] < arr[--j]) {
                if (j == lo) break;      
            }           
            if (i >= j) break;
            exch(arr, i, j);
        }       
        exch(arr, lo, j);        
        return j;
    }
}
