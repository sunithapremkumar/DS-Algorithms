package binarytree;

import java.util.Stack;

public class InOrderTraversal {
	
	public void recursiveInOrder(TreeNode n){
		if(n == null)
			return;
		recursiveInOrder(n.left);
		System.out.println(n.data);
		recursiveInOrder(n.right);
		
	}

	public void iterativeInOrder(TreeNode n){
		
		Stack<TreeNode> st = new Stack<>();
		
		while(n != null){
			st.push(n);
			n = n.left;
		}
		
		while(!st.isEmpty()){
			TreeNode node = st.pop();
			if(node.right != null)
				st.push(node.right);
			System.out.println("Iterative "+ node.data);
			
		}
	}
	
	
	public static void main(String arg[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		InOrderTraversal obj = new InOrderTraversal();
		obj.recursiveInOrder(root);
		obj.iterativeInOrder(root);
		}
}
