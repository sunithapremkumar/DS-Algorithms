package arrays;

import java.util.ArrayList;

/**
 * CITI page 91
 * @author suni
 * Write a algorithm such that if an element in an MXN matrix is 0, its entire row and column are set to 0
 *
 */
public class ZeroMatrix {

	
	/**
	 * ALGO - traverse the matrix once and note down rows and cols having zero
	 * traverse again and see if that element row/col falls in that list. If so make it zero
	 * @param matrix
	 */
	public void zeroMatrix(int[][] matrix){
		
		int colLength = matrix[0].length;
		int rowLength = matrix.length;
		
		ArrayList<Integer> zeroRows = new ArrayList<>();
		ArrayList<Integer> zeroCols = new ArrayList<>();
		for(int r=0; r < rowLength; r++)
		{
			for(int c=0; c < colLength; c++){
				
				if(matrix[r][c] == 0){
					zeroRows.add(r);
					zeroCols.add(c);
				}				
			}
		}
		
		/*for(int r=0; r < rowLength; r++)
		{
			for(int c=0; c < colLength; c++){
				
				if(zeroRows.contains(r) || zeroCols.contains(c)){
					matrix[r][c] = 0;
				}
				
			}
		}*/
		
		for(int r : zeroRows){
			for(int c=0; c<colLength;c++)
				matrix[r][c] = 0;
		}
		for(int c : zeroCols){
			for(int r=0; r<rowLength;r++)
				matrix[r][c] = 0;
		}
	}
	
	public static void main(String arg[]){
		
		ZeroMatrix obj = new ZeroMatrix();
		
		int[][] matrix = {{1,0,2},
						  {4,5,0},
						  {7,8,10}}; 
		
		 obj.zeroMatrix(matrix);
		 
		 for(int r=0; r < matrix.length; r++)
			{
				for(int c=0; c < matrix[0].length; c++){
					System.out.println(matrix[r][c]);
				}
			}
		
	}
	
}
