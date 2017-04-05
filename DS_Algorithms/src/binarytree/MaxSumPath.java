package binarytree;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Given a binary tree, where each node is labeled with an integer return the path from root to leaf that forms the maximum sum.  Complexity.                  
        
          4
        /   \
       5     8
      / \   / \
   333   4 0   10
              /   
             11
               \  
                12

Answer is: 4, 5, 333.
 * @author prasunit
 *
 */
public class MaxSumPath {

	/**
	 * ALGO - Touch all the nodes by traversing, while doing that sum the node data along the path (into running sum and running path)
	 * if it reaches leaf node, check the running sum with max sum and update maxSum if necessary.
	 * 
	 * running path -  should hold only the current path. Since it's a object having previous path info, we need to remove the last element
	 * to have the current running path
	 * @param n
	 */
	public static void getMaxPath(TreeNode n, int runningSum, AtomicInteger maxSum, List<TreeNode> runningPath, List<TreeNode> maxPath){

		if(n == null)
		     return;
		    
		    runningSum += n.data; 
		    runningPath.add(n);
		    
		    if(n.right== null && n.left == null){
		   
		      if(runningSum > maxSum.get() )
		      {
		         maxSum.set(runningSum);
		         maxPath.clear();
		         maxPath.addAll(runningPath);
		      }
		      
		   }
		    
		    getMaxPath(n.left, runningSum, maxSum,  runningPath, maxPath);
		    
		        
		    getMaxPath(n.right, runningSum, maxSum,  runningPath, maxPath);

		    if(runningPath.size() > 1)    // running path should hold only the current path. Since it's a object having previous path info, we need to remove the last element
		        runningPath.remove(runningPath.size()-1);


		}
	
	public static void main(String arg[]){
		  TreeNode root = new TreeNode(4);
	        root.left = new TreeNode(5);
	        root.left.left = new TreeNode(333);
	        root.left.right = new TreeNode(4);
	        root.right = new TreeNode(8);
	        root.right.left = new TreeNode(0);
	        root.right.right = new TreeNode(10);
	        root.right.right.left = new TreeNode(11);
	        root.right.right.left.right = new TreeNode(12);
		
		  ArrayList<TreeNode> rl = new ArrayList<>();
		  ArrayList<TreeNode> result = new ArrayList<>();
		  MaxSumPath.getMaxPath(root, 0, new AtomicInteger(0), rl, result);
		  
		  for(TreeNode n : result)
			  System.out.println(n.data);
	}
	


}
