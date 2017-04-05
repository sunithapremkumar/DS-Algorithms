package string;

import java.util.HashMap;
/**
 * CTCI page 91
 * There are 2 types of edits that can be performed on string, insert a char, delete a char, replace a cjar. given 2 strings write a function to check
 * if they are one (or zero edit) edit away
 * 
 * Example
 * pale, ple = true
 * pales, pale = true
 * pale, bale = true
 * pale, bake = false
 * 
 * @author suni
 *
 */
public class OneAway {
	
	
	public boolean isOneAway(String str1, String str2){
		
		if(str1 == null || str2 == null) 
			return false;
		if((str1.length()-str2.length()) > 1)
				return false;
		if(str1.equals(str2))
			return true;

		HashMap<Character, Boolean> str2Map = new HashMap<>();
		for(char c: str2.toCharArray()){
			str2Map.put(c, true);
		}

		char[] str1Char = str1.toCharArray();
		int extraInStr1Count = 0;
		boolean oneaway = false;
		for(int i=0; i<str1Char.length; i++){
			char c = str1Char[i];
			int index = str2.indexOf(c+"");
			if(index == -1){
				extraInStr1Count++; // Keeping track of extra in str1
				if(extraInStr1Count > 1) 
					return false;
				continue;
			}
			if(Math.abs(index-i) >1) {// no way or 1 way away good else return
			   return false;
			}else if(Math.abs(index-i) == 1) // keep track of shifts
				oneaway = true;
			str2Map.remove(c); // Keeping track of extra in str2
		}
		

		if((str1.length() == str2.length()) && !oneaway){ // equal length then there should be only 1 char replace and no shift shud be there
			if(extraInStr1Count ==1 && str2Map.size() == 1) //both string should have 1 element extra
					return true; 
		}else if (str1.length() != str2.length()){ //string length not equal
			if((extraInStr1Count ==1 && str2Map.size() == 0) || (extraInStr1Count ==0 && str2Map.size() == 1))	
					return true;
		}
		return false;
	}
	
	public static void main(String arg[]){
		
		OneAway obj = new OneAway();
		String str1 = "ple"; //"palo";
		String str2 = "lpes";//"aplw";
		System.out.println(obj.isOneAway(str1, str2));
	}

}
