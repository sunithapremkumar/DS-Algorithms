package linkedlist;

/**
 * sort the linked list using insertion sort
 * @author suni
 *
 */
public class InsertionSortList {
	
	//this is actually selection sort
    public static  ListNode insertionSortList(ListNode head) {
        
        ListNode slow = head;
        ListNode slowPrev = null;
        while(slow != null){
            
            ListNode min = slow;
            ListNode fast = slow; 
            ListNode fastPrev = null;
            while(fast != null){
                
                if(fast.val < min.val){
                    min = fast;
                    fastPrev = fast;
                }
                
                fast = fast.next;
            }
             if(slow != min)
                head = swap(slow, slowPrev, min,fastPrev, head);
             slowPrev = slow;
             slow  = slow.next;
        }
        return head;
    }
    
    private static ListNode swap(ListNode n1, ListNode n1Prev, ListNode n2, ListNode n2Prev, ListNode head){
        
         ListNode tmp = n2.next;
         if(n1Prev != null){
            n1Prev.next = n2;
         }else{
            head  = n2;
         }
         n2.next = n1.next;
            
         n2Prev.next = n1;
         n1.next = tmp;
        return head;
    }



 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }
 public static void print(ListNode cur){
		while(cur != null){
			System.out.println("output" + cur.val);
			cur= cur.next;
		}
	}
 public static void main(String arg[]){
	 
	 InsertionSortList obj = new InsertionSortList();
	  ListNode n1 = obj.new ListNode(1);	
		ListNode n2 = obj.new ListNode(6);
		ListNode n3 = obj.new ListNode(5);
		ListNode n4 = obj.new ListNode(7);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode head = obj.insertionSortList(n1);
		
		obj.print(head);
 }

}
