package linkedlist;

/**
 * Given a linked list with random pointers. Create a copy of this linked list
 * @author suni
 * https://www.youtube.com/watch?v=-ExVoZXedo4
 */
public class CloneLinkedListWithRandomPointers {
	
	// ALGO - 1. Create a copy node and insert it next to original node
	// 2. point the random nodes of copied node 
	// 3. remove the links of original nodes weaved inbetweeb
	
	public static Node cloneList(Node node){
		
		Node cur = node;
		// creating copy of the nodes and inserting it into original list inbetween.
		while(cur != null)
		{
			Node newNode = new Node(cur.data);
			Node next = cur.next;
			cur.next = newNode;
			newNode.next = next;
			cur = next;
			
		}
		
		// Pointing random 
		cur = node;
		while(cur !=null){
			cur.next.random = cur.random.next;
			cur = cur.next.next;
		}
		
		//removing the links of original nodes
		cur = node;
		Node newHead = cur.next;
//		while(cur != null && cur.next.next != null){
//			Node origNext = cur.next.next;
//			cur.next.next = origNext.next;
//		    cur = origNext;
//		}
		Node c = newHead;
		while( c != null && c.next != null){
			c.next = c.next.next;
			c = c.next;
		}
		return newHead;
	}
	
	public static void print(Node cur){
		while(cur != null){
			System.out.println("Data :" + cur.data + "Random : "+ cur.random.data);
			cur= cur.next;
		}
	}
	public static void main(String arh[]){
		Node n1 = new Node(6);
		 Node n6 = new Node(3);
		    n6.next = null;
		    n6.random = n1;
		    
			Node n5 = new Node(6);
			n5.next = n6;
			n5.random = n6;
			
			Node n4 = new Node(4);
			n4.next = n5;
			n4.random = n6;
			
			Node n3 = new Node(7);
			n3.next = n4;
			n3.random = n4;
			
			Node n2 = new Node(5);
			n2.next = n3;
			n2.random = n5;
			
			//Node n1 = new Node(6);
			n1.next = n2;
			n1.random = n4;
			
			print(n1);
			System.out.println("---------------");
			Node newHead = cloneList(n1);
			print(newHead);
			
	}

}
