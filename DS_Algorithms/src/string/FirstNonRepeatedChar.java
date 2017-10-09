package string;

import java.util.*;

// Print the first non repeating char in the given string
// abrbacadra - return 'c'

public class FirstNonRepeatedChar {
	
	//ALGO maintain hashmap for the count
	// Maintain list for the unique char.. the order of the unique char is used to determine which one is first
	public Character getNonRepeatedChar(String str){
		      if(str == null)
		          return null;
		   
		     char charArray[] = str.toCharArray();
		     List<Character> resultList  = new ArrayList<>();
		     HashMap<Character, Integer> map = new HashMap<>();
		    for(int i=0; i< charArray.length; i ++){
		                
		           Character c = charArray[i];
		          if(map.containsKey(c)){
		             if(resultList.contains(c))
		                resultList.remove(c); // c
		          }
		        else
		          resultList.add(c);    // a, b, r,
		      
		         map.put(c, map.getOrDefault(c, 0)+1);     
		     }
		    
		     if(resultList.size() > 0)
		       return resultList.get(0);
		    
		    return null;
		    
		  }
		  
		public static void main(String arg[]){
			FirstNonRepeatedChar sol   = new FirstNonRepeatedChar();
		  System.out.println(sol.getNonRepeatedChar("abrbacadra"));
		  
		}
		  
		
}
