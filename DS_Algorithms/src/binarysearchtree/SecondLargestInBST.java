package binarysearchtree;

/**
 * Find the second largest node in the Binary searchtree
 * @author suni
 *
 */
public class SecondLargestInBST {
	/**
	 *  case 1 - If node doesn't have right child, then the second largest is the largest node on its left side
	 *  case 2 - If the node has right child but that right child has no children, then the current node is the second largest.
	 *  case 3 - If the node has right child and it has its children, then the second largest lies on the right side
	 * @param node
	 * @return
	 */
	public TreeNode getSecondLargest(TreeNode node) throws Exception{
      if(node == null || (node.left == null & node.right ==null))
    		  throw new Exception("Tree must have atleast 2 nodes");
 
      TreeNode current = node;
      while(true){
         if(current.right == null) // Case 1
			 return getLargest(current.left);
		 // Case 2
		 if(current.right != null & (current.right.left == null && current.right.right ==null) )
				 return node;
         // Case 3
		 current = node.right;	  
	  }
	}
	
	private TreeNode getLargest(TreeNode node){
		if(node == null)
			return null;
		if(node.right  == null)
			return node;
		TreeNode cur = node;
		while(cur.right !=null){
			cur  = cur.right;
		}		
		return cur;							
	}
	

}
