package binarysearchtree;

public class IsBinaryTree {

	   Node previous = null;
	   // in order traversal with a previous variable outside the method
	    boolean checkBST(Node n) {
	      if(n == null)
	         return true;
	      //Traverse left    
	      if(!checkBST(n.left)) return false;
	      //Traverse current   
	      if(previous != null){
	          // if(n.data <= previous.data)
	    	  if(previous.data >= n.data)
	                   return false;
	        }
	       previous = n;
	      //Traverse right    
	      if(!checkBST(n.right)) return false;
	        return true;
	    }
	    
	    // This is without having any variable outside the method. self contained method
	    boolean checkBST1(Node n, int min, int max){
	    	if(n == null)
	    		return true;
	    	if((n.data >min) && (n.data < max) && checkBST1(n.left,min, n.data) && checkBST1(n.right, n.data, max))
	    		return true;
	    	else
	    		return false;
	    	
	    }
	    
	    static class Node
	    {
	        int data;
	        Node left, right;
	     
	        public Node(int item)
	        {
	            data = item;
	            left = right = null;
	        }
	    }
	    public static void main(String...strings ){
	    	Node root = new Node(4);
	        root.left = new Node(8);
	        root.right = new Node(5);
	        //root.left.left = new Node(1);
	        //root.left.right = new Node(3);
	 
	    	//System.out.println(new IsBinaryTree().checkBST(root));
	        System.out.println(new IsBinaryTree().checkBST1(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	    }
}
