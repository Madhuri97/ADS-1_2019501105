import java.util.*;
class SortedArrays {
   
        static int[] arr1 = {2,3,7,10,13,22,66,77,99};
        static int[] arr2 = {5,8,9,13,16,17,44,78,98};
        static int[] arr = new int[arr1.length + arr2.length];
        
        public static void main(String[] args) {
        int i = 0, j = 0, k = 0;

        while(i < arr1.length && j < arr2.length) {
            
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];

            }
            else {
                arr[k++] = arr2[j++];
            }
        }
        while(i < arr1.length) {
                arr[k++] = arr1[i++];
        }
        while(j < arr2.length) {
                arr[k++] = arr2[j++];
        }   
        System.out.println(Arrays.toString(arr));   
    }
}