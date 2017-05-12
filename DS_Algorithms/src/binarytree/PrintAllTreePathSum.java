package binarytree;

import java.util.*;

public class PrintAllTreePathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> resultList = new ArrayList<>();
        findPath(root, 0, sum, new ArrayList(), resultList);
        return resultList;  
        
    }
    //Find all paths that sums up to the given number
    private void findPath(TreeNode n, int runningSum, int sum, List<Integer> paths, List<List<Integer>> resultList){
        if(n == null)
             return; 
        
         runningSum += n.data;
         paths.add(n.data);
        if(n.right == null && n.left == null){
            if(runningSum == sum)
            	resultList.add(new ArrayList<Integer>(paths));       
        }
        
        findPath(n.left, runningSum, sum, paths, resultList);
        findPath(n.right, runningSum, sum, paths, resultList);
        
        paths.remove(paths.size()-1);
    }
    
    //Find any one path that sums up to the given number
    private boolean findPath1(TreeNode n, int runningSum, int sum, List<Integer> paths, List<List<Integer>> resultList){
        if(n == null)
             return false; 
        
         runningSum += n.data;
         paths.add(n.data);
        if(n.right == null && n.left == null){
            if(runningSum == sum){
            	resultList.add(new ArrayList<Integer>(paths));   
            	return true;
            }
        }
        
        if(findPath1(n.left, runningSum, sum, paths, resultList))
        	return true;
        if(findPath1(n.right, runningSum, sum, paths, resultList))
        	return true;
        
        paths.remove(paths.size()-1);
        return false;
    }
      
    
    public static void main(String arg[]){
    	
    	TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		/*root.left.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);*/
		root.right.right = new TreeNode(1);
		
		PrintAllTreePathSum obj = new PrintAllTreePathSum();
		
		 List<List<Integer>> list = obj.pathSum(root, 21);
		 
		 for(List<Integer> l : list){
			 
			 for(int i: l)
				 System.out.print(i + " ");
			 
			 System.out.println("");
		 }
		 
		
    }
}
