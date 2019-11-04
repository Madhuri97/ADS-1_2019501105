/**
 * @author Madhuri
 */
import java.util.*;
class Solution {
    public static String isMatching(String s) {
        // fill you code Here
        if(s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return "NO";
        }
        /**
         * declaring a variable of name s.
         */
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            /**
             * checking the condition for all the open cases.
             */
            if(s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                // if the above condition works we are pushing into stack
                stk.push(s.charAt(i));
            } else if(s.charAt(i) == '}') { 
                // else we are poping the pushed element from 
                //stack if its opposite paranthesis is found
                if(stk.pop() == '{') {
                    continue;
                } else return "NO";
            } else if(s.charAt(i) == ')') {
                if(stk.pop() == '(') {
                    continue;
                } else return "NO";
            } else if(s.charAt(i) == ']') {
                if(stk.pop() == '[') {
                    continue;
                } else return "NO";
            } else break;

        } if(stk.size() == 0) {
            return "YES";
        } return "NO";
    }
}