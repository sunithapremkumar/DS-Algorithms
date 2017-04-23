package binarysearchtree;


/**
 * Successor of a given node is the next higher node of that node. 
 * 1) If right subtree of given node is not NULL, then succ lies in right subtree. Do following.
		Go to right subtree and return the node with minimum key value in right subtree.
   2) If right sbtree of given node is NULL, then succ is one of the ancestors. Do following.
       Travel up using the parent pointer until you see a node which is left child of it’s parent. The parent of such a node is the succ.
 * @author suni
 *
 */
public class FindSuccessor {

	
	public TreeNode findSuccessor(TreeNode node){
		
		if((node == null)) 
			return null;
		
		if(node.right != null){ // go right and go left most
			TreeNode curNode = node.right;
		
			while(curNode.left != null){
				curNode = curNode.left;
			}
			return curNode;
		}
		else{ //travel up until we see a node left child of its parent. 
			
			TreeNode current = node;
			while(current.parent !=null){
				if(current.parent.left.val == current.val)
					return current.parent;
				current = current.parent;
			}
			return null;
		}
		
		
	}
	
	/**
	 * Another algorithm.. Do in order traversal and check the given node.. If we find then set it as prev.
	 * If the prev is set, then next node it touches would be its succesor.
	 * Cons: Unnecessarily traverse all down through the tree even if the node is at top somewhere.
	 * Pros: No parent pointer required
	 */
	TreeNode prev = null;
	public void inorderTraversal(TreeNode root, TreeNode node){
		if(root == null)
			return ;
		
		 inorderTraversal(root.left, node);
		 if(prev !=null){
			 System.out.println(root);
			 prev = null;
			 return;
		 }
		 if(root.val == node.val)
			 prev = root;
		
	
		 inorderTraversal(root.right, node);
	}
	
	public static void main(String arg[]){
				TreeNode root = new TreeNode(20);
		        root.left = new TreeNode(8); root.left.parent = root;
		        root.right = new TreeNode(22); root.right.parent = root;
		        root.left.left = new TreeNode(4); root.left.left.parent=root.left;
		        root.left.right = new TreeNode(12); root.left.right.parent = root.left;
		        root.left.right.left = new TreeNode(10); root.left.right.left.parent = root.left.right;
		        root.left.right.right = new TreeNode(14); root.left.right.right.parent = root.left.right;
        FindSuccessor obj = new FindSuccessor();
        TreeNode result = obj.findSuccessor(root.left.left);
        System.out.println(result);
        //obj.inorderTraversal(root, root.left.right);
        
	}
}
