
package string;

public class RemoveDuplicateChars {

  public String removeDupes(String str){
	  
	  int size = str.length();
	  boolean[] arr = new boolean[256];
	  StringBuffer buf = new StringBuffer();
	  for(int i=0; i< size; i++){
		  
		  int c = str.charAt(i);
		  if(!arr[c])
		  {
			  arr[c] = true;
			  buf.append(str.charAt(i));
		  }
	  }
	  
	  return buf.toString();
  }

public static void main(String arg[]){
	 
	System.out.println(new RemoveDuplicateChars().removeDupes("sauunithsa"));
}
}
