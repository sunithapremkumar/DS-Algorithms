package recursion;

import java.util.*;
/**
 *  You are building a diving board by placing a bunch of planks if wood end to end. There are 2 types of planks
 *  one of length short and  another of length long. You must use exactly k planks of wood. Find all possible lengths
 *  for he diving  board.
 * @author suni
 *
 */
public class DivingBoard {

	
	public List<List<Character>> getPossibleLengths(int planks){
		if(planks ==1){
			ArrayList<List<Character>> outer = new ArrayList<>();
			ArrayList<Character> inner = new ArrayList<>();
			inner.add('S');
			outer.add(inner);
			ArrayList<Character> inner1 = new ArrayList<>();
			inner1.add('L');
			outer.add(inner1);

			return outer;
		}
		
		List<List<Character>> list = getPossibleLengths(planks-1);
		List<List<Character>> newList = addToList(list);
		
		return newList;
		
	}
	
	public List<List<Character>> addToList(List<List<Character>> list){
		
		List<List<Character>> newList = new ArrayList<>(list);
		for(List l : list){ // Take each element in the list and add 'S' and 'L' to it.
               ArrayList<Character> row = new ArrayList<>(l);			
			   row.add('S');
			   newList.add(row);
			   
			   ArrayList<Character> row1 = new ArrayList<>(l);			
			   row1.add('L');
			   newList.add(row1);
		}
		return newList;
	}
	//CTCI
/*	public HashSet<Integer> allLengths(int k, int shorter, int longer){
		HashSet<Integer> lengths = new HashSet<Integer>();
		getAllLengths(k, 0, shorter, longer, lengths);
		return lengths;
	}
	
	public void getAllLengths(int k, int total, int shorter, int longer, HashSet<Integer> lengths){
		
		if(k ==0){
			lengths.add(total);
			return;
		}
		
		getAllLengths(k-1, total + shorter, shorter, longer, lengths);
		getAllLengths(k-1, total + longer, shorter, longer , lengths);

	}*/
	public static void main(String arg[]){
		
		DivingBoard obj = new DivingBoard();
		List<List<Character>> result = obj.getPossibleLengths(2);
		
		//print
		for(List<Character> l : result){ 
			
			for(char c : l){
				System.out.print(c);
			}
			System.out.println("");
		}
		
		/*HashSet<Integer> set =obj.allLengths(2, 5,5);
		
		Iterator ite = set.iterator();
		while(ite.hasNext())
			System.out.println(ite.next());
		*/
	}
}
