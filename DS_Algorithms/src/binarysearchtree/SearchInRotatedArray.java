package binarysearchtree;
/**
 * Search an element in a sorted array which is rotated n times..
 * @author suni
 *
 */
public class SearchInRotatedArray {
	
	/**
	 * Algo:  Same as BST. In BST we just search left or right depending on whichever side x lies.
	 * Here since array is rotated, one side of array may not be sorted.. So instead of searching on any side.. search first 
	 * on the side which is ordered, if x doesn't lie in that side, then search the other side.
	 */
	public int search(int[] arr, int left, int right, int x){
		
		if(left > right)
			return -1;
		
		int mid = (left+right)/2;
		if(arr[mid] == x)
			return mid;
		
		if(arr[left] < arr[mid]) { //left side is sorted.. 
			
			if(x >= arr[left] && x < arr[mid])  //So first check if x lies in this side.
				return search(arr, left, mid-1, x);
			else
				return search(arr, mid+1, right, x);  //else search right side
			
		}else if (arr[mid] < arr[right]) {//right side sorted.. 
			
			if(x >arr[mid] && x <=arr[right])
				return search(arr, mid+1, right, x); //first check if x lies in right side.
			else
				return search(arr, left, mid-1, x);
		}
		
		return -1;
	}
	
	public static void main(String arg[]){
		
		int[] arr = {15,16,19,20,1,3,4,5,7,10,14};
		
		int l = new SearchInRotatedArray().search(arr, 0, arr.length-1,7);
		
		System.out.println(l);
	}

}
