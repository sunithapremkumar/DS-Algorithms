package string;

import java.util.*;

/*
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. For example, given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 */
public class WordLadder {

	//ALGO: 
	// 1. It's nothing but breadth first search. Add start word in queue
	// 2. Find all possible combination of that word by changing each letter to(a-z) and check each new word if exist in dic, then add to queue that form a path
	// 3. Do this for each word in queue until we see a word same as end which means we reached the end.
	// $. Keep track of the ladder height at each level.
	public int ladderLength(String start, String end, Set<String> dic){
		
		LinkedList<Word> queue = new LinkedList<>();
		queue.add(new Word(start, 1));
		dic.add(end);
		while(!queue.isEmpty()){
			
			  Word curWord = queue.remove();
			  
			  if(curWord.word.equals(end))
				  return curWord.steps;
			  
			  char[] arr = curWord.word.toCharArray();
			  for(int i= 0 ; i< arr.length; i++){ // find all possible combinations of each letter in hit.
				  char temp = arr[i];
				   for(char c='a'; c <= 'z'; c++){   
					   if(arr[i] != c)
						   arr[i] = c;
					
					   String newWord = new String(arr);
					   if(dic.contains(newWord)){
						   queue.add(new Word(newWord, curWord.steps+1));
						   dic.remove(newWord);				   
					   }
					   arr[i] = temp;   
				   }
			  }
		}
		
		return 0;
		
	}
	
	public static void main(String arg[]){
		
		WordLadder lad = new WordLadder();
		Set<String> dic = new HashSet<>();
		dic.add("hot");
		dic.add("dog");
		dic.add("dot");
		dic.add("lot");
		dic.add("log");
		System.out.println(lad.ladderLength("hit", "cog", dic));
	}
	class Word{
		String word;
		int steps;
		public Word(String w, int s){
			word = w;
			steps = s;
		}
	}
}
