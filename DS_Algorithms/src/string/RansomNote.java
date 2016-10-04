package string;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * A kidnapper wrote a ransom note but is worried it will be traced back to him. He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in the magazine, meaning he cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly using whole words from the magazine; otherwise, print No.
 * @author prasunit
 *
 */
public class RansomNote {

	 Map<String, Integer> magazineMap;
	 String note;
	    
	  public RansomNote(String magazine, String note) {
	        magazineMap = createMagazineMap(magazine);    
	        this.note = note;
	    }
	    
	    
	    private Map createMagazineMap(String s){
	        if(s == null)  return null;
	        HashMap<String, Integer> map = new HashMap<String, Integer>();
	        
	        try{
	        StringTokenizer st = new StringTokenizer(s, " ");
	        while(st.hasMoreTokens()){
	            String s1 = st.nextToken();
	            if(map.containsKey(s1)){
	                int cnt = map.get(s1);
	                map.put(s1, ++cnt);
	            }
	            else
	                map.put (s1, 1);
	        }
	        }catch(Exception e) { 
	            e.printStackTrace(); 
	            return map;
	        }
	        return map;
	    }
	    
	    public boolean solve() {
	        if (note == null || magazineMap == null) 
	            return true;
	        try{
	        StringTokenizer st = new StringTokenizer(note, " ");
	        while(st.hasMoreTokens()){
	            String s1 = st.nextToken();
	            if(magazineMap.containsKey(s1)){
	                int cnt = magazineMap.get(s1);
	                if(cnt == 1) 
	                    magazineMap.remove(s1);
	                else
	                    magazineMap.put(s1, --cnt);
	            }
	            else
	                return false;
	        }
	           }catch(Exception e) { 
	            e.printStackTrace(); 
	            return false;
	        }
	        return true;
	        
	    }
	    
	    public static void main(String...strings){
	    	
	    	String magazine = "give me one grand today night";
	    	String note ="give one grand today";
	    	
	    	System.out.println(new RansomNote(magazine, note).solve());
	    }
}
