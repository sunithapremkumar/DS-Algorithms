package arrays;
import java.util.Arrays;

//http://www.geeksforgeeks.org/counting-sort/
public class CountingSort {

	
	public void sort(int[] arr){
		
		int[] count = new int[255];
		int[] output = new int[arr.length];
		Arrays.fill(count, 0);
		
		for( int i= 0; i< arr.length; i++){
			++count[arr[i]];
		}
		
		
		for(int i=1; i< count.length; i++){
			count[i] = count[i] + count[i-1];
		}
		
		for(int i=0; i< arr.length; i++){
			 output[count[arr[i]]-1] = arr[i];
			 --count[arr[i]];
		}
		
		for(int i=0; i<output.length;i++){
			System.out.println(output[i]);
		}
	}
	
	public static void main(String arg[]){
		
		int[] arr = {3, 69,23, 45, 2, 1};
		new CountingSort().sort(arr);
	}
	
}
