package stack;

import java.util.HashMap;
import java.util.Stack;

public class BalancedBrackets {
	
	private static HashMap<Character, Character> bracesMap = new HashMap<Character, Character>();
	static{
		
		bracesMap.put('{', '}');
		bracesMap.put('[',  ']');
		bracesMap.put('(',  ')');
	}
	
	 public static boolean isBalanced(String expression) {
	      
	     if(expression == null || expression.length() ==0)
	            return true;
	        
	        if((expression.length()%2) !=0)
	            return false;
	        
	        Stack<Character> st = new Stack<Character>();
	        char[] charArray = expression.toCharArray();
	        for(int i= 0; i< charArray.length; i++){
	            char c = charArray[i];
	            if(c == '{' || c == '[' || c == '('){
	                st.push(c);
	            }
	            else if(c == '}' || c == ']' || c == ')'){
	               if((st.isEmpty()) || (bracesMap.get(st.pop()) != c))
	                    return false;                    
	            }
	        }
	        if(st.isEmpty())
	         return true;
	        return false;
	    }
	    
	     public static void main(String...strings)
	     {
	    	 String s = ")}]]" ; //[[[()]{}{[()()]()}; //[()]{}{[()()]()}; //)}];
	    	 		 
	    	 
	    	 System.out.println(new BalancedBrackets().isBalanced(s));
	     }
}
