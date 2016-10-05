package string;

import java.util.HashMap;
import java.util.Set;
/**
 * Find the number of characters need to be modified to make the 2 strings anagrams of each other
 * @author prasunit
 *
 */
public class MakingAnagrams {

	 // Solution 1
	    public static int numberNeeded(String first, String second) {
	      
	    	//Get the count of each character in the string in Hashmap
	         HashMap<Character, Integer> map1 = getCounts(first);
	         HashMap<Character, Integer> map2= getCounts(second);
	         int finalCnt = 0;
	         //Find the hashmap diff
	         finalCnt = countDiff(map1, map2, finalCnt, true);
	         finalCnt = countDiff(map2, map1, finalCnt, false);
	         return finalCnt;   
	      
	    }
	  
	    private static int countDiff(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2, int finalCnt, boolean check){
	        Set<Character> keys = map1.keySet();
	        for( Character c: keys){
	             int cnt1 = map1.get(c);
	             if(map2.containsKey(c)){  
	                 if(check){ // if this is cheked in one map no need to check in another map as it is counted already
	                    int cnt2 = map2.get(c) ;
	                    finalCnt += Math.abs(cnt1-cnt2);
	                 }
	             }
	             else{
	                 finalCnt+= cnt1;
	             }
	         }
	        return finalCnt;
	    }
	    private static HashMap<Character, Integer> getCounts(String s){
	        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	         for(int i=0; i< s.length(); i++){
	            char c = s.charAt(i);
	            if(map.containsKey(c)){
	                int count = map.get(c);
	                map.put(c, (count+1));
	            }
	            else
	                map.put(c, 1);
	        }
	        return map;
	    }
	    
   // Solution 2 better way
	    public static int numberNeeded1(String first, String second) {
	    	
	    	int[] asciiChars = new int[256];
	    	
	    	char[] first_Array = first.toCharArray();
	    	for(char c: first_Array){
	    		asciiChars[c]++;
	    	}
	    	char[] second_Array = second.toCharArray();
	    	for(char c: second_Array){
	    		asciiChars[c]--;
	    	}
	    	
	    	int count = 0;
	    	for(int i=0; i<asciiChars.length; i++)
	    	{
	    		count += Math.abs(asciiChars[i]);
	    	}
	    	return count;
	    }
	    
	    public static void main(String[] args) {
	        String a = "cde";
	        String b = "abc";
	        System.out.println(numberNeeded1(a, b));
	    }
}
