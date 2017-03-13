package ds;

public class SinglyLinkedList {
	
	 private Node head = null;
	 
	 public void add(int n){
		 Node node = new Node(n);
		 if(head == null)
			 head = node;
		 else{
			 Node current = head;
			  while(current.next != null){
				  current = current.next;
			  }
			  current.next = node;
		 }
	 }
	
	 public void delete(int d){
		 Node current = head;
		 Node prev = null;
		 while(current != null){
		   if(current.data == d)
		   {
			   if(current == head)
			   {
				   head = head.next;
				   return;
			   }else{
				   prev.next = current.next;
				   return;
			   }
			  
		   }
		   prev = current;
		   current = current.next;
		 }
		 
		 
	 }
	
	
	public class Node{
		int data;
		Node next;
		
		public Node(int dat){
			data = dat;
		}
	}

}
