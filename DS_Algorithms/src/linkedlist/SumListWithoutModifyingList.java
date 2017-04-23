package linkedlist;

import linkedlist.DetectLinkedListCycle.Node;
/**
 *  Add 2 linked list without modifying the list or reversing the list.
 *  if they are given in right direction
 * i/p - (6->1->7) + (2->9->5) that is  617+295
 * o/p - 9->1->2 that is 912
 * @author suni
 *
 */
public class SumListWithoutModifyingList {

	public Node sum(Node l1, Node l2){
		int l1Length = length(l1); //calculate length
		int l2Length = length(l2);
		int diff = Math.abs(l1Length - l2Length);
		Node longNode = (l1Length > l2Length)? l1 : l2;
		Node shortNode = (l1Length > l2Length)? l2: l1;
		Node longer = longNode;
		Node shorter = shortNode;
		// Offsettting the long node to the point where its length is equal to short node
		if(diff > 0){
			int d = diff;
			Node p = longNode;
			while( d > 0){
				p = p.next;
				d--;	
			}
			longer  = p;
		}
	   PartialSum sum = add(longer, shorter);
	   //adding the remaining extra nodes of long node to the sum
	   if(diff > 0)
	    sum = addRemaining(longNode, sum, diff);
	   
	   
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
	
	private PartialSum addRemaining(Node l1, PartialSum sum, int diff){
		if(diff == 0)
			return sum;
		
		PartialSum s = addRemaining(l1.next, sum, (diff-1));
		
		int total = l1.data + s.carry;
		
		int last_digit = total%10;
		int carry = total/10;
		Node head = addToHead(s.resultNode, last_digit);
		s.resultNode = head;
		s.carry = carry;
		return s;	    
		
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
	private Node addToHead(Node n, int data){
		Node newNode =new Node(data);
		if(n != null){
			newNode.next =n;
			
		}
		return newNode;
	}
	public class PartialSum{
		Node resultNode;
		int carry;
		
	}
	public static void main(String arg[]){
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
		
		SumListWithoutModifyingList obj = new SumListWithoutModifyingList();
		
		Node result1 = obj.sum(n41, n21);
		
		while(result1 != null){
			System.out.println(result1.data);
		    result1 = result1.next;
		}
	}
}
