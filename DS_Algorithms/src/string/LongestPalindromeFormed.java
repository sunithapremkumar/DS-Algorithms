package string;

import java.util.*;

/**
 * Given a string, find the longest palindrome that can be constructed by removing or shuffling characters from the string. Return only one palindrome if there are multiple palindrome strings of longest length.

Examples:

Input:  abc
Output: a OR b OR c

Input:  aabbcc
Output: abccba OR baccab OR cbaabc OR
any other palindromic string of length 6.

Input:  abbaccd
Output: abcdcba OR ...
 * @author suni
 *
 */
public class LongestPalindromeFormed {

	private HashMap<Character, Integer> charCount = new HashMap<>();
	
	/*
	 * ALGO:  Since we need to find the longestpalindrome by shuffling, order doesn't matter.. All we need is the character count
	 * to form the palindrome. 1. So Precomute the character count. 
	 * 2. Each character count that are divisible by 2 will go in both ends. example - 5 cnt will be divided as 2 at begin and 2 at end
	 * 3. Any one character that is not divisible by 2 will be the mid one.
	 */
	public String longestPalindrome(String str){
		if(str == null || str.length() <=1)
			return str;
		
		countChars(str);
		
		StringBuilder beginString = new StringBuilder();
		StringBuilder endString = new StringBuilder();
		String mid = "";
		Set<Character> keys = charCount.keySet();
		for(char key : keys){
		    int cnt = charCount.get(key);	
		    int halfCnt = cnt/2;
		    if(halfCnt >0)
		    	addToBeginAndEnd(key, halfCnt, beginString, endString);
		    if(mid.equals("") && (cnt%2 ==1))
		    		mid = key+"";
		}
		
		return beginString.toString()+ mid + endString.toString();
		
	}
	
	private void addToBeginAndEnd(char c, int cnt, StringBuilder begin, StringBuilder end){
	    while(cnt>0){
	    	begin.append(c);
	        end.insert(0, c);
	        cnt--;
		}
		
	}
	
	private void countChars(String str){
		char chars[] = str.toCharArray();
		for(char c: chars){
			int cnt = charCount.getOrDefault(c, 0);
			charCount.put(c, cnt+1);
		}
	}
	
	public static void main(String arg[]){
		LongestPalindromeFormed obj = new LongestPalindromeFormed();
		System.out.println(obj.longestPalindrome("abbaccd"));
		
	}
	
}
