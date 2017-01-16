package bits;
/**
 * Find the number of bits we need to flip to convert number a to number b
 * input 29 (11101), 15(01111)
 * output 2
 * @author suni
 *
 */
public class NumberConversion {

	/**
	 * Algorithm
	 * xor of a and b will give the number of variant bits. Then counting the 1's in output will be the result
	 */
     public int countBitstoFlip(int a, int b){
    	 
    	 int c = a^b;
    	 int count =0;
    	 for(int i=c; i != 0; i = i & (i-1)){ // i & (i-1)  will clear the least significant 1 bit.
    		 count++;
    	 }
    	 return count;
     }
	
     public static void main(String agh[]){
    	 
    	 int count = new NumberConversion().countBitstoFlip(29, 15);
    	 System.out.println(count);
     }
}
