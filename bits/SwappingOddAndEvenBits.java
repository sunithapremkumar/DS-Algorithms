package bits;
/**
 * Swap the odd and even bits in an integer. bit 0 and bit 1 swapped, bit 2 and bit 3 swapped etc..
 * @author suni
 *
 */
public class SwappingOddAndEvenBits {

	public int swap(int x){
		int onlyoddbits = x & 0xaaaaaaaa; // gets only odd bits in x. aaaaaaa =  101010101010
		int onlyevenbits = x & 0x55555555; //gets only even bits in x. 5555555 = 01010101010
		int shiftoddbits = onlyoddbits >>> 1; // shifts odd bits
		int shiftevenbits = onlyevenbits << 1; //shifts even bits
		return shiftoddbits | shiftevenbits; //merge both
	}
	
	public static void main(String arg[]){
		int result = new SwappingOddAndEvenBits().swap(10);
		System.out.println(result);
	}
}
	