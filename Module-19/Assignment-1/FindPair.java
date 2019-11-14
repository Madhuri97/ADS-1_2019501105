/**
 * Farthest pair (in one dimension). Write a program that, 
 * given an array a[] of N double values, finds a farthest 
 * pair : two values whose difference is no smaller than 
 * the difference between any other pair. The running time
 * of your program should be linear in the worst case. 
 * (Analysis of Algorithms)
 * @author Madhuri
 */
import java.util.Scanner;

public class FindPair {    
    double min;
    double max;
    /**
     * this method fixes a[0] as max and iterates 
     * through array for comparing the each element
     * initially max value is a[0] if the max is 
     * lesser than a[i] then max value is a[i]
     * @param a
     * @return max 
     * returns maximum element in array
     */

    public double max(double[] a) {
        int N = a.length;
        max = a[0];
        for(int i = 0; i < N - 1; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
    /**
     * this method fixes a[0] as min and iterates 
     * through array for comparing the each element
     * initially min value is a[0] if the min is 
     * greater than a[i] then min value is a[i]
     * @param a
     * @return min
     * returns minimum element from the array
     */
    public double min(double[] a) {
        int N = a.length;
        min = a[0];
        for(int i = 0; i < N - 1; i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
    /**
     * main method used scanner class to get the 
     * input from the user.
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //length of the array = N
        System.out.println("enter length of array elements");
        int N = sc.nextInt();
        //creating double array to store the input
        System.out.println("enter array elements");
        double[] a = new double[N];
        for(int j = 0; j < N; j++) {
            double e = sc.nextDouble();
            a[j] = e; 
        }
        sc.close();
        FindPair fp = new FindPair();
        System.out.println("(" + fp.min(a) + ", " + fp.max(a) + ")");
    }
}
