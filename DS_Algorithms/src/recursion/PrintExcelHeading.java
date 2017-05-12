package recursion;


public class PrintExcelHeading {

	static char[] letters = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I', 'J', 'K', 'L', 'M', 'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	
	public static String printExcelHeading(int num){
		if(num%26 ==0){ //For 52 the value is AZ which is 52/26 = 2. (2-1) = 1+'Z'
			int q = num /26;
			return findHeading(q-1) + letters[26];
		}
		else{
			return findHeading(num);			
		}
	}
	
	private static String findHeading(int num){
		String result = "";
		int n = num;
		while( n > 26){ // Keep diving by 26 until it is lesser. Append the remainders and later quotient
			int q = n/26 ;
			int r = n % 26;
			result = letters[r] + result;
			n = q;
		}
		result = letters[n] + result;
		return result;
	}
	
	public static void main(String... s){
		
		System.out.println(728 +": " + printExcelHeading(29));
		System.out.println(1000 +": " + printExcelHeading(1000));
		System.out.println(2000 +": " + printExcelHeading(2000));
		System.out.println(1111 +": " + printExcelHeading(1111));
		System.out.println(1000000 +": " + printExcelHeading(1000000));

	}
	
}
