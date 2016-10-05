package binarysearchtree;

public class IsBinaryTree {

	   Node previous = null;
	    boolean checkBST(Node n) {
	      if(n == null)
	         return true;
	      //Traverse left    
	      if(!checkBST(n.left)) return false;
	      //Traverse current   
	      if(previous != null){
	           if(previous.data >= n.data)
	                   return false;
	        }
	       previous = n;
	      //Traverse right    
	      if(!checkBST(n.right)) return false;
	        return true;
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
	        root.left = new Node(2);
	        root.right = new Node(5);
	        root.left.left = new Node(1);
	        root.left.right = new Node(3);
	 
	    	System.out.println(new IsBinaryTree().checkBST(root));
	    }
}
