package graph;

import java.util.HashMap;

/**
 * https://youtu.be/ID00PMy0-vE
 * 
 * @author prasunit
 *
 * Utility class used by other graph algorithms. It 3 methods
 * makeSet, union and findSet
 */
public class DisjointSet {
	
	private HashMap<Long, Node> map = new HashMap<>();
	
	class Node{
		long data;
		int rank;
		Node parent;
	}
	
	public void makeSet(long data){
		Node node = new Node();
		node.data = data;
		node.rank = 0;
		node.parent = node;
		map.put(data,  node);
	}

	//merge 2 sets if they are part of different set
	public void union(long data1, long data2){
		
		Node node1 = map.get(data1);
		Node node2 = map.get(data2);
		
		Node parent1 = findSet(node1); // find their root parent/representative
		Node parent2 = findSet(node2);

		if(parent1.data == parent2.data) //both are in same set no need to combine
			return;
		if(parent1.rank >= parent2.rank){ //Merge based on rank. lower rank node will be child of higher rank node
			if(parent1.rank == parent2.rank) // if the rank is equal, increment one of the node's rank and add other as child.
				parent1.rank++;
			parent2.parent = parent1;
		}else
			parent1.parent = parent2;
		
	}
	
	public long findSet(long data){
		return findSet(map.get(data)).data;	}
	
	
	public Node findSet(Node n){
		Node parent = n.parent;
		if(parent == n)
			return n;
		n.parent = findSet(n.parent); //path compression happening here by setting the top parent to the decendent nodes;
		return n.parent;
	}
	
	public static void main(String...strings)
	{
		 DisjointSet ds = new DisjointSet();
	        ds.makeSet(1);
	        ds.makeSet(2);
	        ds.makeSet(3);
	        ds.makeSet(4);
	        ds.makeSet(5);
	        ds.makeSet(6);
	        ds.makeSet(7);

	        ds.union(1, 2);
	        ds.union(2, 3);
	        ds.union(4, 5);
	        ds.union(6, 7);
	        ds.union(5, 6);
	        ds.union(3, 7);

	        System.out.println(ds.findSet(1));
	        System.out.println(ds.findSet(2));
	        System.out.println(ds.findSet(3));
	        System.out.println(ds.findSet(4));
	        System.out.println(ds.findSet(5));
	        System.out.println(ds.findSet(6));
	        System.out.println(ds.findSet(7));
	}
}
