package binarytree;

import java.util.*;
/**
 *  A tree is "superbalanced" if the difference between the depths of any two leaf nodes ↴ is no greater than one.
 * @author suni
 *
 */
public class IsSuperBalancedTree {

	
	List<Integer> depths = new ArrayList<>();
	/**
	 * ALGO: 1. Find min and max depth and see the diff > 1.. This requires touching all nodes.
	 * ALGO 2 - Keep track of all leaf node depths and check if there are more than 2 different depths, then definitely the difference will be more than 1. else
			// if there are only 2 depths, then they both can be more than 1 apart. in such case return false.
	 * @param node
	 * @param depth
	 * @return
	 */
	public boolean isSuperBalanced(TreeNode node, int depth){
		if(node == null)
			 return true;
		
		if(node.left == null && node.right == null){
			if(!depths.contains(depth))
			    depths.add(depth);
			
			// If there are more than 2 different depths, then definitely the difference will be more than 1. else
			// if there are only 2 depths, then they both can be more than 1 apart. in such case return false.
			if(depths.size() > 2 || (depths.size() == 2 && (Math.abs(depths.get(0) - depths.get(1)) > 1))){
				return false;
			}
		}
		
		 if(!isSuperBalanced(node.left, depth+1))
			 return false;
		
		return isSuperBalanced(node.right, depth+1);
		
	}
	
}
