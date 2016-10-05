import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class RunningMedian {

	    public BigDecimal findMedian(int[] arr, int size){
	        if(size ==0)
	            return new BigDecimal(0);
	        Arrays.sort(arr, 0, size-1);
	        BigDecimal medianValue = null;
	        int lastIndex = size -1;
	        
	        //Check if even
	        if(size%2 ==0){
	            int medianIndex = lastIndex/2;
	            medianValue = new BigDecimal(arr[medianIndex] + arr[medianIndex+1]);
	            medianValue = medianValue.divide(new BigDecimal(2), 1, BigDecimal.ROUND_UNNECESSARY);
	        }else{
	             int medianIndex = lastIndex/2;  
	             medianValue = new BigDecimal(arr[medianIndex]);
	             medianValue = medianValue.setScale(1);
	        }
	        return medianValue;
	    }
	    
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
	            System.out.println(new RunningMedian().findMedian(a, a_i+1));
	        }
	    }
	}

