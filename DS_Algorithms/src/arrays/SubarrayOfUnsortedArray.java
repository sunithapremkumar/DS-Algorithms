package arrays;
//Find a sub array of an unsorted array sorting which will sort the entire array
public class SubarrayOfUnsortedArray {

	
	
	public static void findSubArray(int[] arr){
		
		int max = 0;
		int endIndex = -1;
		//traverse from 0 -> n-1 keeping max so far and make note of the last position that is not greater than the max so far as R.
		for(int i=0; i<arr.length; i++){
			
			int cur = arr[i];
			if(cur > max)
				max = cur;
			else if (cur < max){
				endIndex = i;
			}
			
		}
		int min = Integer.MAX_VALUE;
		int beginIndex = -1;
		//traverse from n-1 -> 0 keeping min so far and make note of the last position that is not lesser than the min so far as L.
		for(int i=arr.length-1; i>=0; i--){
			
			int cur = arr[i];
			if(cur < min)
				min = cur;
			else if (cur > min){
				beginIndex = i;
			}
			
		}
		//Sort array from L to R	
		
		System.out.println(" Index : " + beginIndex + " :" + endIndex);
	}
	
	public static void main(String arg[]){
		
		int arr [] = {10,12,20,30,25,40,32,31,35,50,60};
		
		findSubArray(arr);
	}
	
}
