import  java.util.*;
class ThreeSum { 

	public static int count() {
	int[] arr = {-1,-2,7,4,-2,1,-3,6,9,2,-5};
	Arrays.sort(arr); 
	int n=arr.length;; 
	int cnt=0;
	for (int i=0; i<n-1; i++) { 
		int before = i + 1; 
		int next = n - 1; 
		while (before < next) { 
			if (arr[i] + arr[before] + arr[next] == 0) { 
				cnt++;	
				before++; 
				next--;  
			} 
			else if (arr[i] + arr[before] + arr[next] < 0) 
				before++; 
			else
				next--; 
		} 
	} 
	return cnt;
 }
 
	public static void main (String[] args) { 
	System.out.println(count());
    }
}
