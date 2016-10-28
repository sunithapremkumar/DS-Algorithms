package arrays;

/**
   Keep adding, if the sum becomes negative, then reset the running sum to zero and continue adding. Keep track of the maxSum apart of runnigSum. If runningSum > maxSum 
   update maxSum. 
   Kadane's algorithm
   
 * @author prasunit
 *
 */
public class LargestSumContiguousSubarray {

	public static void printLargestContigousSubarray(int arr[], int size){
	//Todo Need to handle the case if all elements are -ve. sweep thru array and return the 
		
	int runningSum =0, maxSum =0;
    int startIndex =0, endIndex =0;
   
    for(int i=0; i< size; i++){
 
      if (runningSum == 0)
          startIndex = i;  
      runningSum += arr[i];
      
      if(runningSum < 0){ // Reset the running sum if it goes negative as that won't contribute to the max sub array
        runningSum = 0;
       } 
       
       if(maxSum < runningSum){
      	 maxSum = runningSum;
     	  endIndex = i;
       }	
	 }
	 
	 System.out.println(" start index: "+ startIndex + "  Endindex: "+ endIndex);
	}
	
	public static void main(String...strings){
		
		int[] arr = {4,-3, 2, -10, 3, 2, -1,2,-1};
		int size = arr.length;
		printLargestContigousSubarray(arr, size);
	}
	
}
