package arrays;
/**
 * In a sorted matrix, find an element
 * @author suni
 *
 */
public class SortedMatrix {

	// Binary search.. Start from top right corner as that is the middle if array... like binary search.. progress towards down or left
	 public boolean find(int[][] matrix, int x){
		 
		 if(matrix == null)
			 return false;
	
		 //top right corner
		 int row = 0; 
		 int col = matrix[0].length-1;
		 
		 int rowMax = matrix.length -1;
		 
		 while(row < rowMax && col > 0){
			 if(matrix[row][col] == x){
				 System.out.println("row: " + row + "col: "+ col);
				 return true;
			 }else if(matrix[row][col] > x){ //Go left
				 col--;
			 }
			 else{ // Go down as the given x is bigger than element
				 row++;
			 }
		 }
		 return false;
	 }
	
	
	public static void main(String arg[]){
		
		int[][] matrix = {
						  {15,20,40,85},
						  {21,35,80,95},
						  {30,55,90,105},
						  {41,80,100,120}
						 };
		
		SortedMatrix obj = new SortedMatrix();
		System.out.println(obj.find(matrix, 55));
		
				
	}
}
