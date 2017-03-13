package arrays;

import java.util.*;
/**
 * CTCI page 185
 * 
 * Find all pairs of integer within an array that sums up to a specified value
 * @author suni
 *
 */
public class PairSum {

	// If no duplicates
	// Store the complement (sum-arr[i])in a hashset (which is what we want to be in array and check if the array element exist 
	// in that set. If so we found a pair.
	public void findPairSum(int[] arr, int sum){
		
		HashSet<Integer> complimentSet = new HashSet<>();
		
		if(arr == null)
			return;
		
		for(int i: arr){			
			
			if(complimentSet.contains(i)){
				System.out.println(i + " " + (sum-i));
			}else{
				int comp = sum - i;
				complimentSet.add(comp);			
			}
		}
		
	}
	
	//If it has duplicates in arr
	// Store the unpaired elements in a map with its count. If we find a pair then remove that from map (reduce its count) so that it
	// won't be counted in further processing
  public void findPairSumWithDupes(int[] arr, int sum){
		
		HashMap<Integer, Integer> unpaired = new HashMap<>();
		
		if(arr == null)
			return;
		
		for(int i: arr){			
			int comp = sum - i;
			if(unpaired.getOrDefault(comp,0) > 0){
				System.out.println(i + " " + comp);
				adjustCount(unpaired, comp, -1); // do not consider this item  further as it is already paired.
			}else{
				adjustCount(unpaired, i, 1); // add this item to unpaired map
						
			}
		}
		
	}
  
  private void adjustCount(HashMap<Integer, Integer> map, int key, int adjustment){
	  
	 int val =  map.getOrDefault(key,0);
	 map.put(key, val + adjustment);
  }
  
  
  
	public static void main(String arg[]){
		
		PairSum obj = new PairSum();
		int[] arr= {2, 3,7,1,4,3,4};
		int sum = 6;
		obj.findPairSum(arr, sum);
		System.out.println("                   ");
		obj.findPairSumWithDupes(arr, sum);
	}
}
