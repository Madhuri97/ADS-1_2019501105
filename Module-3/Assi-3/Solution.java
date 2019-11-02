import java.util.*;
class Solution{
    public int[] sortInsertion(int[] arr) {
		int j,temp;
		int n = arr.length; 
        for(int i = 1; i < n; i++) {
            j = i - 1;
            temp = arr[i];
            while(j >= 0 && arr[j] > temp) {
            arr[j+1] = arr[j];
            j--;
            }
            arr[j+1] = temp;
        }
        return arr;
    }
    public int[] sortSelection(int[] arr) {
		int n = arr.length;
        for(int i = 0; i < n; i++) {
            int min = i;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
            }
        return arr;
    }
}
