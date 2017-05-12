package logical;

import java.util.Stack;

public class ConvertToBase {

	
	public static void convert(long input){
		
		long quo = input;
		long rem = 0;
		
		Stack<Long> st = new Stack<>();
		while(quo >=7)
		{
			rem = quo % 7;
			quo = quo/7;
			
			st.push(rem);
		}
		st.push(quo);
		
		while(!st.isEmpty())
			System.out.println(st.pop());
	}
	
	public static void main(String arg[]){
		ConvertToBase.convert(7792875);
	}
}
