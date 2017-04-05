package binarytree;

import java.util.*;

public class LevelOrderTraversal {

	
	public void levelTraversal(TreeNode node){
		if(node == null)
			return;
		
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()){
			
			TreeNode n =queue.poll();
			System.out.println(n.data);
			if(n.left != null)
				queue.add(n.left);
			if(n.right != null)
				queue.add(n.right);
			
		}
		
		
	}
	public static void main(String ag[]){
	 TreeNode root = new TreeNode(20);
     root.left = new TreeNode(8);
     root.left.left = new TreeNode(4);
     root.left.right = new TreeNode(12);
     root.left.right.left = new TreeNode(10);
     root.left.right.right = new TreeNode(14);
     root.right = new TreeNode(22);
     root.right.right = new TreeNode(25);
     
     new LevelOrderTraversal().levelTraversal(root);
	}
}
