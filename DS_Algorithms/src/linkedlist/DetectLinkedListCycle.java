package linkedlist;

public class DetectLinkedListCycle {
	
	// Run slow node hop by 1 and fast node hop by 2, when they meet, they have cycle
	public static boolean detectCycle(Node n){
		
		
		Node slow, fast;
		slow = fast = n;
		
		while( fast != null){
			
			slow = slow.next;
			if(fast.next != null)
				fast = fast.next.next;		
			
			if(slow == fast)
				return true;
		}
		return false;
		
		
	}

	public static class Node{
		public Node(int d){
			data = d;
		}
		public int data;
		public Node next;
	}
	
	public static void main(String... atr){
		
		Node n3 = new Node(3);
		
		Node n6 = new Node(6);
	    n6.next = n3;
	    
		Node n5 = new Node(5);
		n5.next = n6;
		
		Node n4 = new Node(4);
		n4.next = n5;
		
		
		n3.next = n4;
		
		Node n2 = new Node(2);
		n2.next = n3;
		
		Node n1 = new Node(1);
		n1.next = n2;
		
		System.out.println(new DetectLinkedListCycle().detectCycle(n1));
	}
}
