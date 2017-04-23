package stack;

import java.util.Stack;
/**
 * Implement minimum method which returns min value and should operate in O(1) time
 * @author suni
 *
 */
public class StackWithMin extends Stack<Integer>{
	
	Stack<Integer> minStack = new Stack<>();
	
	public void push(int val){
		
		if(val < min())
			minStack.push(val);
		super.push(val);
	}
	
	public Integer pop(){
		int val = super.pop();
		if(min() == val)
			minStack.pop();
		return val;
	}
	
	public int min(){
		if(minStack.isEmpty())
			return Integer.MAX_VALUE;
		else
			return minStack.peek();
	}
	
	public static void main(String arg[]){
		StackWithMin obj = new StackWithMin();
		obj.push(4);
		obj.push(3);
		obj.push(5);
		System.out.println(obj.min());
		obj.push(1);
		obj.push(6);
		System.out.println(obj.min());
	}

}
