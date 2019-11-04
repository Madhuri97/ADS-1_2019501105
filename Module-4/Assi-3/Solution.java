/**
 * @author Madhuri
 */
import java.util.Random;
class Solution {
	
	public static int[] quickSort(int[] arr) {
        // StdRandom.shuffle(arr);
        int n = arr.length;
		sort(arr, 0, n - 1);
		return arr;
	}
	
	private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
	
	private static void sort(int[] arr, int low, int high) { 
        if (high <= low) return;
        int j = partition(arr, low, high);
        sort(arr, low, j-1);
        sort(arr, j+1, high);
	}
	
	private static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {            
            while (arr[++i] < arr[low]) {
                if (i == high) break;
            }            
            while (arr[low] < arr[--j]) {
                if (j == low) break;      
            }           
            if (i >= j) break;
            exch(arr, i, j);
        }       
        exch(arr, low, j);        
        return j;
    }
}
