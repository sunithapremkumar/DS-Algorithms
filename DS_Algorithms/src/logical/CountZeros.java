package logical;
/**
 * Count the number of trailing zeros in 'n' factorial
 * @author suni
 *
 */
public class CountZeros {

	

	/**
	 * ALGO - any number that is multiples of 5 will have zero. If it is multiples of 25 then (2 zeros). 
	 * @param n
	 * @return
	 */
	public int count(int n){
		int count = 0;
		if(n <0)
			return -1;
		
		for(int i=5; n/i >0; i= i*5)
			count += (n/i);
		
		return count;
	}
	
	public static void main(String arg[]){
				
		System.out.println(new CountZeros().count(26));

	}
}
