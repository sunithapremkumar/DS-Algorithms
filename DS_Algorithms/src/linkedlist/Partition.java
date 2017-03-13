package linkedlist;

import linkedlist.DetectLinkedListCycle.Node;

/**
 * CTCI page 94
 * 
 * Parition the list in such a way all the elements smaller tha  k appears before the elements greater than or equal to k
 * @author suni
 *
 */
public class Partition {

	 /**
	  * ALGO - Traverse the list, add the lesser elements to head and bigger elements to tail. 	
	  * @param n1
	  * @param k
	  * @return
	  */
	  public Node partition(Node n1, int k){
		  
		  Node head = n1;
		  Node tail = n1;
		  
		  Node n = n1.next;
		  while(n != null){
			  Node next = n.next;
			  if(n.data < k){
				  n.next = head;
				  head = n;
			  }else{
				  tail.next = n;
				  tail = n;
			  }
			  n = next;
		  }
		  
		  tail.next = null;
		  return head;
	  }
	  
	  public static void main(String arg[]){
		  Node n6 = new Node(1);
		    n6.next = null;
		    
			Node n5 = new Node(2);
			n5.next = n6;
			
			Node n4 = new Node(10);
			n4.next = n5;
			
			Node n3 = new Node(5);
			n3.next = n4;
			
			Node n2 = new Node(8);
			n2.next = n3;
			
			Node n1 = new Node(5);
			n1.next = n2;
			
			Node n = new Node(3);
			n.next = n1;
			
			Partition obj = new Partition();
			
			Node res = obj.partition(n, 5);
			
			while(res != null){
				System.out.println(res.data);
				res = res.next;
			}
			
	  }
}
