package bits;

public class SwapNumbers {

	// Using bit operator
	  public void swap(int x, int y){
		  x = x^y;
		  y=  x^y;
		  x = x^y;
		  System.out.println("x=" + x + "  Y "+y); 
	  }
	  
	  //without using temp varialble
	  public void swapWithouttemp(int x, int y){
		  x = x-y;
		  y = y+x;
		  x= y-x;
		  System.out.println("x=" + x + "  Y "+y); 
	  }
	  
	  public static void main(String artg[]){
		  new SwapNumbers().swap(3, 8);
		  
		  new SwapNumbers().swapWithouttemp(3, 8);
	  }
}
