import java.util.Scanner;
import java.util.Stack;
// import java.io.*;
public class Paranth {
    public static String Solution(String para) {
        Stack<Character> obj = new Stack<>();
        for(int i = 0; i < para.length(); i++) {
            char c = para.charAt(i);
            if(c == '{' || c == '[' || c == '(') {
                obj.push(c);

            }
            else if (c == '}') {
                if (obj.pop() != '{') {
                    return "Not matching";
                }
            }
            else if (c == ']') {
                if (obj.pop() != '[') 
                return "Not matching";
            }
            else if (c == ')') {
                if (obj.pop() != '(')
                return "Not matching";
            }
        }
        return "Matching";
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter paranthesis: ");
        String s = scan.nextLine();
        scan.close();
        System.out.print("Entered paranthesis are " + Solution(s));
    }
}
