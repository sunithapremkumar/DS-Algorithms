package linkedlist;

import linkedlist.DetectLinkedListCycle.Node;
/**
 * CTCI page 94
 * Find kth to last node
 * @author suni
 *
 */
public class KthToLast {

	
	  public int getKthtoLast(Node n, int k){
		  
		  if(n == null)
			  return -1;
		  
		  Node slow =n,  fast = n;
		  
		  while(fast != null && k >= 0){
			  fast = fast.next;
			  k--;
		  }
		  
		  while(fast != null){
			  slow = slow.next;
			  fast = fast.next;
				  
		  }		  
		  return slow.data;
	  }
	  
	  //using recursive
	  public int getKthtoLast1(Node n, int k){
		  if(n == null)
			  return -1;
		  
		  int index = getKthtoLast1(n.next, k) + 1;
		  
		  if(index == k)
			  System.out.println(n.data);
			  
		  return index;	  
	  }
		  
	  
	  public static void main(String arg[]){
		  KthToLast obj = new KthToLast();
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
		  
		   System.out.println(obj.getKthtoLast(n1, 3));

		  obj.getKthtoLast1(n1, 3);
	  }
}
