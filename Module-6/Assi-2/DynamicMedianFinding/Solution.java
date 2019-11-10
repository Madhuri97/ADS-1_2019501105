class Solution {
	public static double[] dynamicMedian(double[] arr) {
		double meadian = 0;
		int n = arr.length;
		MaxPQ <Double> max = new MaxPQ() ;
		MinPQ <Double> min = new MinPQ() ;
		for(int i = 0; i < n; i++) {
			if(arr[i] > meadian) {
				min.insert(arr[i]);
			} else {
				max.insert(arr[i]);
			}
			if(min.size() > max.size()+1) {
				max.insert(min.delMin());
			}
			if(min.size() > min.size()+1) {
				min.insert(max.delMax());
			}
			if(min.size() == max.size()) {
				meadian = min.min();
			} else {
				meadian = max.max();
			}
			arr[i] = meadian;
		}
		return arr;
	}
}
