package recursion;

import java.util.Stack;
/**
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
Find the last number that remains starting with a list of length n.
Example:
Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6
Output:
6
 * @author suni
 *
 */
public class EliminationGame {
	    public int lastRemaining(int n) {
	    	if(n == 1)
	    		return 1;
	    	int start =2, diff =2; boolean increase = true;
	        return eliminate(start, n, diff, increase);
	    }
	    
	    //Constant space which is better
	    // n - length of array, start - start of the new list    
      private int eliminate(int start, int n, int diff, boolean increase){
	        
	        if(n == 1)
	         return start;	
	        
	        int count = n/2-1 ;
	        while(count > 1){
	            if(increase)
	            	start = start + diff;
	            else
	            	start = start - diff;
	            count = count -1;
	        }
	        return eliminate(start, n/2, (diff*2), !increase);
	    }
      
      //With O(n) space
	    private int eliminate(int[] arr, int n){
	        
	        if(n == 1)
	         return arr[0];	
	        
	        Stack<Integer> st = new Stack<>();
	        for(int i=1; i < n; i=i+2){
	            st.push(arr[i]);
	        }
	        int[] newarray = convertToArray(st);
	        System.out.println(newarray);
	        return eliminate(newarray, newarray.length);
	    }
	    
	    private int[] convertToArray(Stack<Integer> st){
	    	int[] arr = new int[st.size()];
	    	int i =0;
	    	while(!st.isEmpty())
	    		arr[i++] = st.pop();
	    	return arr;
	    }
	    
	    public static void main(String[] arg){
	    	System.out.println(new EliminationGame().lastRemaining(9));
	    }

}



