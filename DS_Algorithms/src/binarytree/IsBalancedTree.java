package binarytree;

/**
 * Check if the tree is balanced. Balanced means the diff between height of left and right should not be more than 1
 * @author suni
 *
 */
public class IsBalancedTree {

	// Same as getHeight algorithm.. while getting the height check in between to see if the height is -1 (which means imbalance)
	// if so return right there..
	public int getHeight(TreeNode node){
		if(node == null)
			return 0;
		
		int leftHeight = getHeight(node.left);	
		if(leftHeight == -1) 
			return -1;
	
		int rightHeight = getHeight(node.right);
		if(rightHeight == -1) 
			return -1;
		
		int diff = Math.abs(leftHeight - rightHeight);
		if(diff > 1)
			return -1;
		int height = Math.max(leftHeight, rightHeight) + 1;
		return height;
		
	}
	
	public static void main(String arg[]){
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        IsBalancedTree obj = new IsBalancedTree();
        int height = obj.getHeight(root);
        if(height == -1)
        	System.out.println("Imbalanced");
        else
        	System.out.println("Balanced");
	}
}
