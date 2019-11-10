/**
 * @author Madhuri
 * min heap is bottom up approach
 */
class Solution {
	public static boolean isMinHeap(double[] arr) {
		int n = arr.length;
		if(n <= 0) {
			return false;
		}
		for(int i = n - 1; i >= 0; i--) {
			if(n > i/2) {
				//comparing parent and child and if needed exchange it with parent 
				if(arr[i/2] > arr[i]) {
					return false;
				}
			}
		}
		return true;
	}
}