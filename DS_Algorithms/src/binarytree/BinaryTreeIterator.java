package binarytree;

import java.util.*;

/**
 * Write a binary tree iterator where the order of the iterator goes through the nodes in level-order traversal 
 * (top-down and left to right)
 * @author prasunit
 *
 */
public class BinaryTreeIterator {

	Queue<Node> queue = new LinkedList<>();
	public BinaryTreeIterator(Node root){
		if(root != null)
			queue.add(root);
	}
	
	public boolean hasNext(){
		return (!queue.isEmpty());
	}
	
	public Node next(){
		Node n = queue.remove();
		if(n == null)
			return null;
			
		if(n.left != null) queue.add(n.left);
		if(n.right != null) queue.add(n.right);
		
		return n;
	}
	
	public static void main(String...strings){
		    Node root = new Node(20);
	        root.left = new Node(8);
	        root.left.left = new Node(4);
	        root.left.right = new Node(12);
	        root.left.right.left = new Node(10);
	        root.left.right.right = new Node(14);
	        root.right = new Node(22);
	        root.right.right = new Node(25);
	        
	        BinaryTreeIterator iterator = new BinaryTreeIterator(root);
	        
	        while(iterator.hasNext())
	        	System.out.println(iterator.next().data);
	        
	}
}
