package binarytree;

import java.util.ArrayList;

public class TreeNode <T> {
	int data;
	ArrayList<TreeNode> pathList;
	TreeNode left, right;

	TreeNode(int item) 
	{
		data = item;
		left = right = null;
		pathList = new ArrayList<>();
	}

	public void addToPath(TreeNode parent){
		if(parent != null)
			pathList.addAll(parent.pathList);
		pathList.add(this);
	}
	
	public String toString(){
		return data +"";
	}

}
