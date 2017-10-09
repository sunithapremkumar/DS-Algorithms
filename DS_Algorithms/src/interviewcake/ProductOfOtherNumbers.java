package interviewcake;
/**
 * Find the product of all other numbers for each element at index i
 * i/p = {1,2,3,4}
 * 0/p = {2*3*4, 1*3*4, 1*2*4, 1*2*3}
 * @author suni
 *
 */
public class ProductOfOtherNumbers {

	
	  /**
	   * 1. Product of other numbers at index i is the product of all numbers before i and product of all numbers after i
	   * 2. Store the product of all numbers after index in a array
	   * 3. Walk through the input array and keep multiplying as we walk through which gives the product of before index.
	   * 4. Multiply that with the element in point 2 (which is the product after index) and store in the same after index array
	   * @param inputArr
	   * @return
	   */
	  public static int[] findProductOfOtherNumbers(int[] inputArr){
		  
		  int[] productAfterIndex = new int[inputArr.length];
		  int prev = 1;
		  //Storing after index product
		  for(int i=inputArr.length-1; i >=0 ;i--)
		  {
			  productAfterIndex[i] = prev;
			  prev= prev * inputArr[i];
		  }
		  
		  prev = 1; 
		  for(int i=0; i<inputArr.length; i++){
			  productAfterIndex[i] = productAfterIndex[i] * prev;
			  prev = prev * inputArr[i]; 		
		  }
		  return productAfterIndex;
	  }
	  
	  public static void main(String arg[]){
		  int[] arr = {1,7,3,4};
		  int[] result = ProductOfOtherNumbers.findProductOfOtherNumbers(arr);
		  
		  for(int i: result)
			  System.out.println(i);
	  }
}
