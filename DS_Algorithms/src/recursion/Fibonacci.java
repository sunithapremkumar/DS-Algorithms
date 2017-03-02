package recursion;

public class Fibonacci {
	/* simple recursive program for Fibonacci numbers */
	public int fib(int n)
	{
	   if ( n <= 1 )
	      return n;
	   return fib(n-1) + fib(n-2);
	}
	public long factorial(int n)
	{
	   if ( n <= 1 )
	      return 1;
	   return factorial(n-1) * n;
	}
	
	
	public static void main(String arg[]){
		//System.out.println(new Fibonacci().fib(5));
		
		System.out.println(new Fibonacci().factorial(21));
	}
}
