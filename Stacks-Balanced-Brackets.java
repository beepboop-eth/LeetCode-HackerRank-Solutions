import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
*  Problem description: https://www.hackerrank.com/challenges/ctci-balanced-brackets/submissions/code/30282047
*/

public class Solution {
     public static boolean isBalanced(String exp) {
        //Instantiate the stk that will be used to store closed bracket
         Stack<Character> stk = new Stack<Character>();
         /* For each character of the expression, check if 
           the character is an open bracket or a closed bracket*/
         for(int i = 0; i < exp.length(); i++) { 
           
           //If the character is a closed bracket, push it onto the stack
            if(exp.charAt(i) == '(' 
            || exp.charAt(i) == '{'  
            || exp.charAt(i) == '[') { 
                stk.push(exp.charAt(i)); 
            } else { 
            	/* Check if the stack is empty. 
            	* If it is, then we've run out of open brackets
            	* to balance out the close brackets.  
            	*/
                if(stk.isEmpty()) { 
                    return false; 
                }
                /* Otherwise, we pop a character off the stack.
                * We then check if this character is an opening bracket 
                * and if it's the appropriate bracket that balances out the 
                * closing bracket we're looking at.  
                */
                Character currBrac = stk.pop(); 
                    if((exp.charAt(i) == ']' && currBrac != '[') ||
                       (exp.charAt(i) == '}' && currBrac != '{') ||
                       (exp.charAt(i) == ')' && currBrac != '(')) { 
                            return false; 
                            
                       }
              }
         }
         /* Lastly, we check if there have been an appropriate
         * number of opening and closing brackets.
         */
         return stk.isEmpty(); 
      
  }
                       

   public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Number of bracket strings to be evaluated
        int t = in.nextInt();
        /*For each string, run isBalanced to check if string is balanced or not.  
        Output yes or no depending on answer.*/
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
             boolean answer = isBalanced(expression);
             if(answer)
              System.out.println("YES");
             else System.out.println("NO");
        }
    }
}