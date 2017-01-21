package binarysearchtree;

public class CreateBSTFromSortedArray {
	public TreeNode convert(int[] arr, int start, int end){
		 if(end < start)
			 return null;
		 int mid = (start +end)/2;
		 TreeNode midNode = new TreeNode(arr[mid]);
		 
		 midNode.left = convert(arr, start, mid-1);
		 midNode.right = convert(arr, mid+1, end);
		 
		 return midNode;
	 }
	 
	 public void printTree(TreeNode node){
		 if(node == null)
			 return;
		 printTree(node.left);
		 System.out.println(node.val);
		 printTree(node.right);
	 }
	 
	 public static void main(String arg[]){
		 int[] arr = {1,2,3,4,5,6};
		 CreateBSTFromSortedArray obj = new CreateBSTFromSortedArray();
		 TreeNode node = obj.convert(arr, 0, arr.length-1);
		 obj.printTree(node);
	 }

}
