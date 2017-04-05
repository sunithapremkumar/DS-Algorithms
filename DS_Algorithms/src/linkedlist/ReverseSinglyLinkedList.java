package linkedlist;

import java.util.Stack;

public class ReverseSinglyLinkedList {

	
	public Node reverseLinkedList(Node node){
		Stack<Node> st = new Stack();
		
		while(node !=null){
			
			st.push(node);
			node = node.next;
		}
		//System.out.println(st);
		Node previous = null, current = null, head = st.peek();
		while(!st.isEmpty()){
		  	 current = st.pop();
		  	 //System.out.println(current.data);
		  	if(previous != null){
		  		previous.next=current;
		  	}
		  	previous = current;
		}
		if(previous != null) previous.next= null;
		
		return head;
		
	}
	
	//Reversing using iterative. the reverse list will be cloned copy
	public Node reverse(Node n1){
		
		if(n1 == null)
			return null;
		Node n2 = new Node(n1.data);
		
	    while(n1.next != null){
	    	Node n = new Node(n1.next.data);
	    	n.next  = n2;
	    	n1 = n1.next;
	    	n2 = n;
	    }
		return n2;
	}
	
	// Reversing using recursion. the reverse list will be cloned copy
   public Node reverse1(Node n1, Node n2){
		
		if(n1.next == null)
			return n2;
	
	    	Node n = new Node(n1.next.data);
	    	n.next  = n2;
	    	return reverse1(n1.next, n);
	}
	
   //Reversing linked list inline.. without cloning
   // Take next node and add it to front of the current node.. 
   public Node reverseInline( Node n, Node next, Node head){
	   if(next == null)
		    return n;
	   if(head == n) // setting the last node next to null.
		   n.next = null;
	    Node tmp = next.next; 
	    next.next = n;  
	  
	   Node r = reverseInline(next, tmp, head);
	   return r;
	  
   }
	public static class Node{
		public int data;
		public Node next = null;
		
		public Node(int d){
			data = d;
		}
		
		public String toString(){
			return data +"";
		}
	}
	
	public static void main(String arg[]){
		
		Node n1 = new Node(1);	
		Node n2 = new Node(3);
		Node n3 = new Node(5);
		Node n4 = new Node(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		/*print(n1);
		Node head = new ReverseSinglyLinkedList().reverseLinkedList(n1);
		print(head);
		
		System.out.println("-------------");
		Node head1 = new ReverseSinglyLinkedList().reverse(n1);
		print(head1);
		
		
		Node head2 = new ReverseSinglyLinkedList().reverse1(n1, new Node(n1.data));
		print(head2);
		*/
		System.out.println("-------------");
		Node head3 = new ReverseSinglyLinkedList().reverseInline(n1, n1.next, n1);
		print(head3);
	
	}
	
	public static void print(Node cur){
		while(cur != null){
			System.out.println("output" + cur.data);
			cur= cur.next;
		}
	}
}
