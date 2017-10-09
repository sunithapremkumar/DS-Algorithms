package interviewcake;
/**
 * Given a array of integers find the highest product of 3 integer
 * @author suni
 *
 */
public class HighestProductOf3 {
	
	/**
	 * 1. This can be solved by sorting the array and multiplying last 3 elements which gives nlog(n). 
	 * 2. We can do in O(n) using greedy by keeping track of following
	 *     highestproductof3 - Max(current*highestproductof2, highestproductof3). So this requires to keep track of 'higestproductof2'
	 *     highestproductof2 - Max(current*highest, highestproductof2);  so this requires to keep track of 'highest' 
	 *     highest - Max(current, highest)
	 *  But what if the ip - {1,10,-5,1,-100}. In this case if we ignore -5, then when we come to -100, the highest product will be 1*10*1 not -5*-100.
	 *  So We should also keep track of lowest and lowestproductof2
	 */
	public static long find(int[] arr){
		
		int highest = Math.max(arr[0], arr[1]);
		int lowest = Math.min(arr[0], arr[1]);
		int highestProductof2 = arr[0] * arr[1];
		int lowestProductof2 = arr[0] * arr[1];;
		int highestProductof3 = arr[0] * arr[1] * arr[2];
	
		//starting at index 2 to keep the highestproduct of 2 updated if the index 2 has larger value
		for(int i=2; i < arr.length; i++){
				
			int current = arr[i];
			highestProductof3 = Math.max(Math.max(current * highestProductof2, highestProductof3), current*lowestProductof2);
			
			highestProductof2 = Math.max(Math.max(current * highest, highestProductof2), current*lowest);
			
			lowestProductof2 = Math.min(Math.min(current * highest, lowestProductof2), current*lowest);
			
			highest = Math.max(highest, current);
			lowest = Math.min(lowest, current);
					
						
		}
		return highestProductof3;
	}
	
	public static void main(String arg[]){
		int[] arr = {1,10,-5,1,-100};
		System.out.println(HighestProductOf3.find(arr));
	}

}
