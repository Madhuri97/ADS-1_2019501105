import java.util.*;

public class MergeSortP {

    void Sort(int A[], int lo, int hi) {
        if(lo < hi) {
            int mid = (lo + hi)/2;
            Sort(A, lo, mid);
            Sort(A, mid + 1, hi);
            Merge(A, lo, mid, hi);
        }
    }

    void Merge(int A[], int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        int aux[] = new int[A.length];
        for (int k = lo; k <= hi; k++) {
            System.out.println(A);
            aux[k] = A[k];
            System.out.println("============================================================");
            System.out.println(Arrays.toString(aux));
        }
        
        for(int k = lo; k <= hi; k++) {
            if(i > mid) A[k] = aux[j++];
            else if(j > hi) A[k] = aux[i++];
            else if(aux[j] < aux[i]) A[k] = aux[j++];
            else A[k] = aux[i++];
        }
    }

    static void PrintArray(int A[]) {
        int n = A.length;
        for (int i = 0; i < n; i++)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int A[] = { 7, 3, 9, 1, 4, 6 };
        System.out.println("Given Array: ");
        PrintArray(A);
        MergeSortP ms = new MergeSortP();
        ms.Sort(A, 0, A.length-1);
        System.out.println("Sorted array: ");
        PrintArray(A);
    }
}
