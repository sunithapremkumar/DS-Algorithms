package logical;

import java.util.*;
/**
 * Convert the integer to english
 * @author suni
 *
 */
public class EnglishInt {	
	
	private static String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
				"Eleven", "twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty" 
						};
	private static String[] tens = {"", "", "Twenty",  "Thirty", "Fourty", "Fifty",  "Sixty", "Seventy", "Eighty", "Ninety"};
	
	private static String[] bigs = {"", "Thousand", "Million", "Billion"};
	
	
	/**
	 * 123,345,123 - divide to chunks of 3 digits..  and convert each chunks. 
	 * o/p - One hundred twenty three million three hundred forty five thousand one twenty three
	 * @param n
	 * @return
	 */
	public String findEnglishInt(int n){
		if(n ==0)
			return smalls[n];
	   
		Stack<String> result = new Stack<>();;
		int chunkCount = 0;
		 while(n > 0){
			 
			 int chunk = n%1000;
			if(chunk >0){
			 String eng = " " +convertChunk(chunk)+ " " +bigs[chunkCount];
			 result.add(eng);
			}
			 n = n/1000;
			 chunkCount++;
		 }
		
		 return convertStackToString(result);
	}
	
	
	private String convertChunk(int num){
		
		StringBuffer buf = new StringBuffer();
		if(num >= 100){
			buf.append(smalls[num/100] + " Hundred");
			num = num % 100;
		}
		
		if(num >=10 && num <=19){
			buf.append(" " +smalls[num]);
		}else{
			buf.append(" " +tens[num/10]);
			num = num % 10;
			buf.append(" " +smalls[num]);
		}
		return buf.toString();
		
	}
	
	private String convertStackToString(Stack<String> st){
		StringBuffer buf = new StringBuffer();
		while(!st.isEmpty())
			buf.append(st.pop());
		
		return buf.toString();
	}
	
	
		
		 public static void main(String arg[]){
			  
			 EnglishInt obj = new EnglishInt();
			 
			 int n = 123345123;
			 
			 
			  String s = obj.findEnglishInt(n);
			  System.out.println(s);
		  }
		
		
	}
	

