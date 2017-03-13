package linkedlist;

import linkedlist.DetectLinkedListCycle.Node;

/**
 * CTCI page 94
 * You have 2 numbers represented by Linjked list where each node contains 1 digit. The digits are stored in reverse order. Write a funciton
 * to add the 2 numbers and return the sum as linked list
 * Example  
 * i/p - (7->1->6) + (5->9->2) that is  617+295
 * o/p - 2->1->9 that is 912
 * 
 * Follow up Qn - What if they are given in right direction
 * i/p - (6->1->7) + (2->9->5) that is  617+295
 * o/p - 9->1->2 that is 912
 * @author suni
 *
 */
public class SumLists {

	/**
	 * Tqke each digit from both list and total. add the result digit in result list. Continue this recursively until either of the list is
	 * null or the carry is '0'.
	 * @param l1
	 * @param l2
	 * @param carry
	 * @return
	 */
	public Node sum(Node l1, Node l2, int carry){
		if(l1 == null && l2 == null && carry==0)
			return null;
		 
		   int l1_data =0, l2_data =0;
		   if(l1 != null)
			   l1_data = l1.data;
		   if(l2 != null)
			   l2_data = l2.data;
		   
		   int sum = l1_data +l2_data + carry;  //sum
		   
		   int last_digit = sum % 10; // create node with last digit
		   carry = sum/10;
		   
		   Node res = new Node(last_digit);
		   Node result_node = sum((l1 !=null)? l1.next:null, (l2 !=null)? l2.next:null, carry);
		   
		   res.next = result_node;
		   return res;	    
	}
	
	// Sum if the input data is given in right order 
	// like 6->1->7 & 2->9->5
	// ALGO same as before.. but first recurse and the  do sum logic.. here we also need to take care of shorter length numbers by padding zeros
	public Node sum1(Node l1, Node l2){
		int l1Length = length(l1); //calculate length
		int l2Length = length(l2);
		if(l1Length < l2Length)
			l1 = padZeros(l1, (l2Length-l1Length));
		else
			l2 = padZeros(l2, (l1Length-l2Length));
	
	   PartialSum sum = add(l1, l2);
	   
	   if(sum.carry ==0)
		   return sum.resultNode;
	   else{
		  return  addToHead(sum.resultNode, sum.carry);
	   }
		   
	}
	
	
	private PartialSum add(Node l1, Node l2){
		if(l1 == null && l2 == null){
		
			return new PartialSum();
		}
		PartialSum result = add(l1.next,l2.next);
		 
		   int sum = l1.data +l2.data + result.carry;
		   
		   int last_digit = sum % 10; // create node with last digit
		   int carry = sum/10;
		   
		   Node head = addToHead(result.resultNode, last_digit);
		   result.resultNode = head;
		   result.carry = carry;
		   return result;	    
	}
	
	private Node addToHead(Node n, int data){
		Node newNode =new Node(data);
		if(n != null){
			newNode.next =n;
			
		}
		return newNode;
	}
	
	private Node padZeros(Node n, int count)
	{
		Node head = n;
		for(int i=0; i< count; i++){
			head = addToHead(head, 0);
		}
		return head;
	}
	
	private int length(Node n){
		int cnt = 0;
		while(n != null)
		{
			cnt++;
			n = n.next;
		}
		return cnt;
	}
	public class PartialSum{
		Node resultNode;
		int carry;
		
	}
	
	public static void main(String arg[]){
		
		Node n6 = new Node(6);
	    n6.next = null;
	    
		Node n5 = new Node(1);
		n5.next = n6;
		
		Node n4 = new Node(7);
		n4.next = n5;
		
		
		Node n3 = new Node(2);
		n3.next = null;
		
		Node n2 = new Node(9);
		n2.next = n3;
		
		Node n1 = new Node(5);
		n1.next = n2;
		
		SumLists obj = new SumLists();
		Node result = obj.sum(n4,  n1, 0);
		
		while(result != null){
			System.out.println(result.data);
		    result = result.next;
		}
		
		System.out.println(" RESULT if RIGHT DIRECTION*****");
		Node n61 = new Node(7);
	    n61.next = null;
	    
		Node n51 = new Node(1);
		n51.next = n61;
		
		Node n41 = new Node(6);
		n41.next = n51;
		
		
		Node n31 = new Node(5);
		n31.next = null;
		
		Node n21 = new Node(9);
		n21.next = n31;
		
		Node n11 = new Node(2);
		n11.next = n21;
		
		Node result1 = obj.sum1(n41, n11);
		
		while(result1 != null){
			System.out.println(result1.data);
		    result1 = result1.next;
		}
	}
}
