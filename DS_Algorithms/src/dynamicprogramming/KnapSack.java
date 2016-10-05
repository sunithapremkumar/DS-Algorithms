package dynamicprogramming;
/**
 * https://www.youtube.com/watch?v=8LusJS5-AGo
 * @author prasunit
 *
 */
public class KnapSack {
	
	
	public int knapsack(int[] wt, int[] val, int weight, int n){
		
		if((n == 0) || (weight == 0))
			return 0;
		
		if(wt[n] > weight)
			return knapsack(wt, val, weight, n-1);
		else
			return Math.max((val[n] + knapsack(wt, val, weight-wt[n], n-1)), knapsack(wt, val, weight, n-1));
		
	}

	
	
	public static void main(String...strings )
	{
		int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        System.out.println(new KnapSack().knapsack(wt, val, W, val.length-1));
	}

}
