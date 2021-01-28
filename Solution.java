// Testcase: 5 : it is a positive number
// -10 then it should like negative number
// 0 then it shouldbe like niether positive nor nagative
import java.util.Scanner;
public class Solution{
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number");
        n = s.nextInt();
        if(n > 0) {
            System.out.println("It is a positive number");
        } else if(n < 0) {
            System.out.println("It is a negative number");
        } else {
            System.out.println("It is niether positive or negative number");
        }
    }
}