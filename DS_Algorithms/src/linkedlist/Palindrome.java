package linkedlist;

import java.util.Stack;

import linkedlist.DetectLinkedListCycle.Node;

/**
 * CTCI page 94
 * 
 * Check if a given list is palindrome
 * @author suni
 *
 */
public class Palindrome {
      
	  /**
	   * Have a slow and fast pointer and proceed until fast is at end.. If so slow is at middle.. while doing so push the ekements to stack
	   * Then each each item from stack with the slow pointer moving 1 offset.
	   * @param n
	   * @return
	   */
	  public boolean isPalindrome(Node n){
		  
		  Node slow = n;
		  Node fast = n;
		  Stack<Integer> st = new Stack<>();
		  //Positioning fast node
		  while(fast != null && fast.next != null){
			  st.push(slow.data);
			  slow = slow.next;
			  fast = fast.next.next;
		  }
		  
		  if(fast != null)
			  slow = slow.next;
		  
		  // Now slow is in middle. Pop each item from stack and check with slow pointer.
		  while(slow != null){
			  if(slow.data != st.pop())
				  return false;			  
			  slow = slow.next;
		  }
		  
		  return true;
	  }
	  
	  public static void main(String arg[]){
		  
		  Palindrome obj = new Palindrome();
		  
		  	Node n6 = new Node(5);
		    n6.next = null;
		    
			Node n5 = new Node(9);
			n5.next = n6;
			
			Node n4 = new Node(7);
			n4.next = n5;
		
			
			Node n2 = new Node(9);
			n2.next = n4;
			
			Node n1 = new Node(5);
			n1.next = n2;
			
		  System.out.println(obj.isPalindrome(n1));
				  
	  }
}
