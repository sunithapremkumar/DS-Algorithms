package binarytree;

/**
 * Find the height of the binary tree
 * @author suni
 *
 */
public class TreeHeight {

	
	public int getHeight(TreeNode node){
		if(node == null)
			return 0;
		
		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
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
        TreeHeight obj = new TreeHeight();
        System.out.println(obj.getHeight(root));
	}
	
}
