package arrays;
/**
 * Rotate the NXN matrix where each pixel is rotated 90 degree
 * CTCI page 203
 * @author suni
 *
 */
public class RotateMatrix {

	public static void rotate(int[][] matrix){
		int n = matrix.length;
		
		for(int layer = 0; layer < n/2; layer++){
		     int first = layer;
		     int last = n-1-layer;
		     for(int i=first; i<last; i++){
		    	 int offset = i - first;
		    	
		    	 //moving top to tmp
		    	 int tmp  = matrix[first][i];
		    	 //moving left to top
		    	 matrix[first][i] = matrix[last-offset][first];
		    	//moving bottom to left
		    	 matrix[last-offset][first] = matrix[last][last-offset];
		    	 //moving right to bottom
		    	 matrix[last][last-offset] = matrix[i][last];
		    			 
		    	 matrix[i][last] = tmp;
		     }
		}
	}
	
	public static void main(String arg[]){
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
		
		RotateMatrix.rotate(matrix);
	}
}
