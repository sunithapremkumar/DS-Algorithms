package binarytree;

/**
 * Given 2 nodes, find the common ancestor of those 2 nodes.
 * @author suni
 *
 */
public class FirstCommonAncestor {

	//Check if n is a decendent of  node
	private boolean isDecendent(TreeNode node, TreeNode n){
		if(node == null)
			return false;
		if(node.equals(n))
			return true;
		return (isDecendent(node.left, n) || isDecendent(node.right,n));
	}
	
	/**
	 * Find if n1 & n2 is decendent of a node starting from root.. if they are decendent but on different sides, then root is the ancenstor
	 * If decendent on same side, then continue checking by passing that same side node.
	 * @param node
	 * @param n1
	 * @param n2
	 * @return
	 */
	public TreeNode findCommonAncestorHelper(TreeNode node, TreeNode n1, TreeNode n2){
		
		if(node == null)
			return null;
		boolean n1_leftSide = isDecendent(node.left, n1);
		boolean n2_leftSide = isDecendent(node.left, n2);
		
		if(n1_leftSide != n2_leftSide){
			return node;
		}
		if(n1_leftSide)
			return findCommonAncestor(node.left, n1, n2);
		else
			return findCommonAncestor(node.right, n1, n2);
		
	}
	
	public TreeNode findCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2){
		//Error check if the n1, n2 not in tree
		if(!isDecendent(root, n1) || !isDecendent(root, n2))
				return null;
		return findCommonAncestorHelper(root, n1, n2);
	}
	
	 
	
}
