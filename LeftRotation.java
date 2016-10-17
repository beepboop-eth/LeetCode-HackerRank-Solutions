import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
* Problem Description: https://www.hackerrank.com/challenges/array-left-rotation/submissions/code/27729114
*/
public class Solution {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
    	// Number of integers in array
        int n = sc.nextInt();
        //Number of rotations
        int d = sc.nextInt();
        
        //Stores data into an int array
        int[] input = new int[n];      
        for (int a = 0 ; a < n ; a++ ) {
            input[a] = sc.nextInt();
        }   
         
        /* The following two for loops works on two  
        * different parts of the array: 
        * The subarray from d to n-1 
        * and the subarray from n-d 
        */  
        int[] output = new int[n];
        // All elements from d to n-1 will be shifted left by d 
        for (int a = d ;  a <= (n-1) ; a++) { 
            output[a-d] = input[a];
        }
        // All elements from n - d to n - 1 will loop back around to the end of the array
        for (int a = (n-d) ; a <= (n-1) ; a++) { 
            output[a] = input[a - (n-d)];
        }
        // Output final array
        for (int a = 0 ; a <= (n-1) ; a++) { 
            System.out.print(output[a] + " ");   
        }
       
    }
}