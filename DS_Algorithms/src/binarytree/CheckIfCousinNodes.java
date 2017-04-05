package binarytree;
/**
 * Given the binary Tree and the two nodes say ‘a’ and ‘b’, determine whether the two nodes are cousins of each other or not.

Two nodes are cousins of each other if they are at same level and have different parents.

Example

     6
   /   \
  3     5
 / \   / \
7   8 1   3
Say two node be 7 and 1, result is TRUE.
Say two nodes are 3 and 5, result is FALSE.
Say two nodes are 7 and 5, result is FALSE.
 * @author suni
 *
 */
public class CheckIfCousinNodes {

	TreeNode leftParent = null, rightParent = null;
	
	public int findLevelForNode(TreeNode root, int height, TreeNode x){
		
		if(root == null)
			return -1;
		else if(root.data == x.data){
			return height;
		}
		 
		int h = findLevelForNode(root.left, (height+1), x);
		if(h == -1)
			h = findLevelForNode(root.right, (height+1), x);
		return h;
	}
	
	public boolean isSibling(TreeNode root, TreeNode x, TreeNode y){
		if(root == null)
			return false;
		if((root.left == x && root.right == y) || (root.left == y && root.right == x))
			return true;
		
		return isSibling(root.left, x, y) || isSibling(root.right,x,y);
	}
	
	public boolean findCousins(TreeNode root, TreeNode x, TreeNode y){
		
		if(isSibling(root, x, y))
			return false;
		int x_level = findLevelForNode(root, 0, x);
		System.out.println(x_level);
		int y_level = findLevelForNode(root, 0, y);
		System.out.println(y_level);
		
		if(x_level == y_level)
			return true;
		return false;
	}
	public static void main(String arg[]){
		
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);
		
		CheckIfCousinNodes obj = new CheckIfCousinNodes();
		System.out.println(obj.findCousins(root, root.left.left, root.right.right));
	}
	
	
}
