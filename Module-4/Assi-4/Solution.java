/**
 * @author Madhuri
 */
class Solution {
	
	private static void merge(String[] a, String[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }       
        int i = low, j = mid+1;
        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(String[] a, String[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort (a, aux, low, mid);
        sort (a, aux, mid+1, high);
        merge(a, aux, low, mid, high);
    }
	
	public static String[] mergeSort(String[] arr) {
        // fill you code Here
        int n = arr.length;
        String[] aux = new String[n];
        sort(arr,aux,0,n-1);
        return arr;
    }
}
