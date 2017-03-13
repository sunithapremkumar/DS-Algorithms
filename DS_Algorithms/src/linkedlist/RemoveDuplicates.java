package linkedlist;

import java.util.*;

public class RemoveDuplicates {
	
	
	public static void main(String arg[]){
		
		removeDupes();
	}

	public static void removeDupes(){
		
		Node n = new Node(3, null);
		HashSet<Integer> map = new HashSet<>();
		Node prev = null;
		while(n != null){
			
			if(map.contains(n.data))
			{
				prev.next=n.next;
			}
			else{
				map.add(n.data);
				prev = n;
			}
						
			n = n.next;
		}
		
	}
	
	public static class Node{
		int data;
		Node next;
		
		public Node(int dat, Node n){
			data = dat;
			next = n;
		}
	}
}
