package binarytree;


public class TreeNode <T> {
	int data;
	TreeNode left, right;

	TreeNode(int item) 
	{
		data = item;
		left = right = null;
	}

public boolean isLeaf(){
	return (left == null && right == null);
}
	
	public String toString(){
		return data +"";
	}
	
	public boolean equals(TreeNode n){
		return (this.data == n.data);
	}

}
