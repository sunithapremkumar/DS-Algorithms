package arrays;

import java.util.*;

public class KthLargestElement {
	
	//O (nlog(k)) 
	public int getKthLargest(int[] arr, int k){
		
		if ((arr == null) || (k <=0))
			return -1;
		PriorityQueue<Integer> list = new PriorityQueue(k);
		for(int i : arr){
				list.add(i);
				if(list.size() > k) // keep evicting the lowest element if size > k
					list.remove();
		}
		
		return list.peek();
	}
	
	//Using quick sort algorithm.  Keep finding pivot position, if the pivot position is the kth then return, else if kth position < pivot
	// then search left else search right
	//  O (n)
	public int getKthLargest1(int[] arr, int k){
		
		int kloc =  arr.length - k;
		return findKth(arr, 0, arr.length-1,kloc );
	}
	
	private int findKth(int[] arr, int start, int end, int k){
		
		int leftPtr = start;
		int rightPtr = end-1;
		
		int pivot = arr[end];
		while(true){
			
			while(arr[leftPtr] < pivot)
				leftPtr++;
			while(arr[rightPtr] > pivot)
				rightPtr--;
			
			if(leftPtr>=rightPtr)
				break;
			swap(arr, leftPtr, rightPtr);
			
		}
		
		swap(arr, leftPtr, end);
		if(leftPtr == k)
			return pivot;
		else if(k < leftPtr)
			return findKth(arr, start, leftPtr-1, k);
		else
			return findKth(arr, leftPtr+1, end, k);
		
	}
	
	private void swap(int[] arr, int left, int right){
		
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
		
	}

	
	public static void main(String arg[]){
		
		int[] arr = { 1,12,3,5,9,6,0,8};
		KthLargestElement obj = new KthLargestElement();
		System.out.println(obj.getKthLargest(arr, 2));
		System.out.println(obj.getKthLargest1(arr, 2));
		
	}

}
