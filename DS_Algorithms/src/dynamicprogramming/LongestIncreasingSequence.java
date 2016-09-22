package dynamicprogramming;

import java.util.*;


public class LongestIncreasingSequence {
	
	List longSeq = new ArrayList();
	/*
	 * Find the seq from a[0] till a[n] and again from a[1] till a[n] and continue until end.. Then store each list in a list and find the longest from the list.
	 * We can break if the size of the remaining array to be calculated is lesser than the  longestSeq found so far. 
	 */
	public List findSequence(int[] arr, int startIndex){

		for(int i=0;i<arr.length;i++){
			int newsize =  arr.length - i; // size of the array we are calculating the longest seq.
			if(newsize <= longSeq.size())
				break;
			List list = calcSeq(arr, i);
			if(list.size() > longSeq.size())
				longSeq = list;
			
		}
		return longSeq;
	}
	
	
	public List calcSeq(int[] arr, int index){
		
		Stack<Integer> list = new Stack<Integer>();
		list.add(arr[index]);
		for(int i= index+1; i <arr.length; i++){
			
			 if(arr[i] > list.peek())
				 list.add(arr[i]);
		}
		System.out.println(list);
		return list;
	}
	public static void main(String arg[]){
		
		int[] arr= { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		List l = new LongestIncreasingSequence().findSequence(arr, 0);
		System.out.println("Fianl"+ l);
	}

}
