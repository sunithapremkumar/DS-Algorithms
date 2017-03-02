package sort;

public class RadixSort {
	
	// Just like counting sort except that it will be called as many times for each digit
	public void sort(int[] arr, int n, int exp){
		
		int[] count = new int[10];
		int[] output = new int[n];
		
		for(int i=0; i<n;i++){
			
			int nthdigit = (arr[i]/exp)%10; // takes the nth digit say 1st, 10th and 100th digit depending on the exp passed
			count[nthdigit]++;
		}
		//doing counting sort using the last digits
		for(int i=1; i<10;i++)
			count[i] = count[i] + count[i-1];
		
		// now the count arr contains the final index of the array elements.
		for(int i=0;i<n;i++){
			int nthdigit = (arr[i]/exp)%10;
			output[count[nthdigit]-1] = arr[i];
			count[nthdigit]--;
		}
		
		for(int i=0; i<n; i++)  //copy to the output arr to actual arr
			arr[i] = output[i];
	}
	
	private int findMax(int[] arr){
		int max = arr[0];
		for(int val:arr)
		{
			if(val > max)
				max = val;
		}
		return max;
	}
	
	public void radixSort(int[] arr){
		
		int max = findMax(arr); // to find the max number of digits
		
		for(int exp=1; max/exp> 0; exp*=10)
			sort(arr, arr.length, exp);
	}
	
	public static void main(String arg[]){
		
		int[] arr = {3,5,7,1,2,8};
		
		RadixSort obj = new RadixSort();
		obj.radixSort(arr);
		for(int i:arr)
			System.out.println(i);
	}

}
