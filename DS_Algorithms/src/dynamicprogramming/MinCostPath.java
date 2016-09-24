package dynamicprogramming;

/*
 * minCost(m, n) = min (minCost(m-1, n-1), minCost(m-1, n), minCost(m, n-1)) + cost[m][n]
 */
public class MinCostPath {
	
	
	public int minCostPath(int[][] matrix, int m, int n){
		//System.out.println("m:" + m + "n:" +n);
		if((m < 0) || (n < 0))
			return Integer.MAX_VALUE;
		else if(m ==0 || n ==0)
			return matrix[m][n];
		System.out.println("matrix: " + matrix[m][n]);
		return matrix[m][n] + min(minCostPath(matrix, m-1, n), minCostPath(matrix, m, n-1), minCostPath(matrix, m-1, n-1));
	}

	private int min(int x, int y, int z){
		
		if((x < y) && (x <z)){
			System.out.println(x);
			return x;
		}				
		else if((y < x) && (y < z)){
			System.out.println(y);
			return y;
		}
			
		else {
			System.out.println(z);
			return z;
		}
			
		
		
	}
	
	public static void main(String...strings){
		int cost[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		System.out.println(new MinCostPath().minCostPath(cost, 2, 2));
	}
	
}
