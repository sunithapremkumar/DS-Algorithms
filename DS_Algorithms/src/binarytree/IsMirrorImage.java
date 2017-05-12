package binarytree;
/**
 * Given a binary tree, check whether it is a mirror of itself.
 * @author suni
 *
 */
public class IsMirrorImage {
	
	 //For two trees to be mirror images, the following three
     // conditions must be true
     // 1 - Their root node's key must be same
     // 2 - left subtree of left tree and right subtree
     //      of right tree have to be mirror images
     // 3 - right subtree of left tree and left subtree
     //      of right tree have to be mirror images
	public static boolean isMirrorImage(TreeNode n1, TreeNode n2){
		
		if(n1 == null & n2 == null)
			return true;
		
		if(n1.data != n2.data)
			return false;
		
		if(!isMirrorImage(n1.left, n2.right))
			return false;
		if(!isMirrorImage(n1.right, n2.left))
			return false;
					
		return true;
	}
	
	public static void main(String arg[]){
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean output = IsMirrorImage.isMirrorImage(root, root);
        System.out.println(output);
	}

}
