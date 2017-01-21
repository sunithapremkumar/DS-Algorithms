package binarytree;

import java.util.LinkedList;
import java.util.List;

/*
 * Create lists of list containing nodes at each level
 * 
 */
public class ListOfDepths {

	/**
	 * ALGOITHM : Breadth first search modified a bit
	 * @param node
	 * @return
	 */
	public List traverseLevels(TreeNode node){
		if(node == null)
			return null;
		LinkedList<List> resultList = new LinkedList<>();
		
		LinkedList<TreeNode> curList = new LinkedList<>();
		curList.add(node);
		
		while(curList.size() >0){
			resultList.add(curList);

			LinkedList<TreeNode> newList = new LinkedList<>();
			
			for(TreeNode n : curList){
				addChildrenToList(newList, n);				
			}			
			curList = newList;
		}
		return resultList;
	}
	
	private void addChildrenToList(List list, TreeNode n){
		if(n.left !=null)
			list.add(n.left);
		if(n.right !=null)
			list.add(n.right);
	}
	
	public void printList(List<List> list){
		if(list == null)
			return;
		for(List<TreeNode> l: list){
			System.out.println("");
			for(TreeNode n:l)
				System.out.print(n.data);
		}
	}
	public static void main(String arg[]){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(6);
		ListOfDepths obj = new ListOfDepths();
		List result = obj.traverseLevels(root);
		obj.printList(result);
	}
}