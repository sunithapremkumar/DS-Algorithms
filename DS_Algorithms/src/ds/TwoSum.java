package ds;

import java.util.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

add(1); 
add(3); 
add(5);
find(4) -> true
find(7) -> false
 * @author suni
 *
 */
public class TwoSum {

	// Use TreeSet if we wan sorted set but no duplicates. If we want sorted list with duplicates use list but explicitly sort else use TreerMap
	/*Set<Integer> list = new TreeSet<>();
	
	public void add(int i){
		list.add(i);
		//Collections.sort(list);
	}
	
	public boolean find(int i){
		
		Integer[]  array = (Integer[]) list.toArray(new Integer[0]);
		
		int start = 0, end = array.length -1;
		
		while(start < end){
			
			 int tot = array[start] + array[end];
			 if(tot == i)
				 return true;
			 if(tot < i)
				 start++;
			 else
				 end--;
		}
		return false;
	}*/
	
	HashMap<Integer, Integer> map = new HashMap<>();
	
	public void add(int i){
		
		if(map.containsKey(i))
			map.put(i, map.get(i)+1);
		else
			map.put(i, 1);
	}
	
    public boolean find(int value){
		
    	for (Integer i : map.keySet()) {
			int target = value - i;
			if (map.containsKey(target)) {
				if (i == target && map.get(target) < 2) {
					continue;
				}
				return true;
			}
		}
		return false;
	}
	//Find if pair exist for a sum in a given int[]. array can have duplicate and negatives
   public static boolean doesPairExist(int[] arr, int sum)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i: arr){
			
			if(map.containsKey(i))
				map.put(i,  map.get(i) +1);
			else
				map.put(i, 1);
		}
	
		for(int i: arr){
			int otherNum = sum - i;
		
			if(map.containsKey(otherNum)){
				 if(otherNum == i && map.get(otherNum) <= 1)
						continue;
			     return true;
			}
		 }
		
		return false;
		}
	
	 public static void main(String arg[]){
		 
		 TwoSum sum = new TwoSum();
		 sum.add(3);
		 sum.add(1);
		 sum.add(7);
		 sum.add(1);
		 sum.add(-3);
		 System.out.println(sum.find(4));
		 System.out.println(sum.find(2));
		 
	 }
}
