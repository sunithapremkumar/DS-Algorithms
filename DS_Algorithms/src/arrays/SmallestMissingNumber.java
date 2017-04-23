package arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class SmallestMissingNumber {
	
	
	public int getSmallestMissing(int[] arr){
		HashMap map = new HashMap();
		int min = Integer.MAX_VALUE;
		int max = 0;
		//Get max and min from the array as well as updating the array element in Map
		for(int i=0;i <arr.length; i++){
			
			if(arr[i] < min)
				min = arr[i];
			if(arr[i] > max)
				max= arr[i];
			map.put(arr[i], true);
		}
		System.out.println("MIN:" + min);
		System.out.println("MAX:" + max);

		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        System.out.println(pair.getKey() + " = " + pair.getValue());
	    }

	    // Check if the map contains the element starting from Min incrementing 1 until i reaches max
		int next = min;
		while(next <= max){
			 next = next + 1;
			if(!map.containsKey(next))
				break;
		}
		return next;
	}
	
	//Method 2 if the array is You are given a list of n-1 integers and these integers are in the range of 1 to n.
	//There are no duplicates in list. One of the integers is missing in the list. 
	// Find total and subtract all numbers, the left out is the missing number	
	public int getSmallestMissing1(int[] arr){
		
	
		int n = arr.length; 
		int total = (n+1)*(n+2)/2; // can also use n(n+1)/2 formula where n is the max number in array
		for(int i=0; i< arr.length;i++){
			total = total - arr[i];
		}
		return total;
	}
	
	//Another method add all elements and divide by number of elelemntes in array which is the answer
	public static void main(String arg[]){
		
		int[] arr = {5,10,9,7,8};
		//int result = (new SmallestMissingNumber()).getSmallestMissing(arr);
		//System.out.println(result);
		
		int[] arr1 = {1,2,4,5,6};
		int result1 = (new SmallestMissingNumber()).getSmallestMissing1(arr1);
		System.out.println(result1);
	}

}
