package linkedlist;

import linkedlist.DetectLinkedListCycle.Node;

/**
 * Delete the nodes greater than a given integer
 * @author prasunit
 *
 */
public class DeleteNodes {
	 
	public static Node deleteNodes(Node head , int x){

		if (head==null) return null;
		

		Node prev = null;
		Node current = head;
		
		while (current!=null){
			if(current.data > x){
				if(prev == null)
					head = current.next;
				else
					prev.next=current.next;
			}
			else
				prev = current;
			current=current.next;
		}
		return head;
	}
	
	public static void main(String...strings){
	    
		
		Node n6 = new Node(3);
	    n6.next = null;
	    
		Node n5 = new Node(6);
		n5.next = n6;
		
		Node n4 = new Node(4);
		n4.next = n5;
		
		Node n3 = new Node(7);
		n3.next = n4;
		
		Node n2 = new Node(5);
		n2.next = n3;
		
		Node n1 = new Node(6);
		n1.next = n2;
		
		Node current = n1;
		while(current != null){
			System.out.println(current.data);
			current = current.next;
		}
		Node n = deleteNodes(n1,4);
		while(n != null){
			System.out.println("REsult: " + n.data);
		    n = n.next;
		}
		
	}
}
