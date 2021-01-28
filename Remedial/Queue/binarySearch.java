class BinarySearch {  
    int binarySearch(int a[], int lo, int hi, int x) 
    { 
        if (lo <= hi) { 
            int mid = lo + (hi - lo) / 2; 
            if (a[mid] == x) 
                return mid;  
            if (a[mid] > x) 
                return binarySearch(a, lo, mid - 1, x);  
            return binarySearch(a, mid + 1, hi, x); 
        }
        return -1; 
    }
    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch(); 
        int a[] = { 2, 3, 4, 10, 40 }; 
        int n = a.length; 
        int x = 10; 
        int result = ob.binarySearch(a, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not found"); 
        else
            System.out.println("Element found " + result); 
    }
}