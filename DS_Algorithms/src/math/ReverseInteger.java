package math;

public class ReverseInteger {

	
	public static int reverse(int n){
		
		int ret = 0;
		int x = Math.abs(n);
		while(x > 0){
			if(Math.abs(ret) > Integer.MAX_VALUE) // if overflow return 0
				return 0;
			ret = ret * 10 + x%10;
			x = x/10;
		}
		if( n <0) // if negative
			return(-1 * ret);
		return ret;
	}
	
	public static void main(String arg[]){
		System.out.println(Integer.MAX_VALUE);
		System.out.println(ReverseInteger.reverse(-123));
	}
}
