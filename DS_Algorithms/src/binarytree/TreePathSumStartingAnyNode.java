package binarytree;

import java.util.*;
/**
 *  Count the tree paths that sums up to a given sum. Path can start from anywhere need not be root
 * @author suni
 * 
 *  ALGO - Do the regular tree traversal and keep adding the prefix sum to count in a map. everytime check the map to see if the complement exist, if so we found a path
 *  
 */
public class TreePathSumStartingAnyNode {
	 public int pathSum(TreeNode root, int sum) {
	        Map<Integer, Integer> map = new HashMap<>();
	        map.put(0, 1);  //Default sum = 0 has one count
	        return backtrack(root, 0, sum, map); 
	    }
	    //BackTrack one pass
	    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
	        if(root == null)
	            return 0;
	        sum += root.data;
	        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
	        map.put(sum, map.getOrDefault(sum, 0)+1);
	        //Extend to left and right child
	        res += backtrack(root.left, sum, target, map) + backtrack(root.right, sum, target, map);
	        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
	        return res;
	    }
	    
	    public static void main(String arg[]){
			TreeNode root = new TreeNode(5);
			root.left = new TreeNode(10);
			root.right = new TreeNode(-3);
			root.left.left = new TreeNode(3);
			root.left.right = new TreeNode(2);
			root.left.right.right = new TreeNode(1);
			root.left.left.left = new TreeNode(3);
			root.left.left.right = new TreeNode(-2);
			root.right.right = new TreeNode(11);
			
			TreePathSumStartingAnyNode obj = new TreePathSumStartingAnyNode();
			int count = obj.pathSum(root,  8);
			System.out.println(count);
			
			
	    }
}
