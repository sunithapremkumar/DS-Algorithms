package binarytree;

import java.util.*;

/**
 * Given a binary tree containing only positive integers, flatten it into two
linked lists such that all the even numbers form a linked list to the left of the root
and all the odd numbers for a linked list to the right of the root. When complete,
the root node should take the value of zero.

You are free to use another data structure and you are allowed to swap the
integer values between two tree nodes.
The tree nodes do not have a parent pointer
The elements in the even list and odd list can be in any order.
 * @author prasunit
 *
 */
public class FlattenTheTree {


   static LinkedList<Node> evenList = new LinkedList<Node>();
   static LinkedList<Node> oddList = new LinkedList<Node>();
   
   // In order traversal
   public static void flattenTree(Node n){
   
     if(n == null)
       return;
       
     flattenTree(n.left);
     
     addToList(n.data);
         
     flattenTree(n.right);
   
   
   }
	
	public static void addToList(int data ){
	
	if(data % 2 == 0)
	   evenList.add(new Node(data));
	else
	   oddList.add(new Node(data));
	
	}
	
	
	public static Node createBinaryTree(){
		
		Node n = new Node(10);
		Node left = new Node(5);
		Node right = new Node(4);
		n.left =  left;
		n.right = right;
		
		n.left.left = new Node(3);
		n.left.right = new Node(6);
		
		n.right.left = new Node(1);
		n.right.right = new Node(8);
		
		return n;	
		
	}
	
	
	public static void printTree(Node r){
	   if( r == null)
	   return;
	   	   
	   //Printing left tree
	   Node n=r.left;
	   while(n != null){
	      System.out.println("Printing left tree" + n.data);
	      n = n.left;
	    }
	    
	    //Printing right tree
	    n = r.right;  
	    while(n != null){
	      System.out.println("Printing right tree" + n.data);
	      n = n.right;
	    }
	   
	}
	
	public static void main(String... str){
	
	 Node root = createBinaryTree();
	 flattenTree(root);
	
	 Node newroot = new Node(0);
	
	//Adding even linked list to left side of root
	 Node r = newroot;
	 for(Node n: evenList){
	 	r.left = n;
	 	r = n;
	 }
	 
	 //Adding odd linked list to right side of root
	 r = newroot;
	 for(Node n: oddList){
	 	r.right = n;
	 	r = n;
	 }
	 
	 printTree(newroot);
	}
	
}
