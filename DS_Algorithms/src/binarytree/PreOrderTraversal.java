package binarytree;

import java.util.Stack;


public class PreOrderTraversal {

	
	public void recursivePreOrder(TreeNode node){
		if(node == null)
			return;
		System.out.println(node.data);
		recursivePreOrder(node.left);
		recursivePreOrder(node.right);
	}
	
	public void iterativePreOrder(TreeNode node){
		Stack<TreeNode> st = new Stack<>();
		st.push(node);
		
		while(!st.isEmpty()){
			TreeNode n = st.pop();
			System.out.println(n.data); // since pre-order is printed from top... just print it inline 
			if(n.right !=null)    // since we push it to stack push in the opposite order of what we need. Since we need left first and then right.. pushed right first.
				st.push(n.right);
			if(n.left !=null)
				st.push(n.left);
		}
	}
	
	public static void main(String arg[]){
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(5);
	root.left.left = new TreeNode(3);
	root.left.right = new TreeNode(4);
	root.right.right = new TreeNode(6);
	PreOrderTraversal obj = new PreOrderTraversal();
	obj.recursivePreOrder(root);
	obj.iterativePreOrder(root);
	}
}
