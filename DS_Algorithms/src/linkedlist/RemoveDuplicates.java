package linkedlist;

import java.util.HashMap;

public class RemoveDuplicates {
	
	
	public static void main(String arg[]){
		
		removeDupes();
	}

	public static void removeDupes(){
		
		Node n = new Node(3, null);
		HashMap map = new HashMap();
		Node prev = null;
		while(n != null){
			
			if(map.containsKey(n.data))
			{
				prev.next=n.next;
			}
			else{
				map.put(n.data, true);
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
