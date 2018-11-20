import java.util.LinkedList;
import java.util.Stack;
import java.util.*;
/**
 * CO551 - 2018 Assessment 1.
 *
 * @version 1.0
 */
public class JavaCollections
{
    /**
     * Task 1.
     * Method to return the index 'i' where the sum of values in the sub-array of elements indexed at
     * {0,. . .,i−1} is the same as the sub-array of elements indexed at {i + 1,. . ., n−1} — where n
     * is the number of elements in the array.
     */
    public static int arithmeticMiddle(int[] values) {
       // Initiate starting variables to keep count of values
       // Keep track of first value
       int firstElement = 0;
       
       // Keep track of totals starting from right
       int rightCount = 0;
       
       // Keep track of totals starting from left
       int leftCount = 0;
       
       // Keep track of last value
       int lastElement = values.length - 1;
       
       // While loop to run all of if statements 
       while (true) {
           if(leftCount > rightCount) {
               // Increment the rightCount value, with the value of the last element, also move the last element down the array using --
               rightCount += values[lastElement--];
           } else {
               // If left count is smaller than right count, increment with the value of the first element, also move the first element up the array using ++
               leftCount += values[firstElement++];
           }
           if(firstElement == lastElement) {
               // If a match is found, where both of the totals of the elements are found
               if(rightCount == leftCount) {
                   //then return the last element
                   return lastElement;
               } else {
                   // If no arithmetic middle value is found, return -1 
                   return -1;
               }
           }
        }
    }
    
    /**
     * Task 2.
     * method using a Stack data structure to return a boolean value indicating whether the expression
     * has a missing parenthesis pair or not.
     */
    public static boolean checkExpression(String expression) {
        // Initiate a new stack
        Stack<Character> stack = new Stack<Character>();
        // The for loop goes through the characters in the string provided
        for(int x = 0; x < expression.length(); x++) {
            // It then assigns the character to the variable 'a'
            char a = expression.charAt(x);
            // If the character is the start of the bracket '('
            if(a == '(' ) {
                // The command stack.push places the value in variable 'a' to the top of the stack
                stack.push(a);
            }
            // If the character is not '(' else if the value of 'a' is the closing bracket ')'
            else if(a == ')' )
            {   
                // Runs another if statement saying if the stack is empty, or the top of the stack is not equal to the start bracket
                // then return true, meaning that yes it is missing a bracket at the start, because the top value of the stack is still
                // the closing bracket ')'
                if(stack.isEmpty() || stack.pop() != '(' ){
                    return true;
                }
            }
        }
        // If the for loop reaches the full leangth, then return false saying there are no missing brackets. 
        return false; // change this to return the correct value
    }

    /**
     * Task 3.
     * Method to reverse the list
     */
    public static LinkedList<Integer> reverseList(LinkedList<Integer> list) {
        // Using collections class, you can easily reverse the array
        Collections.reverse(list);
        
        // Print the reversed list
        return list;// change this to return the reversed list
    }

    /**
     * Method to test the implemenation of the tasks. Note that this
     * are just examples, your implementation must work with any
     * valid input.
     */
    public static void main(String[] args) {
        // Task 1
        int[] array1 = {-3, 8, 3, 1, 1, 3};
        int[] array2 = {6, 5, 4, 3, 2, 1};
        
        System.out.println("Task 1: " + arithmeticMiddle(array1));

        // Task 2
        System.out.println("Task 2: " + checkExpression("((x+y)+z)"));
        System.out.println("Task 2: " + checkExpression("x+y+z)"));

        // Task 3
        LinkedList<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(6);
        list.add(8);
        list.add(11);
        list.add(15);
        list.add(17);
        list.add(19);
        
        LinkedList<Integer> reverse = reverseList(list);
        System.out.print("Task 3: [");

        for (Integer i : reverse) {
            System.out.print(" ");
            System.out.print(i);
        }

        System.out.println(" ]");
    }
}