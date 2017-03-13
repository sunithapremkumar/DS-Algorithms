package string;
/**
 * CTCI page 90
 * Write a method to replace all spaces in a string with '%20'. You may assume thqt the string has sufficient space at
 * the end to hold the additional characters and that you are given the true length of the string.
 * @author suni
 *
 */
public class URLify {

	
	  public String urlify(String s, int length){
		  if(s == null || length<=0)
		     return s;
		  char[] cArr = s.toCharArray();
		  
		  int end = cArr.length-1;
		  int actualEndIndex = length -1;
		  while(actualEndIndex >=0){
		  
		      char c = cArr[actualEndIndex];
		      if(c == ' '){
		         cArr[end--] = '0';
		         cArr[end--] = '2';
		         cArr[end] = '%';
		      }else{
		    	  cArr[end] = c;
		       
		      }
		  	  actualEndIndex--;
		      end--;
		  }
		  return new String(cArr);
	  }
	  
	  public static void main(String arg[]){
	    String s = "Mr John Smith    ";
	    URLify obj = new URLify();
	    System.out.println(obj.urlify(s, 13));
	  
	  }
}
