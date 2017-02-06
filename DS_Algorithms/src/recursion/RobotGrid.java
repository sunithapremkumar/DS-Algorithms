package recursion;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Robot is at top left corner in a mxn grid. It can either go right or down. There are
 * some spots where it can step. Find a path for the robot to reach the bottom right corner
 * @author suni
 *
 */
public class RobotGrid {
	
	
	public boolean findPath(boolean maze[][], int row, int col, ArrayList<Point> path){
		if(maze == null)
			return false;
		if(row <0 || col <0 || !maze[row][col])
			return false;
		
		if(row ==0 && col == 0){
			path.add(new Point(row, col));
			return true;
		}
		else if(findPath(maze, row, col-1, path) || findPath(maze, row-1, col, path)){
			
			path.add(new Point(row, col));
			return true;
		}
		return false;
	}
	
	//using memoization (DP)4A . Cahceing the failed points in a Hashset.
		public boolean findPath(boolean maze[][], int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints){
			if(maze == null)
				return false;
			if(row <0 || col <0 || !maze[row][col])
				return false;
	
			Point p = new Point(row, col);
			if(row ==0 && col == 0){
				path.add(p);
				return true;
			}
			
			if(failedPoints.contains(p))
				return false;
			
			else if(findPath(maze, row, col-1, path) || findPath(maze, row-1, col, path)){
				
				path.add(p);
				return true;
			}
			failedPoints.add(p);
			return false;
		}
		
	public static void main(String arg[]){
		 RobotGrid obj = new RobotGrid();
		 boolean[][] matrix = new boolean[][]{
			               {true, true, true, true},
				 		   {true, true, true, true},
				 		   {true, true, true, true}
		 				   };
		 ArrayList<Point> al = new ArrayList<>();				   
		 System.out.println(obj.findPath(matrix, 2, 3, al));				   
		 for(Point p: al)
			 System.out.println("recursive: " + p);
		 
		 ArrayList<Point> al1 = new ArrayList<>();		
		 System.out.println(obj.findPath(matrix, 2, 3, al1, new HashSet()));				   
		 for(Point p: al1)
			 System.out.println("Menmoization : "+ p);
	}
	
	
	
	
	public class Point{
		int row;
		int col;
		public Point(int r, int c){
			row =r;
			col = c;
		}
		public String toString(){
			return row +"," + col;
		}
	}

}
