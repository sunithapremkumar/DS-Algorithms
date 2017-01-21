package binarytree;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
 * @author suni
 *
 */
public class FlatternBinaryTree {

	/**
	 * Algo: If the node has right child push it to stack. If it has left child move to right.
	 * change the node to node.right and iterate until p is null or stack empty
	 * @param node
	 */
	public void flatten(TreeNode node){
        if(node == null)
           return;
          Stack<TreeNode> st = new Stack<>();
          TreeNode p = node;
          while((p != null) || (!st.isEmpty()))
          {
              if(p.right != null)
                 st.push(p.right);
              if(p.left !=null){     
                 p.right = p.left;
                 p.left = null;
              }
              else if(!st.isEmpty()){
                  TreeNode n = st.pop();
                  p.right = n;
              }     
              p = p.right;
          }
    }
   
   
    
    private void print(TreeNode node){
    	System.out.println("");
    	while(node !=null){
	          System.out.print(node.data);
	          node = node.right;
    	}
    }
	public static void main(String arg[]){
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        FlatternBinaryTree obj = new FlatternBinaryTree();
        obj.flatten(root);
        obj.print(root);
	}
	
	
}
