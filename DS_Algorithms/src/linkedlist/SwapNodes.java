package linkedlist;

import linkedlist.DetectLinkedListCycle.Node;
/**
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * @author suni
 *
 */
public class SwapNodes {
	
	 // just swap the pointers of 2 nodes.. keep track of prev node and point that as well to the swapped node.
	 public Node swapPairs(Node head) {
	        if(head == null)
	           return head;
	        Node cur = head;
	        if(head.next != null) // if there is only 1 node
	        	head = head.next;
	        Node prev = null;
	        while(cur !=null && cur.next !=null){
	        	Node nex = cur.next;
	            cur.next=  nex.next;
	            nex.next = cur;
	            if(prev != null)
	            	prev.next = nex;
	            prev = cur;
	            cur = cur.next;
	        }
	        
	        return head;
	        
	    }
	 public static void print(Node cur){
			while(cur != null){
				System.out.println("Data :" + cur.data );
				cur= cur.next;
			}
		}
	 public static void main(String arg[]){
			
			Node n6 = new Node(4);
		    n6.next = null;
		    
			Node n5 = new Node(3);
			n5.next = n6;
			
			Node n4 = new Node(2);
			n4.next = n5;
			
			Node n3 = new Node(1);
			n3.next = n4;
			
			SwapNodes obj = new SwapNodes();
			Node head = obj.swapPairs(n3);
			
			obj.print(head);
	 }	
}
