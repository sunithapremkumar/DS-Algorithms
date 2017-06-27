package logical;

import java.util.ArrayList;

/**
 * CTCI page 184
 * 
 *  Given 2 arrays of integers, find a pair of values (one from each array) swaping which gives the 2 arrays same sum
 *  
 *  input = {4,1,2,1,1,2} & {3,6,3,3}
 *  o/p - {1,3}
 *  
 *  O(n+m) - complexity
 * @author suni
 *
 */
public class SumSwap {	
	
	/**
	 * ALGO - find total of both arrays
	 *  Find the diff
	 *  The value from 2 arrays would be that diff	
	 * @param arr1
	 * @param arr2
	 */
	public void sumSwap(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		
		int total1 = findTotal(arr1);
		int total2 = findTotal(arr2);
		if(total1 == total2)
			return;
		int diff = Math.abs(total1-total2);
		
		if((diff%2) != 0){
			System.out.println("diff is odd so we can't balance");
			return;
		}
		int target = diff/2;  //the difference between those 2 elements from each array should be of target.
		
		ArrayList<Integer> bigArray = (total1 > total2)? arr1:arr2;
		ArrayList<Integer> smallArray = (total1 > total2)? arr2:arr1;
		
		for(int i: smallArray){
			
			int x = i;
			int y = target + x;
			
			if(bigArray.contains(y)){
				System.out.println(x + "  " + y);
				return;
			}
		}
		System.out.println("Nothing found");
		
	}
	
	private int findTotal(ArrayList<Integer> list){
		int total = 0;
		for(int i : list)
			total +=i;
		
		return total;
	}
	
	public static void main(String arg[]){
		
		SumSwap obj = new SumSwap();
		ArrayList<Integer> arr1 = new ArrayList<>();
		arr1.add(4);
		arr1.add(1);
		arr1.add(2);
		arr1.add(1);
		arr1.add(1);
		arr1.add(2);
		
		ArrayList<Integer> arr2 = new ArrayList<>();
		arr2.add(3);
		arr2.add(6);
		arr2.add(3);
		arr2.add(3);
	
		obj.sumSwap(arr1, arr2);
	}
	
}
