package logical;
/**
 * Write a method to perform multiplication, subtraction and division operation on integers using only add operator
 * @author suni
 *
 */
public class Operations {

	// -x = -1 * x = adding -1 x times
	private int negate(int x){
		int newSign = (x < 0)? 1 : -1; // If x is negative, new sign is positive 
		
		int neg = 0;
		
		while(Math.abs(x) >0){
			neg = neg + newSign;
			x = x + newSign;
		}
		
		return neg;
	}
	// (a-b) = a + (-1 *b). 
	public int minus(int a, int b){
		
		return (a+ negate(b));
	}
	
	// Add a,  b times. 
	public int multiply(int a, int b){
		if(a < b)
			return multiply(b,a); // Better to reduce the addition time by adding the bigger value
		
		int result =0; 
		int absA = Math.abs(a);
		int absB = Math.abs(b);
		for(int i= 0; i < absB; i++)
			result = result + absA;
		
		if(a <0 && b <0)
			return result; //if both negative return positive;
		if(a <0 || b <0)
			return negate(result);
		
		return result;
	}
	
	// a/b = x.  a=xb;  this means add b x times to become a
	public int divide(int a, int b) throws ArithmeticException{
		
		if(b ==0)
			throw new ArithmeticException("ERROR");
		
		
		int result = 0;
		int absB = Math.abs(b);
		int count = 0;
		while( (result+absB) <= Math.abs(a) ){
			result = result + absB;
		    count ++;
		}
		
		if(a < 0 && b < 0) // both negative, return positive
			return count;
		
		if(a < 0 || b<0)  //if any one negative, return negative
			return negate(count);
		
		return count; // if both positive, return poisitive
	}
	
	public static void main(String arg[]){
		
		Operations obj = new Operations();
		System.out.println("Minus " + obj.minus(3, 4));
		System.out.println("Multiply: " + obj.multiply(4,-3));
		System.out.println("Divide: " + obj.divide(2,4));
	}
}
