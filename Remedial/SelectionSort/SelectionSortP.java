class SelectionSortP {
	void sort(int A[]) {
		int n = A.length;
		for(int i = 0; i < n - 1; i++) {
			int min = i;
			for(int j = i + 1; j < n; j++) {
				if(A[j] < A[min]) {
					min = j;
				} 
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
            }
        }
	}
 
	void printArray(int A[]) 
    { 
        int n = A.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(A[i]+" "); 
        System.out.println(); 
    }

	public static void main(String[] args) {
		SelectionSortP so = new SelectionSortP();
		int A[] = {3,2,8,4,1,9,6};
		so.sort(A);
        System.out.println("the sorted array: ");
        so.printArray(A);
	}
}
