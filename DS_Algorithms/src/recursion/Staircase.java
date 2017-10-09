package recursion;

/**
 * A child running up  staircase with n steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a 
 * method to count how many possile ways the child can run up the stairs.
 * 
 * @author suni
 *
 */
public class Staircase {
	
	public int countWays(int n){
		if(n < 0)
			return 0;
		else if(n ==0) // To come to step 0 we can either say we need 1 step or 0 step. But if we give 0, the count of n steps will always be zero.. it' gud to make 1 step assumption
			return 1;
		else 
			return countWays(n-1) + countWays(n-2) + countWays(n-3);
	}
	
	public static void main(String arg[])
	{
		Staircase obj = new Staircase();
		System.out.println(obj.countWays(3));
	}
}
