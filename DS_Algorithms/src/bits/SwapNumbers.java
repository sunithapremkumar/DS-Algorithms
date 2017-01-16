package bits;

public class SwapNumbers {

	
	  public void swap(int x, int y){
		  x = x^y;
		  y=  x^y;
		  x = x^y;
		  System.out.println("x=" + x + "  Y "+y); 
	  }
	  
	  public static void main(String artg[]){
		  new SwapNumbers().swap(3, 8);
	  }
}
