package string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 * @author suni
 *
 */
public class LongsetPalindromeSubstring {
	//ALGO - 1. lopp thru each char in S.
	// 2. since palindrome string starts and ends with same letter. For each char find its occurance in the string starting from end..
	// 3. this is for the reason we need the longest substring. if there is a same char at the end then check if that substring is palindrome
	// 4. continue step 2 & 3 for the same char until it reaches the cur index. Record the max whenever needed
	// 5. proceed to next char in s
	//O (n^2) time O(n) space
	 public String longestPalindrome(String s) {
	        if(s == null || s.length() == 1)
	          return s;
	        char[] cArr = s.toCharArray();
	        String longestPalindrome = "";
	        
	        for(int i=0; i< cArr.length; i++){
	              char cur = cArr[i];
	              int from = cArr.length;
	              while(s.lastIndexOf(cur, from) >= i){ // check the occurance of the cur char from end till i.
	                  int index = s.lastIndexOf(cur, from);
	                  String sub = s.substring(i,index+1);
	                  boolean palin = isPalindrome(sub);
	                  if(palin){
	                      if(sub.length() > longestPalindrome.length())
	                         longestPalindrome = sub;
	                      break;
	                  }
	                  from = index-1; // exclude this occurance
	              }
	             
	        }
	        return longestPalindrome;
	    }
	    
	    private boolean isPalindrome(String s){
	        int start =0;
	        int end =s.length() -1;
	        char[] c = s.toCharArray();
	        while(start < end){
	            if(c[start] != c[end])
	              return false;
	             start++;
	             end--;
	        }
	        return true;
	    }
	    
	    public static void main(String arg[]){
	    	LongsetPalindromeSubstring obj = new LongsetPalindromeSubstring();
	    	System.out.println(obj.longestPalindrome("babcbcbabw"));
	    	System.out.println(obj.longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez"));

	    }
}
