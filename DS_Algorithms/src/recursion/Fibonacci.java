package recursion;

public class Fibonacci {
	/* simple recursive program for Fibonacci numbers. top down approach*/
	public int fib(int n)
	{
	   if ( n <= 1 )
	      return n;
	   return fib(n-1) + fib(n-2);
	}
	
	//top down approach using memoization
	public int fib(int n, int mem[])
	{
	   if ( n <= 1 )
	      return n;
	   
	   if(mem[n] == 0){
		   mem[n] = fib(n-1) + fib(n-2);
		   
	   }
	   return mem[n];
	}
	
	
	public long factorial(int n)
	{
	   if ( n <= 1 )
	      return 1;
	   return factorial(n-1) * n;
	}
	
	
	public static void main(String arg[]){
		System.out.println(new Fibonacci().fib(5, new int[6]));
		
		//System.out.println(new Fibonacci().factorial(25));
	}
}
