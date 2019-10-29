import java.util.*;

public class NoOfPairs {

    public static void main(String[] args) {
        int[] arr = new int[] {1,8,3,4,1,5,2,8,3,21,12,34,12};
        int count = 0;
        int loops = 0;

        Arrays.sort(arr);

        for(int i = 0; i < arr.length-1; i++) {
            loops++;
            if(arr[i] == arr[i+1]) {
                count++;
            }
        }
        System.out.println("Nuber of loops: " + loops);
        System.out.println("Number of pairs: " + count);
    }
}