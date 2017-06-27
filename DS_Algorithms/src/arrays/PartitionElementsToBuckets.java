package arrays;

import java.util.*;
/**
 * Given a sorted array with "n" elements, distributed them into "k" nearly equally weighing buckets. 

Space is not constraint. 

Ex: [1,3,6,9,10] 
bucket size: 3 

output:[10],[9,1],[3,6]

 * @author suni
 *
 */
public class PartitionElementsToBuckets {

	// ALGO - Create k lists by adding single element from last of the array.
	// Then find the smallest sum list add the other elements one by one to the smallest sum list.
public static List<List<Integer>> arraySplit(int[] arr, int k){
	List<List<Integer>> res = new ArrayList<>();
	int i = 0;
	for(i=arr.length-1; i>=(arr.length - k); i--){
		List<Integer> temp = new ArrayList<>();
		temp.add(arr[i]);
		res.add(temp);
	}
	//int c = 0;
	while(i>=0){
		int c = getListIndexWithMinSum(res);
		res.get(c).add(arr[i]);
		i--;
	}
	return res;
}

private static int getListIndexWithMinSum(List<List<Integer>> arr){
	int minIndex = 0;
	int minSum = Integer.MAX_VALUE;
	int i = 0;
	for(List<Integer> l:arr ){
		int currSum = sum(l);
		if(minSum > currSum){
			minSum = currSum;
			minIndex = i;
		}
		i++;
	}
	return minIndex;
}

private static int sum(List<Integer> arr){
	int sum = 0;
	for(int n: arr){
		sum += n;
	}
	return sum;
}
public static void main(String[] args){
	int[] arr = {1, 3, 6, 9, 10};
	List<List<Integer>> res = arraySplit(arr, 2);
	for(List<Integer> l: res){
		System.out.println(l);
	}
}
}