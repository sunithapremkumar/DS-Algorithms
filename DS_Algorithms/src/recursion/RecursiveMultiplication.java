package recursion;
/**
 * Multiply 2 positive integers without using * operator. You can use addition, subtraction and bit shifting
 * @author suni
 *
 */
public class RecursiveMultiplication {

	 public int multiply(int x, int y){
		 if(y ==0)
			 return 0;
		 
		 return x + multiply (x, y-1);
	 }
}
