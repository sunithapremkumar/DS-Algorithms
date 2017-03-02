package arrays;
/**
 * Given 2 sorted arrays, Array A is big enough to hold the Arrray B elements. Sort both arrays and have the merged 
 * result in Array A - CTCI
 * @author suni
 *
 */
public class SortedMerge {
	
	/**
	 * Merge sort algorithm.... fill up the arr from the end as we know it arrA has enough buffer.
	 * Since we fill from end.. start comparison from the last element instead of first element..
	 * Here the assumption is we know the size of arrA
		
	 */
	public void merge(int[] arr1, int[] arr2, int sizeA, int sizeB){
		
		if(arr1 == null || arr2 == null)
			return;
		
		int lastIndexA = sizeA -1;
		int lastIndexB = sizeB -1;
		int mergedLastIndex = sizeA + sizeB -1;
		while(lastIndexA >=0 && lastIndexB >=0){
			
			if(arr1[lastIndexA] > arr2[lastIndexB])
				arr1[mergedLastIndex--] = arr1[lastIndexA--];
			else
				arr1[mergedLastIndex--] = arr2[lastIndexB--];
			
		}
		
		while(lastIndexB >=0)
			arr1[mergedLastIndex--] = arr2[lastIndexB--];
	}
	
	
	public static void main(String arg[]){
		
		int[] arr1 = {1,2,5,7,8,9,0,0,0,0,0,0};
		int[] arr2 = {3,4,6,8};
		
		 new SortedMerge().merge(arr1, arr2, 6, arr2.length);
		 for(int i:arr1)
			 System.out.println(i);
	}

}
