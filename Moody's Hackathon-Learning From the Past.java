import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
* Programming Challenges: https://www.hackerrank.com/contests/moodysuniversityhackathon/challenges/learning-from-the-past/submissions/code/7187255
*/
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        //Number of trades
        int lineCount = sc.nextInt(); 
        //Where daily maxes will be stored
        int[] dayMaxes = new int[lineCount];
        int count = 0; 
       /* For each day, create a 3-element array that will 
       * store the possible trades that can be made in that day
       *
       */
        while(lineCount > 0) { 
            int[] trades = new int[3]; 
            //Store daily trades
            for(int i = 0; i < 3; i++) { 
                trades[i] = sc.nextInt(); 
            }
            
            int sum = 0; 
            // Find sum of trades if we took every trade
            for(int i = 0; i < trades.length; i++) { 
                sum += trades[i]; 
            }
            // Find the max from all possible trades that we can make    
            dayMaxes[count] = Math.max(sum - trades[0], Math.max(sum - trades[1], sum - trades[2]));
            count++; 
            lineCount--;     
        }
      
       printMax(dayMaxes); 

    }
    // Finds and prints out the max of an array
    public static void printMax(int[] maxes) { 
    
         int currMax = Integer.MIN_VALUE; 
        for(int i = 0; i < maxes.length; i++) { 
            if(currMax < maxes[i]) { 
                currMax = maxes[i]; 
            }
        }
        
        System.out.println(currMax); 
    }
}