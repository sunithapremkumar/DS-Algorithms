package logical;

import java.util.*;

/**
 * CTCI
 * 
 * The computer has 4 slots and each slot will contain a ball that is R, Y, G, B. For example the computer might
 * have RGGB (slot 1 is red, slot 2 and 3 are gree and slot 4 blue. User are free to guess the solution.
 * When you guess the correct color for the correct slot you get a hit. If you guess a color that exists but in wrong slot you get a 
 * pseudo hit. Not that slot that is hit can never count as a psedu-hit.
 * WRite a method given a gues and solution, returns the number of hits and pseudo hits
 * @author suni
 *
 */
public class MasterMind {
	
	/**
	 * Have hits and pseudo hits Set which stores the char (no duplicates). Here we need to make sure that both sets are
	 * data are unique across meaning if a char is in hit Set then it should not be in pseudo hit set. That uniquess
	 * need to be taken care.
	 * @param soln
	 * @param guess
	 * @return
	 */
	public Result getCount(String soln, String guess){
		
		if(soln == null || guess == null)
			return null;
		if(soln.length() != guess.length())
			return null;
		
		char[] sln = soln.toCharArray();
		char[] gus = guess.toCharArray();
			
		Set<Character> hitSet = new HashSet<>();
		Set<Character> pseudoSet = new HashSet<>();
		
		for(int i=0; i< gus.length; i++){
			char curChar = gus[i];
			if(curChar == sln[i]){
				hitSet.add(curChar);
				if(pseudoSet.contains(curChar)) // If pseudo set already has this char, then remove as that char is counted in hit list
					pseudoSet.remove(curChar);
			}else{
				int index = soln.indexOf(gus[i]); //chek if this char appears anywhere in soln. if so add to pseudo list
				if(index != -1){
					if(!hitSet.contains(curChar)) //if this char is already in hit list then don't count in pseudo list
						pseudoSet.add(curChar);
				}
					
			}
		}
		int hits = hitSet.size();
		int pseudohits = pseudoSet.size();
		return new Result(hits, pseudohits);
		
	}
	
	//This class is just to hold the result set.
	public class Result{
		
		int hits =0;
		int pseudoHits = 0;
		
		public Result(int hits, int pseudo){
			this.hits = hits;
			this.pseudoHits = pseudo;
		}
	}
	
	public static void main(String arg[]){
		MasterMind obj = new MasterMind();
		Result  res = obj.getCount("YGBR", "GGRR");
		if(res != null)
			System.out.println("Hits " +res.hits + " Pseudo hits "+ res.pseudoHits);
		else
			System.out.println("NULL");
	}

}
