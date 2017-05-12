package bits;

/**
 * Add without add operator
 * @author suni
 *
 */
public class AddWithoutAddOperator {
	
	
	public static int sum(int x, int y){
		
		while(y != 0){
			int carry = x & y;
			x = x ^ y;
			y = carry << 1;			
		}
		
		return x;
	}
	
	public static void main(String arg[]){
		
		System.out.println(AddWithoutAddOperator.sum(10, 15));
	}

}
