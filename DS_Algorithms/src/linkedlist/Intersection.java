package linkedlist;

import linkedlist.DetectLinkedListCycle.Node;

/**
 * CTCI page 94
 * Given 2 singly linked list, check if they intersect. intersection node is same by reference
 * @author suni
 *
 */
public class Intersection {

	
	/**
	 * If 2 lists intersect, then their tails will be the same.
	 * bring the pointer of the longer list to the same position/length as shorter and from then on move one step on both until they collide.  
	 *
	 */
	public Node doesIntersect(Node l1, Node l2){
		
		if(l1 ==null || l2 == null)
			return null;
		
		Result result1 = length(l1); // find length and tail
		Result result2 = length(l2);
		int length1 = result1.size;
		int length2 = result2.size;
		
		if(result1.tail != result2.tail) // if both their tails are not same then they don't intersect
			return null;
		
		// Move the pointer of longer list ahead to match the length of shorter list
		Node longer = null;Node shorter = null;
		if(length1 > length2){
			shorter = l2;
			 longer = moveToPoint(l1, (length1-length2));
		}else{
			shorter = l1;
			 longer = moveToPoint(l2, (length2-length1));
		}
		
		// Start moving one step each
		while(shorter != longer)
		{
			shorter = shorter.next;
			longer = longer.next;
		}
		
		return shorter; // or longer
		
	}
	
	private Node moveToPoint(Node n, int diff){
		while(diff > 0){
			n = n.next;
			diff--;
		}
		return n;
	}
	
	//Just a wrapper to wrap 2 data to return
	private Result length(Node n){
		int size = 1;
		while(n.next != null){
			size++;
			n = n.next;
		}
		Result res = new Result(n, size);
		return res;
	}
	
	public class Result{
		Node tail;
		int size;
		
		public Result(Node n, int size){
			this.tail = n;
			this.size = size;
		}
	}
public static void main(String... atr){
		
	Node n6 = new Node(6);
    n6.next = null;
    
	Node n5 = new Node(1);
	n5.next = n6;
	
	Node n4 = new Node(7);
	n4.next = n5;	
	
	Node n3 = new Node(9);
	n3.next = n4;
	
	
	Node n2 = new Node(0);
	n2.next = n5;
	
	Node n1 = new Node(5);
	n1.next = n2;
	
	Node n = new Node(3);
	n.next = n1;
	
	Intersection  obj = new Intersection();
	
	 System.out.println(obj.doesIntersect(n3, n).data);
			
}
}
