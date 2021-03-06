package string;

public class Palindrome {

	public boolean isPalindrome(String str){
	    if(str == null) 
	      return false;
	      
	    int start = 0;
	    int end = str.length() -1;
	    char[] cArr = str.toCharArray();
	    
	    while(start <= end){
	    	//skipping the non alpha numeric characters
	      while(start < end && !Character.isLetterOrDigit(cArr[start])) start++;
	      while(start < end && !Character.isLetterOrDigit(cArr[end]))end--;
	      
	     if(Character.toLowerCase(cArr[start]) != Character.toLowerCase(cArr[end]))
	          return false;
	      start++;
	      end--;    
	    
	    }  
		return true;
	}
	
	public static void main(String arg[]){
	 String s = "RAPPAR";
	   Palindrome obj = new Palindrome();
	   System.out.println(obj. isPalindrome(s));
	
	}
	
}
