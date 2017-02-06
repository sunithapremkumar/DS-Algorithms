package binarytree;

/**
 * Given 2 binary tree's , check if one is subtree of other. 
 *  A tree is subtree if all the nodes in t2 is a part of t1.
 * @author suni
 * 
 * ALGORITHM
 * 
 *  First check if the t2 is decendent of t1. If so check if they match from that point.
 *
 */
public class IsSubTree{

	//Check if n is a decendent of  node
		private boolean isDecendent(TreeNode node, TreeNode n){
			if(node == null)
				return false;
			if(node.equals(n)){   
				if(matchTree(node, n)) //if node is same, then check the subtree if they match
				  return true;				
			}
			return (isDecendent(node.left, n) || isDecendent(node.right,n));
		}
		

		// Match all nodes in botjh tree to check if they are same.
		private boolean matchTree(TreeNode t1, TreeNode t2){
			if(t1 == null && t1==null)
				 return true;
			if(t1 == null || t2 == null)
				return false;
			if(t1.data != t2.data)
				return false;
			
			return (matchTree(t1.left, t2.left) && (matchTree(t1.right, t2.right)));
		}
		
		public boolean containsTree(TreeNode t1, TreeNode t2){
			if(t2 == null)
				return true;
			return isDecendent(t1, t2);
		}
		
		public static void main(String arg[]){
			TreeNode t1 = new TreeNode(20);
	        t1.left = new TreeNode(8); 
	        t1.right = new TreeNode(22); 
	        t1.left.left = new TreeNode(4);
	        t1.left.right = new TreeNode(12); 
	        t1.left.right.left = new TreeNode(10); 
	        t1.left.right.right = new TreeNode(14);
	        
	        TreeNode t2 = new TreeNode(12);
	        t2.left = new TreeNode(10); 
	        t2.right = new TreeNode(14);
	        
	        IsSubTree obj = new IsSubTree();
	        boolean result = obj.containsTree(t1, t2);
	        System.out.println(result);
	        
		}
}