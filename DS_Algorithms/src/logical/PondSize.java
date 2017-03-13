package logical;

import java.util.ArrayList;
/**
 * CTCI
 * You have an integer matrix representing plot of land where the value represents a water or land. 0 -water, 1-land
 * A pond is a region of water connected vertically, horizontallu, diagonally. size of pond is the total number of connected
 * water cells. Write a method to compute the sizes of all ponds in a matrix
 * input:   {0,2,1,0},
			{0,1,0,1},
			{1,1,0,1},
			{0,1,0,1}
 *  
 *  output - 2,4,1
 * @author suni
 *
 */
public class PondSize {

	/**
	 *  ALGO - Iterate over each element in matrix. If a cell is 0, then check around to see if anything else is 0 to 
	 *  get added. Do that check around (8 cells around) recursively to check the surroundings of those again. 
	 *  Mark those visisted nodes so that we don't visit again.
	 * @param matrix
	 * @return
	 */
	public ArrayList<Integer> calculatePondSize(int[][] matrix){
		
		ArrayList<Integer> pondSizes = new ArrayList<>();
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		
		for(int r=0; r < rowSize; r++){
			for(int c=0; c<colSize; c++){
				
				if(matrix[r][c] == 0){
					int size = calculateSizeAround(r,c, matrix); //check around it.
					pondSizes.add(size);
				}
			}
		}
		return pondSizes;
	}
	
	//Check the 8 cells around the input cell to see if they are 0. 
	private int calculateSizeAround(int row, int col, int[][] matrix){
		int rowSize = matrix.length;
		int colSize = matrix[0].length;
		
		if(row < 0 || col < 0 || row >= rowSize || col >= colSize || matrix[row][col] !=0)
			return 0;
		
		int size = 1;
		matrix[row][col] = -1; // mark as visited
		
		for(int dr=-1; dr <=1 ; dr++){
			for(int dc =-1; dc <=1; dc++){
				
				int s = calculateSizeAround(row + dr, col+ dc, matrix);
				size +=s;
			}
		}
		return size;
		
	}
	
	public static void main(String arg[]){
		
		
		 int[][] matrix = { {0,2,1,0},
				 			{0,1,0,1},
				 			{1,1,0,1},
				 			{0,1,0,1}
		 				  };
		 
		 PondSize obj  = new PondSize();
		 ArrayList<Integer> sizes = obj.calculatePondSize(matrix);
		 
		 for(int i :sizes)
			 System.out.println(i);
				 
		 }
		
	
}
