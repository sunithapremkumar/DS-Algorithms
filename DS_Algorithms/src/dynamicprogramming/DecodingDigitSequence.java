package dynamicprogramming;

/**
 * Decode the digits say {1324} can be decoded as ABCD", "LCD", "AWD"
 * @author prasunit
 *
 *Algorithm  
 *
 * The number "1324" can be represented as  132(4) + 13(24) (provided this last 2 digits < 26) else it can only be represented as 132(4).
 * So count[n] = count[n-1] + count[n-1];
 * 
 */
public class DecodingDigitSequence {

	
	public static int countDecoding(int[] arr, int n){
		if((n ==0) || (n ==1))
			return 1;
		
		if(merge(arr[n-2], arr[n-1]) <= 26)
			return countDecoding(arr, n-1) + countDecoding(arr, n-2);
		else		
			return countDecoding(arr, n-1);
	}
	
	// below one is incomplete - not working
	public static int countDecodingDP(int[] arr, int n){
		int[] count = new int[n+1];
		count[0] = 1;
		count[1] = 1;
		for(int i=2; i < n ; i++){
			if(merge(arr[i-2], arr[i-1]) <= 26)
			   count[i] = count[i-1] + count[i-2];
			else
				count[i] = count[i-1];
		
		}
		
		return count[n];
	}
	
	private static int merge(int first, int second){
		
		int val = Integer.parseInt(first+""+second);
		return val;
	}
	
	public static void main(String[] ag){
		int[] arr = {2,3,1,8,4};
		
		System.out.println(countDecoding(arr, arr.length));
		int[] test2 = {1,2,3,2,1};
		System.out.println(countDecoding(test2, test2.length));

	}
}
