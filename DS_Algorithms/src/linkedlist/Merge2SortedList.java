package linkedlist;

/**
 *  Merge 2 sorted linked list.
 * @author suni
 *
 */
public class Merge2SortedList {

	 // merge sort algorithm..  but use the dummy node as head
	// 
	 public Node mergeTwoLists(Node l1, Node l2) {
	        if( l1 == null )
	           return l2;
	        if(l2 == null)
	           return l1;
	        Node head = new Node(0); // dummy node as head
	        Node l3 = head;
	        while(l1 != null & l2 != null){
	            
	            if(l1.data < l2.data){
	                l3.next = l1;  //when changing the pointer use l3.next instead of just l3 = l1
	                l1 = l1.next;
	            }
	            else{
	               l3.next = l2;
	               l2 = l2.next;
	            }
	            l3 = l3.next;
	        }
	        
	        if(l1 != null){
	            l3.next =l1;
	        }
	         if(l2 != null){
	            l3.next = l2;
	        }
	        
	        return head.next; // skipping dummy node
	    }
}
