package binarytree;
/**
 * Given a Binary Search Tree (BST), modify it so that all greater values in the given BST are added to every node. For example, consider the following BST.

              50
           /      \
         30        70
        /   \      /  \
      20    40    60   80 

The above tree should be modified to following 

              260
           /      \
         330        150
        /   \       /  \
      350   300    210   80
 * @author suni
 *
 */
public class ReplaceNodeWithSum {
	
	
 
	//reverse inorder traversal.. right, center, left
   public static int addSum(TreeNode node,int sum){
	   if(node.right!=null)
		   sum=addSum(node.right,sum);
	   if(node!=null){
		   node.data+=sum;
		   sum=node.data;
	   }
	   if(node.left!=null)
		   sum=addSum(node.left,sum);
	   return sum;
   }
	
   public static void printTree(TreeNode n){
	   if(n == null)
		   return;
	   printTree(n.left);
	   System.out.println(n.data);
	   
	   printTree(n.right);
   }
   public static void main(String arg[]){
		TreeNode root = new TreeNode(50);
       root.left = new TreeNode(30);
       root.right = new TreeNode(70);
       root.left.left = new TreeNode(20);
       root.left.right = new TreeNode(40);
       root.right.left = new TreeNode(60);
       root.right.right = new TreeNode(80);
        ReplaceNodeWithSum.addSum(root, 0);
        
       ReplaceNodeWithSum.printTree(root);
	}

}
