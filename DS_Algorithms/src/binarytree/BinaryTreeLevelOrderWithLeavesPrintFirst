package binarytree;

import java.util.*;
import java.util.HashMap;
/**
 * print all leaves then next level from bottom , then next level until root.
 * @author prasunit
 * 
 *                   1
 *                2     3
 *              4   5  6  7
 *            8    9        10
 *   
 *  Output:
 *   8,9,6,10
 *   4,5,7
 *   2,3
 *   1         
 */

//O(n) time and O(n) space
public class BinaryTreeLevelOrderWithLeavesPrintFirst {

	HashMap<Integer, List> map = new HashMap<>();
	
	//Do post order traversal to touch all nodes. Keep track of height. Update the map with height and corresponding nodes. 
	public void traverseTree(Node n, int h){
		
		if (n == null)
			return;
		h++;
		traverseTree(n.left, h);
		traverseTree(n.right, h);
		if(isLeaf(n)){
			updateMap(-1,n);
		}
		else
			updateMap(h, n);
	}
		
		public  boolean isLeaf(Node n){
			return (n.left == null && n.right == null);
		}
		
		public  void updateMap(int key, Node n){
			
			if(map.get(key) == null){
				ArrayList<Node> list = new ArrayList<>(); list.add(n);
				map.put(key, list);
			}
			else{
				 map.get(key).add(n);
			}
		}
		
		public  void print(){
			int size = map.size();
			if(size <=0) return;
			
			List<Node> leafNodes = map.get(-1);
			for(Node n: leafNodes)
				System.out.print(n);
			
			int index = size -2;
			while(index >=0){
				System.out.println("");
				List<Node> list = map.get(index);
				for(Node n: list)
					System.out.print(n);
				index--;
			}
			
		}
		public static void main(String ar[]){
			 Node root = new Node(1);
		        root.left = new Node(2);
		        root.left.left = new Node(4);
		        root.left.right = new Node(5);
		        root.left.left.left = new Node(8);
		        root.left.right.left = new Node(9);
		        root.right = new Node(3);
		        root.right.left = new Node(6);
		        root.right.right = new Node(7);
		        root.right.right.right = new Node(10);
		        BinaryTreeLevelOrderWithLeavesPrintFirst obj = new BinaryTreeLevelOrderWithLeavesPrintFirst();
		        obj.traverseTree(root, -1);
		        obj.print();
		}
}
