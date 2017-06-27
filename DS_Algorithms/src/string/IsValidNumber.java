package string;

/**
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * 
 * "0" - true "0.1" - true "abc" - false "2e10" => true
 * 
 * @author suni
 *
 */
public class IsValidNumber {
	/**
	 * A string could be divided into these four substrings in the order from left to right:
	s1. Leading whitespaces (optional).
	s2. Plus (+) or minus (–) sign (optional).
	s3. Number. (which can be of the format 'integer decimal integer'). '.12', '12.' both are valid but just '.' is invalid 
	s4. Optional trailing whitespaces (optional).
	
	  ALGO - Keep checking in the order and increment the i if we find valid entry.. finally check if i==length of string.
	    One single while loop will not work because it will not check the order of occurance of '+' or '.'. 
	 * @param s
	 * @return
	 */
	public static boolean isNumber(String s) {

		String str = s.trim();
		int i = 0;
		int n = str.length();

		if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')){
			i++;
		}
		boolean isNumeric = false; // this boolean is to check if there is any numeric value before or after decimal
		while (i < n && Character.isDigit(str.charAt(i))) {
			i++;
			isNumeric = true;
		}

		if (i < n && str.charAt(i) == '.') {
			i++;
			isNumeric = false;
			while (i < n && Character.isDigit(str.charAt(i))) {
				i++;
				isNumeric = true;
			}

		}
		if (isNumeric && i < n && str.charAt(i) == 'e') {
			i++;
			isNumeric = false; //in 'e' case both before and after has to be  numeric but in decimal case either one can be numeric
			if(i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')){
                i++;
                }
			while (i < n && Character.isDigit(str.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}
		return (isNumeric && i == n);

	}
	
	public static void main(String arg[]){
		System.out.println(IsValidNumber.isNumber("1 "));

		System.out.println(IsValidNumber.isNumber("+12."));
		System.out.println(IsValidNumber.isNumber("+.3e+4"));
		System.out.println(IsValidNumber.isNumber("+12.2e4"));
		System.out.println(IsValidNumber.isNumber("+12.e"));
		



	}
}
