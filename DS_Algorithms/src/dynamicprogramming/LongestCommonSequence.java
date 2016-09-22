package dynamicprogramming;

/*
 * Examples:
1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings. So length of LCS can be written as:
L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)

2) Consider the input strings “ABCDGH” and “AEDFHR. Last characters do not match for the strings. So length of LCS can be written as:
L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )

So the LCS problem has optimal substructure property as the main problem can be solved using solutions to subproblems.
 */
public class LongestCommonSequence {

	
	public int lcs(String str1, String str2, int str1_size, int str2_size){
		if(str1_size == 0 || str2_size == 0)
			return 0;
		
		if(compareLastChar(str1, str2)){
			String strip_str1 = str1.substring(0, str1_size-1);
			String strip_str2 = str2.substring(0, str2_size-1);
			return 1+ lcs(strip_str1,strip_str2, str1_size-1, str2_size-1);
		}
		else{
			
			String strip_str1 = str1.substring(0, str1_size-1);
			String strip_str2 = str2.substring(0, str2_size-1);
			return Math.max(lcs(strip_str1, str2, str1_size-1, str2_size), lcs(str1, strip_str2, str1_size, str2_size-1));
		}
			
		
	}
	
	public boolean compareLastChar(String s1, String s2){
		
		char a = s1.charAt(s1.length()-1);
		char b = s2.charAt(s2.length()-1);
		return (a == b);
	}
	
	public static void main(String arg[]){
		
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		System.out.println("LCS" + new LongestCommonSequence().lcs(str1, str2, str1.length(), str2.length()));
	}
}
