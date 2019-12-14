/**
 * @author Madhuri
 * @refernce Geeks for geeks
 */
import java.util.Scanner;
import java.util.Stack;
public class Postfix { 
    // Method to evaluate value of a postfix expression 
    static int Solution(String s) { 
        Stack<Integer> stack = new Stack<>();
          
        // Scan all characters one by one 
        for(int i = 0; i < s.length(); i++) { 
            char c = s.charAt(i); 
              
            // If the character is an operand (number here), 
            // push it to the stack. 
            //c - '0' is used for getting integer rather than getting its ASCII value of digit.
            if(Character.isDigit(c)) 
            stack.push(c - '0'); 
              
            //  If the character is an operator, pop two 
            // elements from stack apply the operator 
            else
            { 
                int val1 = stack.pop(); 
                int val2 = stack.pop(); 

                if(c == '+') {
                    stack.push(val2 + val1);
                } else if (c == '-') {
                    stack.push(val2 - val1);
                } else if (c == '/') {
                    stack.push(val2 / val1);
                } else if (c == '*') {
                    stack.push(val2 * val1);
                } else break; 
            } 
        } 
        return stack.pop();     
    } 
     
    public static void main(String[] args) { 
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter ");
        String s = scan.nextLine();
        scan.close();
        System.out.println("postfix evaluation: " + Solution(s)); 
    } 
}
