package binarytree;

import java.util.ArrayList;

public class TreePathSumsToNumber {
	
	static ArrayList<Integer> pathList = new ArrayList<>();
	
	//Traverse the tree in preorder traversal while recording the node path along with.
	public static void findPath(TreeNode node, TreeNode parent, int number){
		
		if(node == null)
			return;

		node.addToPath(parent); // recording node path in each node
		if(node.left == null && node.right == null){ //leaf node
			evaluate(node.pathList, node, number);
		}
			
		findPath(node.left, node, number);
		findPath(node.right, node, number);
	}
	
	// this method is just for Printing all the path to the leaf node 
	private static void evaluate(ArrayList<TreeNode> list, TreeNode node, int number){
		System.out.println("\n Printing leaf: "+ node);
		int[] array = new int[list.size()]; // converting list of nodes to int[] containing just data
		int i=0;
		for(TreeNode n:list){
			array[i] = n.data; 
			i++;
			System.out.print(n.data);
		}		
		findContigousPath(array, number);	
	}
	
	// Finding path sums up to number
	private static void findContigousPath(int[] array, int number){
		long runningTotal =0; int start =0, index =0;
		while(index < array.length){
			runningTotal += array[index];
			while(runningTotal > number && (start < index)){
				runningTotal = runningTotal - array[start];
				start++;
			}
			if(runningTotal == number)
				printPath(array, start, index);

			index++;
		}
}

	private static void printPath(int[] array, int start, int end){
		System.out.println("");
		for(int i=start; i<=end; i++)
			System.out.print(" Result Path : "+ array[i]);
	}
	
	public static void main(String...strings){
		    TreeNode root = new TreeNode(2);
	        root.left = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(8);
	        root.right = new TreeNode(5);
	        root.right.left = new TreeNode(6);
	        root.right.right = new TreeNode(-2);
	        root.right.right.left = new TreeNode(2);
	        
	        findPath(root, null, 7);
	}

}
