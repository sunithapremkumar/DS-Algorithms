package string;
/**
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.
 * @author suni
 *
 */
public class LongestSubStringWithoutRepeatingChar {
	//O(n) time O(1) space
	// Keep track of runningLength and longestLength. if the char appears in the cur substring, reset the runningLength
    public static int lengthOfLongestSubstring(String s) {
       if(s == null || s.trim().length() == 0)
          return 0;
       String s1= s.trim();
       int longestSubStringL = 0; // maxLongest
       int start =0, end=0; // running length
       char[] cArray = s1.toCharArray();
       for(int i=0; i<cArray.length; i++){
           int index = s1.indexOf(cArray[i], start);
           if( index >= start && index < i){ // check if the cur char appeared anywhere before in the current substring
               int runningLength = end-start +1;
               longestSubStringL = Math.max(longestSubStringL, runningLength);
               start = index+1;end = i;
           }else{
              end = i; // keep moving end if the chars are different
           }
       }
       int runningLength = end-start +1;
       longestSubStringL = Math.max(longestSubStringL, runningLength);
       return longestSubStringL;
   }
    // O(n) time and O(n) space
    public int lengthOfLongestSubstring1(String s) {
        if(s == null || s.trim().length() == 0)
           return 0;
        String longestSubString = "";
        StringBuilder runningSubString = new StringBuilder();
        char[] cArray = s.trim().toCharArray();
        for(int i=0; i<cArray.length; i++){
            
            if(runningSubString.indexOf(cArray[i]+"") == -1){
                runningSubString.append(cArray[i]);
            }else{
                if(runningSubString.length() > longestSubString.length())
                  longestSubString = runningSubString.toString();
                runningSubString = new StringBuilder(cArray[i]+"");
            }
        }
        return longestSubString.length();
    }
    public static void main(String arg[]){
    	System.out.println(LongestSubStringWithoutRepeatingChar.lengthOfLongestSubstring("dvdf"));
    }
}
