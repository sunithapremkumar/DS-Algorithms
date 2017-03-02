package sort;

public class QuickSort {
	
	
	public void sort(int[] arr, int left, int right){
		if(left>=right)
			return;
		long pivot = arr[right];
		int partition = partitionIt(arr, left, right, pivot);
		
		sort(arr, left, partition-1);
		sort(arr, partition+1, right);
	}

	
	private int partitionIt(int[] arr, int left, int right, long pivot){
		
		int leftPtr = left-1;
		int rightPtr = right;
		while(true){
			while(arr[++leftPtr] < pivot) // move left ptr until the element is < pivot.
				;
			
			while(arr[--rightPtr] > pivot) // move right ptr until the element is >  pivot.
				;
		
			if(leftPtr >= rightPtr)
				break;
			swap(arr, leftPtr, rightPtr);
		}
		swap(arr, leftPtr, right);
		return leftPtr;
	}
	
	private void swap(int[] arr, int left, int right){
		
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
	
	public static void main(String arg[]){
		
		int[] arr = {3,5,7,1,2,8};
		
		QuickSort obj = new QuickSort();
		obj.sort(arr,  0,  arr.length-1);
		for(int i:arr)
			System.out.println(i);
	}
}
