package binarytree;


import java.util.List;
import java.util.*;

/**
 * Find a path from root to leaf that sums up to a number. 
 * https://youtu.be/Jg4E4KZstFE
 * @author suni
 *
 * Check PrintAllTreePathSum problem
 */
public class TreePathSum {

	/**
	 * Algo - Do pre-order traversal during which whenever we visit a node, substract the sum... when we reach the
	 * leaf node, see if the final sum and the node data is same, if so that's the path.. add it to stack
	 * and retur		n true..so that all the upper nodes in that path gets themself added.
	 */
	public boolean pathSum(TreeNode node, int sum, Stack<Integer> path){
		if(node == null)
			return false;
		
		
		if(node.left == null & node.right == null){ //leaf node
			if(node.data == sum)
			{
				path.add(node.data);
				return true;
			}
			else
				return false;
		}
		sum -= node.data;
		
		if(pathSum(node.left, sum, path)){
			path.add(node.data);
			return true;
		}
		if(pathSum(node.right, sum, path)){
			path.add(node.data);
			return true;
		}
		return false;
	}
	
	// my favorite
	// Same as above but adding the path during traversal from root to leaf.
	public boolean pathSum1(TreeNode node, int sum, int target, List<Integer> path){
		if(node == null)
			return false;
		
		path.add(node.data);
		sum += node.data;
		
		if(node.left == null & node.right == null){ //leaf node
			if(sum == target)
				return true;
			else
				return false;
		}
		if(pathSum1(node.left, sum, target, path))
			return true;
		if(pathSum1(node.right, sum, target, path))
			return true;
		
		path.remove(path.size()-1);
		return false;
	}
	
	public static void main(String arg[]){
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.right.right = new TreeNode(11);
		
		TreePathSum obj = new TreePathSum();
		Stack<Integer> st = new Stack<>();
		boolean result = obj.pathSum(root,  21,  st);
		while(!st.isEmpty())
			System.out.println(st.pop());
		System.out.println("-----------");
		ArrayList<Integer> list = new ArrayList<>();
		 obj.pathSum1(root,  0, 21,  list);
        for(int i : list)
		 System.out.println(i);
	}
}
