package stack;

import java.util.Stack;
/**
 * Find K which decides the number of open brackets are equal to the number of closed brackets. 

input : (()) 
output : 2 
Reason : if we divide the string at 2nd position, we get two open brackets and two closing brackets, and they are same . 

input : (())))( 
output : 4 
Reason : if we divide the string(not necessarily equally) at 4rth position, we have (()) on the left side and on the right side we have ))( , as you can see, on the left half, we have two opening brackets and on the right half we have two closing brackets and they are equal . 

input : )) 
output : 2 
Reason : there is no open brackets , so if we divide taking the whole string's length, we have )) on the left half and nothing on the right half. Now you can see that on the left half there is no open brackets and on the right half there is no closed brackets. 

This question should be clear by now and remember you have to find out that K .
 * @author suni
 *
 */
public class PartitionBrackets {
	//ALGO - number of closed braces is the result
	// ALGO - Have start and end pointers starting from both ends. As and when we see the appropriate baces add the index to stack.
	// if one stack size is bigger move the other pointer. This is to balance the stack. At last if any one stack is bigger then pop it out which will balance
	// the stack to equal size. Then the closed stack last item is the partition.
	public static int findPartition(char[] arr){
		
		Stack<Integer> open = new Stack<>();
		Stack<Integer> closed = new Stack<>();

		int start = 0;
		int end = arr.length-1;
		
		while(start < end){
			
			   if(arr[start] == '(' && ((!open.isEmpty() && open.peek() != start) || open.isEmpty()))
				   open.push(start);
			   if(arr[end] == ')' && 
					   ((!closed.isEmpty() && closed.peek() !=end) || closed.isEmpty()))
				   closed.push(end);
			   
			   if(open.size() < closed.size())
				   start++;
			   else if(open.size() > closed.size())
				   end--;
			   else{
				   start++;
				   end--;
			   }
				   
		}
		if(!closed.isEmpty() && !open.isEmpty()){
			while(open.size() != closed.size()) //balancing the stacks to equal size
			{
				if(open.size() > closed.size())
					open.pop();
				else
					closed.pop();
			}
			return closed.peek();
		}
		else if(closed.isEmpty() && open.isEmpty()){
			return -1;
		}
		else{ // one of the stack is empty
			if(closed.isEmpty())
				return open.peek();
			else
				return (closed.peek()+1);
		}
		
	}
	
	public static void main(String arg[]){
		
		//String str = "))"; 
		String str = "(())))(";
		
		System.out.println(findPartition(str.toCharArray()));
		
	}
	
}
