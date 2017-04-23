package recursion;

import java.util.*;

/**
 * Print all valid combinations of n pair of parenthesis. Example if the i/p - 3
 * o/p - ((())), (()()), (())(), ()(()),()()()
 * @author suni
 *
 */
public class ParenthesisCombinations {

	
	/**
	 * Base case and build approach (same like string permutation)
	 * if there is 1 pair o/p is just ()
	 * if 2 pairs then add the second pair in 3 different places in first first pair.. say
	 * 	1. add the second pair in the beginning of first pair - ()()
	 *  2. add the second pair to the end of first pair -()()
	 *  3. add the second pair around the first pair. -(())
	 *  
	 *   Do this for all the elements in the set (which would be the o/p of n-1 step)
	 * @param n
	 * @return
	 */
	public Set<String> getAllCombinationsOfParens(int n){
		if(n ==0)
			return new HashSet<String>();
		
		Set<String> curSet = getAllCombinationsOfParens(n-1);
		Set<String> newSet = addToSet(curSet);
		return newSet;
	}
	
	private Set<String> addToSet(Set<String> set){
		
		Set<String> newSet = new HashSet<>();
		if(set.isEmpty()){
			newSet.add("()");
			return newSet;
		}
		for(String s: set){
			//insert () at end
			String str = s +"()";
			newSet.add(str);
			
			//insert () at beginning;
			String str1 = "()"+ s; 
			newSet.add(str1);
			
			//Add around
			String str2 = "(" + s +")";
			newSet.add(str2);
			
		}
		
		return newSet;
	}
	
	
	public static void main(String arg[]){
		
		ParenthesisCombinations obj = new ParenthesisCombinations();
		Set<String> set = obj.getAllCombinationsOfParens(3);
		for(String s:set)
			System.out.println(s);
		
	}
}
