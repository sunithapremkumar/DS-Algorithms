package ds;

import java.util.Random;

import binarysearchtree.TreeNode;
import binarysearchtree.RankFromStream.RankNode;

public class BinaryTreeNode {
	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;
	int size;
	
	public BinaryTreeNode(int data){
		this.data = data;
		size = 1;
	}
	
	public BinaryTreeNode find(TreeNode node){
		
		if(node == null)
			return null;
		BinaryTreeNode current = this;
		while(current != null){
			if(node.val == current.data)
				return current;
			if(node.val < current.data)
				current = current.left;
			else
				current = current.right;
		}
		return null;
		
	}
	public void insert1(BinaryTreeNode x){
		if(x == null)
			return;
		if(x.data <= data){
			if(left == null)
				left = x;
			else
				left.insert(x);
		}else{
			if(right == null)
				right = x;
			else
				right.insert(x);
		}
		size++;
	}

	public void insert(BinaryTreeNode node){
		if(node == null)
			return;
		BinaryTreeNode current = this, parent = null;
		while(true){
			parent = current;
			if(node.data < current.data){				
				current = current.left;
				if(current == null){
					parent.left = node;
					break;
				}
			}
			else{
				current = current.right;
				if(current == null){
					parent.right = node;
					break;
				}
			}
		}
		size++;
	}
	
	public BinaryTreeNode getRandomNode(){
		
		int leftSize = (left == null)? 0: left.size;
		Random random = new Random();
		int randomNum = random.nextInt(size);
		if(randomNum < leftSize)
			return left.getRandomNode();
		else if(randomNum == leftSize)
			return this;
		else
			return right.getRandomNode();
		
	}
	
	
	public void printTree(){
		traverse(this);
	}
	
	private void traverse(BinaryTreeNode node){
		if(node ==null)
			return;
		traverse(node.left);
		System.out.println(node.data);
		traverse(node.right);
	}

	public String toString(){
		return data+"";
	}
	
	public static void main(String...strings)
	{
		BinaryTreeNode root = new BinaryTreeNode(4);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(6);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(3);
        
       System.out.println(root.find(new TreeNode(6)));
       root.printTree();
       root.insert(new BinaryTreeNode(5));
       
       root.printTree();
       for(int i=0;i <5; i++)
    	   System.out.println("Random"+ root.getRandomNode());
	}
}
