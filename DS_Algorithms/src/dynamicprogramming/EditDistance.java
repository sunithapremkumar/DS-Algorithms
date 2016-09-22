package dynamicprogramming;

/*
 * If last characters of two strings are same, nothing much to do. Ignore last characters and get count for remaining strings. So we recur for lengths m-1 and n-1.
 * Else (If last characters are not same), we consider all operations on str1, consider all three operations on last character of first string, recursively compute minimum cost for all three operations and take minimum of three values.
 * Insert: Recur for m and n-1
 * Remove: Recur for m-1 and n
 * Replace: Recur for m-1 and n-1
 */

public class EditDistance {
	
	
	 public int editDistance(String str1, String str2, int m, int n){
		 
		 if(m ==0)
			 return n;
		 if(n == 0 )
			 return m;
		 
		 if(str1.charAt(m-1) == str2.charAt(n-1))
			 return editDistance(str1, str2, m-1,n-1);
		 
		 return 1+ min(editDistance(str1, str2, m, n-1), editDistance(str1, str2, m-1, n), editDistance(str1, str2, m-1, n-1));
	 }
	 
	 public int min(int x, int y, int z){
		 if((x <y) && (x <z))
			 return x;
		 else if((y <x) && (y < z))
			 return y;
		 else
			 return z;
	 }
	 
	 public static void main(String arg[]){
		 
		 String str1 = "Sunday";
		 String str2 = "Saturday";
		 
		 System.out.println(new EditDistance().editDistance(str1, str2, str1.length(), str2.length()));
	 }

}
