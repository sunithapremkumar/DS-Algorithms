package bits;
/**
 * Find max of 2 integer without using if else or comparison operator like < or  >
 * @author suni
 *
 */
public class MaxOfTwoIntegers {

	public int findMax(int a, int b){
		
		int k = findSignBit(a, b); // returns 0 if a is bigger, 1 if b is bigger
		int q = flipBit(k); // returns 1 if a is bigger
		
		return a*q + b*k;
		
	}
	
	private int findSignBit(int a, int b){
		int c = (a-b);
		int signbit = (c>>>31) & 1;
		return signbit;
	}
	
	private int flipBit(int x){
		return x^1;
	}
	
	public static void main(String arg[]){
		int max = new MaxOfTwoIntegers().findMax(10, 8);
		System.out.println(max);
	}
}
