package bits;
/**
 * Consider an array of  integers, , where all but one of the integers occur in pairs. 
 * In other words, every element in  occurs exactly twice except for one unique element.
 * @author suni
 *
 */
public class FindNonRepeatingNumber {
	
	/**
	 * Algorithm
	 * Do  if your array contains the elements [3, 4, 5, 3, 4], the algorithm will return 3 ^ 4 ^ 5 ^ 3 ^ 4
     * But the XOR operator ^ is associative and commutative, so the result will be also equal to: (3 ^ 3) ^ (4 ^ 4) ^ 5
     * Since i ^ i = 0 for any integer i, and i ^ 0 = i, you have (3 ^ 3) ^ (4 ^ 4) ^ 5 = 0 ^ 0 ^ 5 = 5
	 * @return
	 */
	 public static int lonelyInteger(int[] a) {
	        
        int result =a[0];
        for(int i=1; i<a.length; i++){
            result = result ^ a[i];
        }
        
        
        return result;
   }
	 
	 public static void main(String arg[]){
		 
		 int[] arr = {2,4,3,4,2};
		 int result =lonelyInteger(arr);
		 System.out.println(result);
	 }
	
	
}
