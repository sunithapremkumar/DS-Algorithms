package string;

import java.util.*;
/**
 * Check if a given string is  a permutation of a palindrome
 * 
 * I/p - "TACt COA"
 * o/p - true [TACOCAT, ACTOTCA etc]
 * @author suni
 *
 */
public class PalindromePermutation {
	
	HashMap<Character, Integer> charCount = new HashMap<>();
	
	/**
	 * ALGO - If a string is a palindrome then the character count should be even if the total count of character is evne
	 * if the total count is odd, then except 1 character all other should count even. which means there can  be no more than 1 character
	 * with counts to 1 (or odd)
	 * @param str
	 * @return
	 */
	public boolean isPalindromePermutation(String str){
		 if(str == null)
			 return false;
		 countChars(str);  // do character count
		 Set<Character> set = charCount.keySet();  //check if more than 1 character is odd.. if so false.
		 boolean foundOdd = false;
		 for(char c: set){
			 if(charCount.get(c)%2 == 1){
				 if(foundOdd)
					 return false;
				 foundOdd = true;
			 }
		 }
	 return true;
	}
	
	private void countChars(String str){
		
		for(char c: str.toCharArray()){
			int count =charCount.getOrDefault(c, 0);
			charCount.put(c,  count++);
		}
		
	}
	
	/**
	 * Solution 2 - using bit vector
	 *  have a bit vector int which holds 32 bit, Whenever we see a character, toggle that bit in the bit vector. finally check if the 
	 *  vector should have all zero or only 1 bit set (meaning only 1 character count be odd)
	 */
	public boolean isPalindromePermutation2(String str){
		//creating bitvector
		int bitVector =0;		
		for(char c: str.toCharArray()){
			
			  int index = getCharNumber(c);
			  bitVector = toggleBit(bitVector, index);
			  
		}
		//checking the vector
		return checkBitVector(bitVector);
	}
	
	private int toggleBit(int bitVector, int index){
		if(index < 0) 
			return bitVector;
		
		int mask = 1<<index;
		
		if((bitVector & mask) == 0){ // index bit is 0, so set it to 1
			bitVector = bitVector | mask;  //set the bit
		}else{
			bitVector = bitVector & ~mask; //clear the bit
		}
		return bitVector;
	}
	
	private boolean checkBitVector(int vector){
		return (vector == 0 || checkExactlyOneBit(vector));
	}
	
	// if x& (x-1) == 0 then only 1 bit set.
	private boolean checkExactlyOneBit(int v){
	    
		return ((v & (v-1)) == 0);     
	}
	
	
	private int getCharNumber(char ch){
		
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		
		int c = Character.getNumericValue(ch);
		
		if(a <= c && c <= z){  //inout char is between a and z
			
			return (c-a);
		}
		return -1;
	}
	
	public static void main(String arg[]){
		
		String  s ="tact coa";
		
		PalindromePermutation obj = new PalindromePermutation();
		System.out.println(obj.isPalindromePermutation(s));
		System.out.println(obj.isPalindromePermutation2(s));
	}

}
