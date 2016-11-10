package stack;

import java.util.Stack;

/**
 * Givena string S where all the characters are either ‘(‘ or ‘)’, find the longest contiguous substring that
is a valid parenthezation. For example, “(())” is valid, but “()))((“ is not.

 * @author prasunit
 *
 */

public class LongestSubstringWithBalancedBrackets {	
	
	public static String  findSubstring(String str){
	
		if(str == null)
			return "";
			
		int maxPairStart = -1, maxPairEnd = -1; // maintain the max valid parenthesis pair
		char[] charArr = str.toCharArray();
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i< charArr.length; i++)
		{
		   if(charArr[i] == '('){
			   stack.push(i); // pushing the index of the open parenthesis
		   }else { // Comes to else if we see closed parenthesis
			   
			   if(stack.isEmpty())
				   continue;
			   int start = stack.pop(), end = i; // current index is the running end of valid parenthesis
			   int runningDiff = end - start;
			   int maxPairDiff =  maxPairEnd - maxPairStart;
			   if(runningDiff > maxPairDiff)
			   {
				   maxPairStart = start;
				   maxPairEnd = end;				   
			   }
		   }		   
		}
		
		if(maxPairStart != -1 && maxPairEnd != -1)
			return str.substring(maxPairStart, maxPairEnd+1);
		return "";
		
	}
	
	
	public static void main(String... str)
	{
		String test1 = "))(())​)";
		String test2 = "(())";
		String test3 = "(()))";
		String test4 = "((()";
		
		System.out.println(findSubstring(test1));
		System.out.println(findSubstring(test2));
		System.out.println(findSubstring(test3));
		System.out.println(findSubstring(test4));
		
	}

}
