package sort;
// It's better to do merge sort which is of On(logn) time and return the 3rd index in the sorted array.
public class MergeSort {

	private int[] inputArr; int count =0;
	
	//O(nlogn) time complexity
	public  int getLargeNumber(int arr[]){
		inputArr = arr;
		int[] workspace = new int[arr.length];
		sort(workspace, 0, arr.length-1);
		System.out.println("sorted arr");
		print( workspace);
		return workspace[arr.length- 3];
	}
	
	private void sort(int[] workspace, int low, int high){
		
		 if(low == high)
			 return;
				 
	     int mid = (low+high)/2;
		 
		 sort(workspace, low, mid);
		 sort(workspace, mid+1, high);
		 merge(workspace, low, mid, high);	
		 System.out.println ("printng " + count++);
		 print(workspace);
	}
	
	private void print(int[] arr){
		for(int i=0; i <arr.length; i++)
		  System.out.println (arr[i]);
	}
	private void merge(int[] workspace, int low, int mid, int high){
		
		int highPointer = mid +1;
		int lowPointer = low;
		int i=-1;
		int n= high-low+1;
		
		while(lowPointer <= mid && highPointer <= high){
			
			if(inputArr[lowPointer] < inputArr[highPointer])
			   workspace[++i] = inputArr[lowPointer++];
			else
				workspace[++i] = inputArr[highPointer++];
		}
		
		while(lowPointer <= mid){
			workspace[++i] = inputArr[lowPointer++];
		}
		
		while(highPointer <= high){
			workspace[++i] = inputArr[highPointer++];
		}
     
		for(int j = 0; j < n; j++){
			inputArr[low+j] = workspace[j];
		}
		
	}
	
	// O(n) time complexity
	public int getThirdLargest(int[] arr){
		
		int size = arr.length;
		int n = 0; int m =0, m1=0, m2 = 0;
		while (n < size){
			
			if (arr[n] > m){
				m2 = m1; 
				m1 = m;
				m = arr[n];
			}
			else if(arr[n] > m1){
				m2 = m1;
				m1 = arr[n];
			}
			else if(arr[n]  > m2){
				m2 = arr[n];
			}
			n++;
		}
		
		return  m2;
	}
	public static void main(String arg[]){
		
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = {2,1,3,5,4};
		
		//System.out.println("3rd Large number: "+ new ThirdLargeNumber().getLargeNumber(arr));
		System.out.println("3rd Largest :" +  new MergeSort().getThirdLargest(arr));
		
	}
	
}
