package recursion;

import java.util.ArrayList;
import java.util.HashSet;
/**
 *  CTCI - page 184
 * In old phones, each digit is mapped to a set of 0-4 letters. Implementa  aalgorithm to eturn a list of matchign words
 * given a sequence of digits. You are provided with a list of valid words.
 * @author suni
 *  Time complexity O(n *n!)
 */
public class PhoneWords {
	
	// Using recursion Base case and build approach
	//  i/p -8733 - tuv, pqrs, def, def
	// 8 - t,u,v
	// 87 - tp, tq, tr, ts, up,uq, ur, us, vp,vq,vr,vs   (Add chars from second set to all items in first set
	// 873 - Add chars from 3rd set to the each of the above list items.
	// continue this.
	
	public ArrayList<String>  getWords(String[] lettersequences, int size){
		
		if(size == 1){
			ArrayList<String> result = new ArrayList<>();
			char[] chars= lettersequences[size-1].toCharArray();
			for(char c: chars)
				result.add(c+"");
			return result;
		}else{
			
			 ArrayList<String>  res = getWords(lettersequences, size-1); // O(n)
			 String sequence = lettersequences[size-1];
			 return addToList(res, sequence);
			
		}
	}
	
	// O(n) - since  it contains all permutation of strings
	private ArrayList<String>  addToList(ArrayList<String> result, String sequence){
		ArrayList<String> newResult = new ArrayList<>();
		
		char[] sequenceChars = sequence.toCharArray();
		
		for(String s: result){
		
			for(char sequenceChar: sequenceChars){
			    newResult.add(s+sequenceChar);
			}
		
		}
		
		return newResult;
	}
	
	public static void main(String arg[]){
		
		
		PhoneWords obj = new PhoneWords();
		String[] lettersequences = {"tuv", "pqrs","def", "def"};
		HashSet<String> set = new HashSet<>();
		set.add("tree");
		set.add("used");
		ArrayList<String> res = obj.getWords(lettersequences, lettersequences.length);
		//System.out.println(res.size());
		for(String s: res){
			if(set.contains(s))
				System.out.println(s);
		}
	}

}
