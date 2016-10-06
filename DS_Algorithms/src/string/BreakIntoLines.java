package string;

/* * Q1 : Easy: Given a long string as input, break it into as many lines as possible such that each line is longer than the previous line. 
 * You can only break it at word boundaries (break at space). Print the number lines you are breaking it into, and how. Do it in constant space. 
 * 
 *   Q2 :  Easy-Moderate: Given a long string as input, break it into as many lines as possible such that each line is shorter than the previous line. You can use extra space.
 *   Q3:  Moderate-Hard: Do Q2. in constant space.
 * */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class BreakIntoLines
{
	
	public void printLines(String s){
		
		if(s == null) {
			System.out.println("0");
			return;
		}
		StringBuilder previous = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(s, " ");
		int count = 0;
		while(st.hasMoreTokens()){
		
		   StringBuilder current = new StringBuilder(st.nextToken());
		   while((current.length() <= previous.length()) && (st.hasMoreTokens())){
		       current.append(" "); current.append(st.nextToken());
		   }
		   if(current.length() > previous.length()){
		     System.out.print("\n"+current.toString());
		     count++;
		   }
		   else
			   System.out.print(" "+ current.toString());
		   previous = current;
		}
		System.out.println("\n"+count);
		
	}
	
	
	 public void printLinesReverse(String s){
			if(s == null) {
				System.out.println("0");
				return;
			}
			Stack<String> stack = new Stack<String>();
			
			StringTokenizer st = new StringTokenizer(s, " ");
			int count = 0;
			while(st.hasMoreTokens()){
			
			   StringBuilder current = new StringBuilder(st.nextToken());
			   String previous = (stack.isEmpty())? "" :stack.peek();
			   while((current.length() <= previous.length()) && (st.hasMoreTokens())){
			       current.append(" "); current.append(st.nextToken());
			   }
			   if(current.length() > previous.length()){
			     stack.push(current.toString());
			     count++;
			   }
			   else{
			       stack.push(stack.pop() + current.toString());
			   }
			}
			while(!stack.isEmpty())
				System.out.print("\n"+stack.pop());
			System.out.println("\n"+count);
		 
			
		 
	 }
	public static void main (String[] args) throws java.lang.Exception
	{
		//String s = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way--in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only.";
	    String s = "f fa  fa ba";
		BreakIntoLines o = new BreakIntoLines();
		o.printLines(s);
		o.printLinesReverse(s);
	}
}
