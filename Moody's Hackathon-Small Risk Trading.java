import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
* Problem description: https://www.hackerrank.com/contests/moodysuniversityhackathon/challenges/small-risk-trading/submissions/code/7189291
*/
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int trades = sc.nextInt(); 
        int choices = sc.nextInt(); 
        
        float[] probs = new float[trades]; 
        float[] profits = new float[trades]; 
        float[] losses = new float[trades]; 
        float[] expected = new float[trades]; 
       
       // Stores probabilities of each trade 
       probs = grabTrades(probs, trades, sc);
       // Stores possible profits of each trade 
       profits = grabTrades(profits, trades, sc);
       // Stores possible losses of each trade  
       losses = grabTrades(losses, trades, sc); 
        
        // Calculates the expected profit of each trade based on given formula      
        for(int i = 0; i < expected.length; i++) { 
            expected[i] = probs[i] * profits[i] - (1 - probs[i]) * losses[i]; 
        }
        
        float sum = 0; 
        // Sorts the arrays
        Arrays.sort(expected); 
        
        //Grabs the maximal choices in array
        for(int i = expected.length - 1; i >= expected.length - choices; i--) { 
            if(expected[i] >= 0) { 
                sum += expected[i];
            }
        }
        sum = roundSum(sum); 
        System.out.printf("%.2f", sum); 
        
    }
    // Generic text parser that will store each trade in the given array
    public static float[] grabTrades(float[] arr, int trades, Scanner sc) { 
        for(int i = 0; i < trades; i++) { 
            arr[i] = sc.nextFloat(); 
        }
        return arr; 
    }
    // Returns max of array
    public static float findMax(float[] exp) { 
        float currMax = Float.MIN_VALUE;  
        for(int i = 0; i < exp.length; i++) { 
            if(currMax < exp[i]) { 
                currMax = exp[i]; 
            }
        }
        return currMax; 
    }
    // Rounds to the nearest two decimal places
    public static float roundSum(float sum) { 
       sum =  Math.round(sum * (float) 100.0) / (float) 100.0;
        return sum; 
    }
}