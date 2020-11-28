public class InsertionSortP {
    void sort(int A[]) {
        int n = A.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j > 0; j--) {
                if(A[j] < A[j - 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                } else break;
            }
        }
    }

    void PrintArray(int A[]) {
        int n = A.length;
        for (int i = 0; i < n; ++i)
            System.out.print(A[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSortP io = new InsertionSortP();
        int A[] = { 3, 8, 4, 1, 6, 5 };
        io.sort(A);
        System.out.println("the sorted Array: ");
        io.PrintArray(A);
    }
}