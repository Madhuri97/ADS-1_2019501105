/**
 * @author Madhuri
 */
class Solution {
	
	private static void merge(String[] a, String[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }       
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static void sort(String[] a, String[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort (a, aux, lo, mid);
        sort (a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);
    }
	
	public static String[] mergeSort(String[] arr) {
        // fill you code Here
        String[] aux = new String[arr.length];
        sort(arr,aux,0,arr.length-1);
        return arr;
    }
}
