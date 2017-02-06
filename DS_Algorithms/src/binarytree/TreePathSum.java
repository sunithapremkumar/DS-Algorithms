package binarytree;


import java.util.Stack;

/**
 * Find a path from root to leaf that sums up to a number. 
 * https://youtu.be/Jg4E4KZstFE
 * @author suni
 *
 */
public class TreePathSum {

	/**
	 * Algo - Do pre-order traversal during which whenever we visit a node, substract the sum... when we reach the
	 * leaf node, see if the final sum and the node data is same, if so that's the path.. add it to stack
	 * and retur		n true..so that all the upper nodes in that path gets themself added.
	 */
	public boolean pathSum(TreeNode node, int sum, Stack<Integer> path){
		//if(node == null)
		//	return false;
		if(node.left == null & node.right == null){ //leaf node
			if(node.data == sum)
			{
				path.add(node.data);
				return true;
			}
			else
				return false;
		}
		if(pathSum(node.left, (sum-node.data) , path)){
			path.add(node.data);
			return true;
		}
		if(pathSum(node.right, (sum-node.data), path)){
			path.add(node.data);
			return true;
		}
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
	}
}
