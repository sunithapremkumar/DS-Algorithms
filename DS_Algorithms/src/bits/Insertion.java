package bits;

/**
 * insert m into n starting at position start to end in n.
 * Algorithm
 * 1. Clear the bits in n from start to end
 * 2. Shift m so that it lines up with bits start through end 
 * 3. Merge m and n
 * @author suni
 *
 */
public class Insertion {
	
	public void insert(int n, int m, int start, int end){
		
		
		int leftMask = -1 << (start+1);
		int rightMask =  (1 << end) -1;
		
		System.out.println("leftMask"+ leftMask + "Right Mask" + rightMask);
		int mask = leftMask | rightMask;
		System.out.println(mask);
		int ncleared = n & mask;
		
		int result = ncleared | (m<<end);
		
		System.out.println(result); //result should be 10001001100 (1100)
	}
	
	public static void main(String asg[]){
		Insertion obj = new Insertion();
		int n = 1024;//1000000000;
		int m = 19;//10011;
		int start = 6;
		int end = 2;
		obj.insert(n, m, start, end);
	}

}
