class QuickSort {
    int partition(int A[], int low, int high) {
      int pivot = A[high];
      int i = (low - 1);
      for (int j = low; j < high; j++) {
        if (A[j] <= pivot) {
          i++;
          int temp = A[i];
          A[i] = A[j];
          A[j] = temp;
        }
      }
      int temp = A[i + 1];
      A[i + 1] = A[high];
      A[high] = temp;
      return (i + 1);
    }
    void quickSort(int A[], int low, int high) {
      if (low < high) {
        int pi = partition(A, low, high);
        quickSort(A, low, pi - 1);
        quickSort(A, pi + 1, high);
      }
    }
    void printArray(int A[], int size) {
      for (int i = 0; i < size; ++i)
        System.out.print(A[i] + " ");
      System.out.println();
    }
    public static void main(String args[]) {
      int[] data = { 8, 7, 2, 1, 0, 9, 6 };
      int size = data.length;
      QuickSort qs = new QuickSort();
      qs.quickSort(data, 0, size - 1);
      System.out.println("Sorted array in ascending Order: ");
      qs.printArray(data, size);
    }
}
