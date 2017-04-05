package binarytree;

public class BoundaryTraversal {
   public Node root;
	
   public void printBoundary(Node node){
	   System.out.println(node.data);

	   // Print the left boundary in top-down manner.
	   printBoundaryLeft(node.left);

	   //Print leaf nodes
	   printLeaves(node);
	  // printLeaves(node.right);

       // Print the right boundary in bottom-up manner
	   printBoundaryRight(node.right);
	   
   }
   
   //Do regular traversal and check if the node is leaf
   public void printLeaves(Node n){
	   if(n == null)
		   return;
		   printLeaves(n.left);
		   
		   printLeaves(n.right);
		   if (n.left == null && n.right == null)
			   System.out.println(n.data);
		   
	   
   }
   
 
   public void printBoundaryLeft(Node n) {

		if (n == null)
			return;		

		if (n.left != null) {
			System.out.println(n.data);
			printBoundaryLeft(n.left);
		} else if (n.right != null) {
			System.out.println(n.data);
			printBoundaryLeft(n.right);
		}
  
  }
   
public void printBoundaryRight(Node n){
	   
	   if(n == null)
		  return;
		   if(n.right != null){			  
			   printBoundaryRight(n.right);
			   System.out.println(n.data);
			   
		   }
		   else if(n.left != null){			   
			   printBoundaryRight(n.left);
			   System.out.println(n.data);
			   
		   }
			  
	   
   }
	
	 public static void main(String args[]) 
	    {
		 BoundaryTraversal tree = new BoundaryTraversal();
	        tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(12);
	        tree.root.left.right.left = new Node(10);
	        tree.root.left.right.right = new Node(14);
	        tree.root.right = new Node(22);
	        tree.root.right.right = new Node(25);
	        tree.printBoundary(tree.root);
	  
	    }
}

class Node 
{
    int data;
    Node left, right;
  
    Node(int item) 
    {
        data = item;
        left = right = null;
    }
}
