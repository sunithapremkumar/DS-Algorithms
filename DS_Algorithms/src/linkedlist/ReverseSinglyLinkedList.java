package linkedlist;

import java.util.Stack;

public class ReverseSinglyLinkedList {

	
	public Node reverseLinkedList(Node node){
		Stack<Node> st = new Stack();
		
		while(node !=null){
			
			st.push(node);
			node = node.next;
		}
		System.out.println(st);
		Node previous = null, current = null, head = st.peek();
		while(!st.isEmpty()){
		  	 current = st.pop();
		  	 System.out.println(current.data);
		  	if(previous != null){
		  		previous.next=current;
		  	}
		  	previous = current;
		}
		if(previous != null) previous.next= null;
		
		return head;
		
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
		
		print(n1);
		Node head = new ReverseSinglyLinkedList().reverseLinkedList(n1);
		print(head);
	
	}
	
	public static void print(Node cur){
		while(cur != null){
			System.out.println("output" + cur.data);
			cur= cur.next;
		}
	}
}
