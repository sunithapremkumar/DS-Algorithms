package sort;

import java.util.ArrayList;
import java.util.Collections;
//Both bucket sort and counting sort are used for low range values.. But bucket sort can also be used for decimal values

public class BucketSort {

	
	public void sort(int[] arr){
		
		int[] bucket = new int[255]; //find max element ND INITIALlize with thats
		for(int i=0; i<arr.length; i++){
			bucket[arr[i]]++;
		}
		
		int outputIndex = 0;
		for(int i =0; i< bucket.length; i++){ // take each bucket 
			
			for(int j=0 ; j < bucket[i]; j++) {// in each bucket add all the counts of number into output
				arr[outputIndex] = i;
			    outputIndex++;
			}
			
		}
		
		for(int i=0; i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	//sorting floating numbers. This work if all values are less than zero.. i
	//if we havve value like 1.5. 1.5*size gives index over sizes
	public void sortDouble(double[] arr){
		
		ArrayList<Double> bucket[] = new ArrayList[arr.length];
		for(int i=0; i<bucket.length; i++){
			bucket[i] = new ArrayList();
		}
		
		int n = arr.length;
		for(int i=0; i<arr.length; i++){ //add elements to bucket
			int index = (int) (n*arr[i]); // multiplying the floating value with n to decide the array index (bucket)
			bucket[index].add(arr[i]);
		}
		for(int i=0; i<bucket.length; i++){ // sort each bucket
			Collections.sort(bucket[i]);
		}
		
		int outputIndex = 0;
		for(int i =0; i< bucket.length; i++){ // combine buckets 
			
			for(double j : bucket[i]) {
				arr[outputIndex] = j;
			    outputIndex++;
			}
			
		}
		
		for(int i=0; i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
public static void main(String arg[]){
		
		double[] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};; 
		//double[] arr = {3, 69,23, 45, 2, 1};
		//new BucketSort().sort(arr);
		new BucketSort().sortDouble(arr);
	}
}
