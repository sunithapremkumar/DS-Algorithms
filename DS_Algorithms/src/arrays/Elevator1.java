package arrays;

import java.util.*;
/**
 * There is an elevator in a building with M floors. This elevator can take a max of X people at a time or max of total weight Y. Given that a set of people and their weight and the floor they need to stop, how many stops has the elevator taken to serve all the people? Consider the elevator serves in “first come first serve” basis and the order for the queue can not be changed.

Example:

Let Array A be the weight of each person A = [60, 80, 40].
Let Array B be the floors where each person needs to be dropped off B = [2, 3, 5].

The building has 5 floors, maximum of 2 persons are allowed in the elevator at a time with max weight capacity being 200. For this example, the elevator would take total of 5 stops in floors: 2, 3, G, 5 and finally G.
 * @author suni
 *
 */
public class Elevator1 {

	
	public int countStops(int[] weight, int[] fls, int maxWeight, int maxPerson){
		
		if(weight == null || fls == null)
			return 0;
		
		int index = 0, finalCnt =0;
		int tmpWeight =0, cnt =0;
		Set<Integer> set = new HashSet<>();
		while(index < weight.length){
			tmpWeight += weight[index];
			cnt++;
			
			if(cnt <= maxPerson && tmpWeight <=maxWeight){
				set.add(fls[index]);
				
			}else{
				if(set.size() >0){ //elevqtor is take off 
					finalCnt = set.size()+1; // need to come to grd floor
					tmpWeight = 0; 
					cnt =0; 
					set = new HashSet<>(); 
					continue;
				}
				
			}
			index++;
		}
		
		if(set.size() >0)
			finalCnt = finalCnt + set.size()+1;
		return finalCnt;
	}
	
	public static void main(String...strings){
		 
		 int[] A = {40, 40, 100, 80, 20};
		 int[] B = {3,3,2,2,3};
		 
		 System.out.println(new Elevator1().countStops(A, B, 200, 3));
		 
		 int[] A2 = {250};
		 int[] B2 = {2};
		 
		 System.out.println(new Elevator1().countStops(A2, B2, 200, 2));
		 
		
		int[] A1 = {80, 60,40 };
		 int[] B1 = {2,3,5};
		 
		 System.out.println(new Elevator1().countStops(A1, B1, 200, 2));
	 }
	
}
