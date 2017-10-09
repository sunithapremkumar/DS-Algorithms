package string;
/**
 * if we reverse word by word, sicne the words are of diff length, scooting happens which costs O(n^2).
 * So reverse the entire sentence and again reverse word by word which costs O(n)
 * @author suni
 *
 */
public class ReverseWords {
	
	   // O(n)  time and O(n) space. We can also do it with 2 passes by splitting string with space in first pass and constructing the string from reverse in second pass.
	  // But we can do better with single pass as below by keeping track of start and end of word
	    public static String reverseWords(String s) {
	        if(s == null || s.trim().length() ==0)
	           return "";
	        String s1 = s.trim();
	        int end = s1.length(); 
	        StringBuilder str = new StringBuilder();
	        for(int i=s1.length()-1; i>= 0; i--){
	            if(s1.charAt(i) == ' ')  //if we have multiple spaces ignore those
	               end = i;
	            else if(i == 0 || s1.charAt(i-1) == ' '){ //starting point of a word
	              if(str.length() !=0) str.append(" ");    
	              str.append(s1.substring(i, end));
	            }
	        }
	        return str.toString();
	    }
	    
	    //O(n) time O(1) space.
	    //reversing it twice.. first time reverse entire string. .second time reverse word by word.
	    public static String inPlaceReverse(char[] c){
	    	reverse(c, 0, c.length-1);
	    	int start = 0;
	        for(int i=0; i< c.length; i++){
	        	if(c[i] == ' ' || i == c.length-1){
	        		if(i == c.length-1) 
	        			reverse(c, start, i);
	        		else
	        			reverse(c, start, i-1);
	        	    start = i+1;
	        	}
	        }
	    	return new String(c);
	    }
	    
	    private static void reverse(char[] c, int start, int end){
	
	    	while(start< end){
	    		char tmp = c[start];
	    		c[start] = c[end];
	    		c[end] = tmp;
	    		start++;
	    		end--;
	    	}
	    }
	public static void main(String arg[]){
		
		//System.out.println(ReverseWords.reverseWords("sky is blue"));
		System.out.println(ReverseWords.inPlaceReverse("sky is blue".toCharArray()));

	}

}
