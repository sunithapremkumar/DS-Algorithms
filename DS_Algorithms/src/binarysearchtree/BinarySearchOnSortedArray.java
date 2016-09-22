package binarysearchtree;

public class BinarySearchOnSortedArray {
	
	
	public int binarySearch(int[] arr, int num, int low, int high){
		
		if(high <= low)
			return -1;
		int mid = (low + high)/2;
		
		if(num == arr[mid])
			return mid;
		else if(num < arr[mid]){
			high = mid;
		}
		else
			low = mid;
		 return binarySearch(arr, num, low, high);
		
	}
	
	public static void main(String ag[]){
		
		int[] arr = {2,5,6,8,9,12};
		System.out.println(new BinarySearchOnSortedArray().binarySearch(arr, 6, 0, arr.length-1));
		
	}

}
