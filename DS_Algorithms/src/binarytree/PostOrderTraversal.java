package binarytree;

import java.util.Stack;
 

public class PostOrderTraversal {

	//Recursive
	public void recursivePostOrder(TreeNode node){
		if(node == null)
			return;
		
		recursivePostOrder(node.left);
		recursivePostOrder(node.right);
		System.out.println(node.data);
	}
	
	//iterative using stack
	public void iterativePostOrder(TreeNode node){
		Stack<TreeNode> st = new Stack<>();
		Stack<TreeNode> resultSt= new Stack<>(); //Since post order is printed in bottom to top, using stack
		st.push(node);
		
		while(!st.isEmpty()){
			TreeNode n = st.pop();
			resultSt.push(n);
			if(n.left !=null)   //Here we don't need to push in opp order as we use 2 stacks, the output will be back in right order of insert.
				st.push(n.left);
			if(n.right !=null)
				st.push(n.right);
		}
		
		while(!resultSt.isEmpty())
			System.out.println(resultSt.pop().data);
	}
	
	public static void main(String arg[]){
	TreeNode root = new TreeNode(1);
	root.left = new TreeNode(2);
	root.right = new TreeNode(5);
	root.left.left = new TreeNode(3);
	root.left.right = new TreeNode(4);
	root.right.right = new TreeNode(6);
	PostOrderTraversal obj = new PostOrderTraversal();
	obj.recursivePostOrder(root);
	obj.iterativePostOrder(root);
	}
	
}
