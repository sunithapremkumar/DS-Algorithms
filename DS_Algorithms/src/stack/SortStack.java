package stack;

import java.util.Stack;

/**
 * Sort the stack such that smallest items are on top. You can use additional stack but not any other data structure.
 * @author suni
 *
 */
public class SortStack {
	
	public void sort(Stack<Integer> st1){
		
		Stack<Integer> st2 = new Stack<>();
		
		while(!st1.isEmpty()){
			
			  int val = st1.pop();
			  while(!st2.isEmpty() && val < st2.peek()){
				  st1.push(st2.pop());
			  }
			  st2.push(val);
		}
		
		while(!st2.isEmpty())
			st1.push(st2.pop());
	}

	public static void main(String arg[]){
		Stack<Integer> st = new Stack<>();
		st.push(4);
		st.push(3);
		st.push(5);
		st.push(1);
		
		SortStack obj = new SortStack();
		obj.sort(st);
		
		while(!st.isEmpty()){
			System.out.println(st.pop());
		}
	}
}
