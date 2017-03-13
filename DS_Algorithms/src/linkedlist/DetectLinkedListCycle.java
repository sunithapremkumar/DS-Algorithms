package linkedlist;

/**
 * CTCI page 94
 * Detect if there is a cycle in linked list.. 
 * If so then find the loop starting point
 * @author suni
 *
 */
public class DetectLinkedListCycle {
	
	// Run slow node hop by 1 and fast node hop by 2, when they meet, they have cycle
	public static boolean detectCycle(Node n){
		
		
		Node slow, fast;
		slow = fast = n;
		
		while( fast != null && fast.next != null){
			
			slow = slow.next;
			fast = fast.next.next;		
			
			if(slow == fast)
				return true;
		}
		return false;
		
		
	}
	
	/**
	 *  Collision point (not necessarily be loop start) and head both are k nodes away from loop start. 
	 *  So have slow and fast pointer  reach the collision point
	 *  Then move the slow pointer to start, leaving fast at collision point.  
	 *  Now move both nodes one step until they collide.. That's the loop start point.
	 *  
	 *
	 */
	public Node detectLoopStart(Node n){
		
		// Reaching collision point
		Node slow, fast;
		slow = fast = n;
		
		while( fast != null && fast.next != null){
			
			slow = slow.next;
			fast = fast.next.next;		
			
			if(slow == fast)
				break;
		}
		
		if(fast == null || fast.next == null) // no loop check
			return null;
		
		slow = n;  // Move slow to head
		
		// Move one step both until they collide
		while(slow != fast)
		{
			slow = slow.next;
			fast = fast.next;
		}
		
		return fast; // or slow
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
		
		System.out.println((new DetectLinkedListCycle().detectLoopStart(n1)).data);
	}
}
