package arrays;
import java.util.*;

/**
 * Given a string S count the number of distinct paris of characters such that the first character occurs in S at least once before the second character
 * 
 * S -"acbbbc", the pairs are (ac),(ab), (bb), (bc),(cb),(cc) - So total 6
 * @author prasunit
 *
 */
public class DistinctPairs {
   
    static HashSet<Character> distinctChars= new HashSet<Character>();
    static HashSet<String> solutionSet = new HashSet<String>();
	
	public static int countDistinctPairs(String s){
	  
	     if(s == null) return 0;
	    for(int i=0; i < s.length(); i++){
	    
	          char c = s.charAt(i);
	          if(distinctChars.contains(c))
	             continue;
	          
	          distinctChars.add(c);  //store the distinct chars
	          
	          for(int j=(i+1); j < s.length(); j++){  // For each distinct char we see, form a pair with the all the following chars and add it to set 
	               char c1 = s.charAt(j);
	               String pair = c +"" + c1;
	               solutionSet.add(pair);
	       	    //System.out.println(c +"" + c1);

	          }
	    
	    
	    }
	    return solutionSet.size();
	
	}
	
	public static void main(String... arg){
	
	  String s = "acbbc";
	  System.out.println(countDistinctPairs(s));
	
	}
	
	
}
