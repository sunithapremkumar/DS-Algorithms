package string;

/**
 * PAttern Matching using Knuth-Morris-Pratt (KMP pattern)
 * https://www.youtube.com/watch?v=GTJr8OvyEVQ
 * @author prasunit
 *  O(m+n) m = length of pattern and n=length of text
 */
public class PatternMatching {
	static int[] lcp;
	
	//Build temp array to store the position of j while matching
	public static void buildLcp(char[] pattern){
		
		 lcp = new int[pattern.length];
		for(int j=0,i=1; i < pattern.length; i++){
			
			while((pattern[i] != pattern[j]) && (j!=0)){
				j = lcp[j-1];
			}
			if(pattern[i] == pattern[j]){
				lcp[i] = j+1;
				j++;
			}
		}
		for(int k:lcp)
		  System.out.println(k);
		
	}
	
	public static void findPatternIndex(char[] text, char[] pattern){
		
		buildLcp(pattern);
		for(int i=0, j=0; i< text.length && j < pattern.length; ){
			
			if(text[i] == pattern[j]){
				if(j == pattern.length-1){
					System.out.println("Found pattern at " + (i-j));
				    j=0;
				}
				j++; i++;
			}
			else{
				if(j!=0)
					j = lcp[j-1];
				else
					i++;
			}
				
		}
	}
	
	//brute force O(n*m)
	public static int findIndex(char[] text, char[] pattern){
		
		for(int i=0; i< text.length; i++){
			for(int j=0; ; j++){
				if(j == pattern.length) return i;
				if(i+j >= text.length) return -1;
				if(pattern[j] != text[i+j])
					break;
			}
		}
		return -1;
	}
	
	public static void main(String...strings)
	{

		findPatternIndex("AABAACAADAABAAABAA".toCharArray(), "CAAD".toCharArray());
		
		System.out.println("New Pattern " + findIndex("AABAACAADAABAAABAA".toCharArray(), "CAAD".toCharArray()));
		//findPatternIndex("ABABABCABABABCABABAC".toCharArray(), "ABABAC".toCharArray());
		
	    //findPatternIndex("abxabcabcaby".toCharArray(), "abcaby".toCharArray());
	}
	

}
