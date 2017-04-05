package binarytree;

import java.util.*;

public class PrintTreePaths {
	
	
	public List<Stack<TreeNode>> getPaths(TreeNode node){
		
		if(node == null)
			return null;
		if(node.isLeaf()){
			List<Stack<TreeNode>> list = new ArrayList<>();
			Stack<TreeNode> st = new Stack<>();
			st.add(node); list.add(st);
			return list;
		}
		
		List<Stack<TreeNode>> left_l = getPaths(node.left);
		List<Stack<TreeNode>> right_l = getPaths(node.right);
		
		return addToList(left_l, right_l, node);

		
	}
	
	private List<Stack<TreeNode>> addToList(List<Stack<TreeNode>> list1, List<Stack<TreeNode>> list2, TreeNode n){

		
		ArrayList<Stack<TreeNode>> newList = new ArrayList<>();
		if(list1 != null){
			for(Stack s : list1){
				s.add(n);
				newList.add(s);
			}
		}
		if(list2 != null){
			for(Stack s : list2){
				s.add(n);
				newList.add(s);
			}
		}
		return newList;
		
	}
	
	// Solution 2  - better and easier way
	// Just traverse the tree by regular traversal.. keep adding the node while traversing.. when it reaches leaf, add
	// to resultantList
	public void getAllPaths(TreeNode node, List<TreeNode> path, List<List<TreeNode>> list){
        
        if(node == null)
           return;
       
       path.add(node);
       if(node.left == null && node.right == null){
    	   ArrayList<TreeNode> row = new ArrayList(path);
           list.add(row);
           
       }          
       
       getAllPaths(node.left,  path, list);
       
       getAllPaths(node.right,  path, list);
       
       path.remove(path.size()-1); 
    }
	public static void main(String arg[]){
		
		  TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.left = new TreeNode(4);
	        root.left.right = new TreeNode(5);
	        root.right.left = new TreeNode(6);
	
	        root.right.right = new TreeNode(7);
	        
	        PrintTreePaths obj = new PrintTreePaths();
	        List<Stack<TreeNode>> resultList = obj.getPaths(root);
	        
	        
	        for(Stack<TreeNode> st : resultList){
	        	while(!st.isEmpty())
	        		System.out.print(st.pop().data);
	        	
	        	System.out.println("");
	        }
	        System.out.println("--------------------");
	        
	        List<List<TreeNode>> list  = new ArrayList<>();
	        obj.getAllPaths(root, new ArrayList<TreeNode>(), list);
	        
	        for(List<TreeNode> ll : list){
	        	for(TreeNode n : ll)
	        		System.out.print(n.data);
	        	
	        	System.out.println("");
	        }
	}
	
	


}
