package arrays;

public class RotateArrayByN {
	
	// O(n*d) time complexity
	public int[] rotateArray(int[] arr, int d){
	
		
		while(d > 0){
			int temp = arr[0];
			int last = arr.length-1;
			for(int i=0; i <= last; i++){
			
			if(i == last){ 
				arr[i] = temp; 
				break;
			}
			arr[i] = arr[i+1];
			
		   }
		d--;
		}
		return arr;
	}
	
	// O(n) time complexity.
	// Find the GCD of n and d and rotate the array that many times 
	//http://www.geeksforgeeks.org/array-rotation/
	
	public int[] rotateArray1(int[] arr, int d){
		
		int n = arr.length;
		int gcd = findGCD(n,d);
		int j,k, temp;
		for(int i=0; i < gcd; i++){
			
			temp = arr[i];
			j = i;
			while(true){
				k = j +d;
				if(k >=n)
					k = k-n;
				if(k == i)
					break;
				
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = temp;
		}
		return arr;
	}
	
	private int findGCD(int a, int b){
		
		if(b == 0)
			return a;
		return findGCD(b,a%b);
	}

	public static void main(String arg[]){
		
		int arr[] = {1,2,3,4,5,6};
		int[] arr1 = new RotateArrayByN().rotateArray1(arr, 3);
		for(int n:arr)
			System.out.println("Rotated Arr:"  + n);
	}
}
