package arrays;

import java.util.Arrays;
/**
 * Given 2 arrays find the pair (one value in each array) with smallest difference . return the difference.
 * @author suni
 *
 */
public class SmallestDifference {

	int diff = Integer.MAX_VALUE;
	
	/**
	 * ALGO:  Sort both arrays. Find diff of first and first element in each array. 
	 * move the array pointer of the lower value array. Keep moving the pointer until any of the array reaches end
	 * 

	 * @return
	 */
	public int findSmallestDiff(int[] a, int[] b){
		
		Arrays.sort(a); // {1,2,11,15}
		Arrays.sort(b); // {4,12,19,127.235}
		
		int a_idx=0, b_idx=0;
		while(a_idx < a.length && b_idx < b.length){
			
			int curDiff = Math.abs(a[a_idx] - b[b_idx]);
			if(curDiff < diff)
				diff = curDiff;
			
			if(a[a_idx] < b[b_idx]) // Move lower value array pointer so that the diff becomes smaller
				a_idx++;
			else
				b_idx++;
		}
		
		return diff;
	}
	
	public static void main(String arg[]){
		
		int[] a ={2,11,1,15};
		int[] b= {12,4,127,23,19,235};
		System.out.println(new SmallestDifference().findSmallestDiff(a, b));
	}
}
