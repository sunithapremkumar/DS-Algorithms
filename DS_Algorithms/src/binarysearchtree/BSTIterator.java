package binarysearchtree;

import java.util.Stack;

import binarysearchtree.IsBinaryTree.Node;


/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *  Calling next() will return the next smallest number in the BST.
 *  Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
 * @author prasunit
 *
 *  Algorithm
 *   1. To first know the minimum value, we need to iterate al through the left end add only those left notes to stack.
 *   2. As and when the  nodes are accessed in next (), load the right node (lazy loading)
 */
public class BSTIterator {

	Stack<Node> stack = new Stack<>();

    public BSTIterator(Node root) {
        addToStack(root);
    }
    
    private void addToStack(Node n){
      while( n != null){
            stack.push(n);
            n = n.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (!stack.isEmpty());
    }

    /** @return the next smallest number */
    public Node next() {
        
    	Node node = stack.pop();
        if(node == null)
          return null;
        if(node.right != null){
            addToStack(node.right);
        }
        
        return node;
    }
    
    static class Node 
    {
        int data;
        Node left, right;
      
        Node(int item) 
        {
            data = item;
            left = right = null;
        }
    }
    
	
	public static void main(String...strings)
	{
		Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        
        BSTIterator iterator = new BSTIterator(root);
        while(iterator.hasNext())
        	System.out.println(iterator.next().data);
	}
}
