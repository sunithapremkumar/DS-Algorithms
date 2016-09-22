package recursion;

public class TowerOfHanoi {

	
	public void move(int n, char from, char to, char inter){
		  if(n == 0 ) return;
		   move((n-1), from, inter, to);
		   
		   System.out.println("Moving disc" + n + "from " + from + "to " + to);
		   
		   move((n-1), inter, to, from);
		   
	}
	
	public static void main(String arg[]){
		TowerOfHanoi hanoi = new TowerOfHanoi();
		hanoi.move(3, 'A', 'C', 'B');
	}
	
	
}
