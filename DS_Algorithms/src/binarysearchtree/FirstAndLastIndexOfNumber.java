package binarysearchtree;

/**
 *  Given an array of sorted integers with duplicates in it. Find the first occurance and last occurance of a number.
 * @author prasunit
 *  O(logn) time complexity
 */
public class FirstAndLastIndexOfNumber {
	
	
	public static void find(int[] arr, int num){
		// Finding some index of that number
		int startIndex = findFirstIndex(arr, 0, arr.length-1, num);
		int endIndex = findLastIndex(arr, 0, arr.length-1, num);
		// Now knowing some position of the number. Sliding left and right will find the start and the end index of that number.
		//sliding left
	
		System.out.println("start Index: " + startIndex + "End Index: " + endIndex);
	}
	
	
	private static int findFirstIndex(int[] arr, int start, int end, int num){
		
		if(start > end)
			return -1;
		
		int mid = (start+end)/2;
		if(num == arr[mid] && ((mid == 0) || (arr[mid-1] < num)))
			return mid;
		if(num > arr[mid]){
			return findFirstIndex(arr, mid+1, end, num);
		}else{
		
			return findFirstIndex(arr, start, mid -1, num);
		}
		
	}
	
	private static int findLastIndex(int[] arr, int start, int end, int num){
		
		if(start > end)
			return -1;
		
		int mid = (start+end)/2;
		if((num == arr[mid]) && ((mid == (arr.length-1)) || (arr[mid+1] > num)) )
			return mid;
		if(num > arr[mid]){
			return findFirstIndex(arr, mid+1, end, num);
		}else{
		
			return findFirstIndex(arr, start, mid -1, num);
		}
		
	}
	
	
	public static void main(String...strings )
	{
		int[] ar = {1,2,5,5,6,7,8};
		find(ar, 5);
	}

}
