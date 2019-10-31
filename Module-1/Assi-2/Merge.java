public class Merge {
    public static void main (String[] args) {
       int[] arr1 = {11, 34, 66, 75};
       int[] arr2 = {1, 5, 19, 50, 89, 100};
       int n2 = arr2.length;
       int n1 = arr1.length;
       int[] arr = new int[n1 + n2];
       int i = 0, j = 0, k = 0;
       while (i < n1 && j < n2) {
          if (arr1[i] < arr2[j])
             arr[k++] = arr1[i++];
          else
             arr[k++] = arr2[j++];
       }
       while (i < n1)
          arr[k++] = arr1[i++];
       while (j < n2)
          arr[k++] = arr2[j++];
       for (int x = 0; x < n1 + n2; x++)
          System.out.print(arr[x] + " ");
    }
 }