package binarysearchtree;
/**
 * Given a post order array. create a binary search tree.
 * 
 * 
 * Tree can be formed from the post order array only if it is a Binary search tree. else we cannot form with just post order array
 * we also need in order array
 * @author suni
 *
 */

public class CreateBSTFromPostOrderArray {

	//ALGO - In post order the last node forms root and all the values to its left will be its children. 
	// Parition the left side into 2 at the point where the value is greater than the last node which is root.
	// Create left and right nodes from that parition
	public static TreeNode createTree(int[] arr, int start, int end){
		if(end < start)
			return null;
		TreeNode mid = new TreeNode(arr[end]);
		int partition = findPartition(arr, start, end);
		mid.left = createTree(arr, start, partition-1);

		mid.right = createTree(arr, partition, end-1);
		
		return mid;
	}
	
	private static int findPartition(int[] arr, int start, int end){
		int i = start;
		while( i < end){
			if(arr[i] >= arr[end])
				break;
			i++;
		}
		return i;
	}
	
	public static void recursivePostOrder(TreeNode node){
		if(node == null)
			return;
		
		recursivePostOrder(node.left);
		recursivePostOrder(node.right);
		System.out.println(node.val);
	}
	
	public static void main(String arg[]){
		int[] arr = {0,1,2,6,5,4};
		TreeNode node = createTree(arr, 0, arr.length-1);
		recursivePostOrder(node);
	}
}
