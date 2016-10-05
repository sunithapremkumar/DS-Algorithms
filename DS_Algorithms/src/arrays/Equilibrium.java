package arrays;

/**
 * Find the equilibrium index which is the index total of before and after would be equal.
 * @author prasunit
 *
 */
public class Equilibrium {
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	        
	        if(A.length == 0)
	        return -1;
	        
	        long leftTotal = 0;
	        long rightTotal = findTotal(A);
	        for(int i=0; i< A.length; i++){
	            if(leftTotal == rightTotal)
	               return i;
	            else{
	                leftTotal += A[i];
	                if((i+1) < A.length)
	                  rightTotal = rightTotal - A[i+1];
	            }
	        }
	        return -1;
	                   
	    }
	    
	    private long findTotal(int[] A){
	        long tot = 0;
	        for(int j=1; j<A.length; j++){
	            tot += A[j];
	        }
	        return tot;
	    }
	
	     public static void main(String... str){
	    	 int[] A= {-1, 3, -4, 5, 1, -6, 2, 1};
	    	 
	    	 System.out.println(new Equilibrium().solution(A));
	     }
}
