package math;

// Check if a number is palindrome. without using extra space.
// ALGO it is easier to convert to string and check but that is extra space. We can reverse the number and check if same.. but reversing might cause integer overflow
// so let's try this way,.. check the first and last digit if same strip those and check the rest..
// stripping last digit is easy.. stripping first digit is tricky
public class IsPalindromeNumber {

	
	public static boolean isPalindrome(int n){
		
		int div = 1;
		int x = n;
		while(x/div >=10)  //if n = 123, div = 100
			div = div*10;
		
		while(x >0){
			
			int l = x % 10; // left most digit
			int r = x / div; // right most digit
			if(l != r ) return false;
			
			x = (x % div) / 10;
			div = div / 100;
		}
		return true;
	}
	
	public static void main(String atg[]){
		System.out.println(IsPalindromeNumber.isPalindrome(12321));
	}
}
