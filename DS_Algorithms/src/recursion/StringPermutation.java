package recursion;

import java.util.ArrayList;
/**
 * Find permutation of a string with & without dupes
 * i/p - "ABC"
 * o/p = "ABC, CBA", BCA, BAC, ACB, CAB
 * @author suni
 *
 *Time complexity O(n* n!)
 */
public class StringPermutation {
	
	
	/**
	 * Algo: Base case and build approach
	 * A - A
	 * AB - AB, BA (insert last char at all positions in the previous list)
	 * ABC - CAB, ACB, ABC, CBA, BCA, BAC (insert last char at all positions in the previous list)
	 * @param str
	 * @param size
	 * @return
	 */
	public ArrayList<String> getPermutations(String str, int size){
		if(size ==0)
			return null;
		else{
			ArrayList<String> al = getPermutations(str, size-1);  // O(n) times loop
			int indexofCurChar = size -1;
			char c = str.charAt(indexofCurChar);
			if(str.indexOf(c) < indexofCurChar) // Check is for the str with duplicate chars.. we need to ignore  those dupes
				return al;
			else
				return addCharToList(al, c);
		}
		
	}

	 // O(n!) as the al contains all permutations.
	private ArrayList<String> addCharToList(ArrayList<String> al, char c){
		
		ArrayList<String> newList = new ArrayList<>();
		if(al == null){
			newList.add(c+"");
			return newList;
		}

		for (String str : al) {
			int index = 0;
			while (index <= str.length()) { // inserting the char 'c' at all
											// positions in String 'str'
				StringBuffer buf = new StringBuffer(str);
				String newStr = buf.insert(index, c).toString();
				newList.add(newStr);
				index++;
			}
		}

		return newList;
	}
	
	public static void main(String arg[]){
		String s= "ACBCB";
		StringPermutation obj = new StringPermutation();
		ArrayList<String> permList = obj.getPermutations(s, s.length());
		for(String s1:permList)
			System.out.println(s1);
		
	}
}
