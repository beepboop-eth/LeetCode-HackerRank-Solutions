import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/*
* Problem Description: https://www.hackerrank.com/challenges/maximum-element
*/
public class Solution {
    
    public static class LinkedStack { 
        public LinkedList<Integer> elementStack; 
        public LinkedList<Integer> maxStack; 
        
        public LinkedStack() { 
            elementStack = new LinkedList<Integer>(); 
            maxStack = new LinkedList<Integer>(); 
            maxStack.addFirst(0); 
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in); 
        LinkedStack stack = new LinkedStack(); 
        int n = sc.nextInt(); 
        
        
        for(int i = 0; i <= n; i++) { 
            String inputConsidered = sc.nextLine(); 
            if(inputConsidered.length() > 1) { //Insertion 
                Insert(stack, Integer.parseInt(inputConsidered.substring(2))); 
            }
            else { 
                
                if(inputConsidered.equals("2"))  //Deletion
                    Delete(stack);     
                else if(inputConsidered.equals("3"))
                    printMax(stack); 
            
            }
        }     
    }
    
    public static void Delete(LinkedStack stack) {
       Integer delElement = stack.elementStack.removeFirst(); 
       if(delElement == stack.maxStack.peek())
           stack.maxStack.removeFirst(); 
    
    }
    
    public static void Insert(LinkedStack stack, Integer newEl) { 
        if(stack.maxStack.peek() <= newEl) 
            stack.maxStack.addFirst(newEl); 
        stack.elementStack.addFirst(newEl); 
    }
                       
    public static void printMax(LinkedStack stack) { 
        System.out.println(stack.maxStack.getFirst()); 
    }                  
   
}