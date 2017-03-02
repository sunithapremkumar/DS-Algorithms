package ds;

import java.util.*;

public class AllOne {


	 private HashMap<String, Node> map;
	 private PriorityQueue<Node> minHeap;
	 private PriorityQueue<Node> maxHeap;
	 
	    /** Initialize your data structure here. */
	    public AllOne() {
	        map = new HashMap<>();
	        minHeap = new PriorityQueue<>(10, new Comparator<Node>(){
	            
	            public int compare(Node n1, Node n2){
	                return (n1.val - n2.val);
	            }
	            
	        });
	        
	         maxHeap = new PriorityQueue<>(10, new Comparator<Node>(){
	            
	            public int compare(Node n1, Node n2){
	                return (n2.val - n1.val);
	            }
	            
	        });
	    }
	    
	    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
	    public void inc(String key) {
	        if(map.containsKey(key)){
	            Node n = map.get(key);
	            n.val = n.val +1;
	            //updating a object does not reorder the queue. Only add/remove methods will re-order the queue.
	            updateQueueOrdering(n);
	        }
	        else{
	            insertNewKey(key);
	        }
	    }
	    
	    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
	    public void dec(String key) {
	        if(map.containsKey(key)){
	            Node n = map.get(key);
	            if(n.val == 1){
	                removeKey(n);
	            }
	            else{
	               n.val = n.val - 1;
	            //updating a object does not reorder the queue. Only add/remove methods will re-order the queue.
	               updateQueueOrdering(n);
	            }
	        }
	        
	    }
	    
	    private void updateQueueOrdering(Node n){
	    	minHeap.remove(n);
            maxHeap.remove(n);
            minHeap.add(n);
            maxHeap.add(n);
	    }
	    private void insertNewKey(String key){
	            Node n = new Node(key, 1);
	            map.put(key, n);
	            minHeap.add(n);
	            maxHeap.add(n);
	    }
	    
	    private void removeKey(Node n){
	        map.remove(n.key);
	        minHeap.remove(n);
	        maxHeap.remove(n);
	    }
	    /** Returns one of the keys with maximal value. */
	    public String getMaxKey() {
	        Node n = maxHeap.peek();
	        if(n != null)
	           return n.key;
	         return "";  
	    }
	    
	    /** Returns one of the keys with Minimal value. */
	    public String getMinKey() {
	        Node n = minHeap.peek();
	        if(n != null)
	           return n.key;
	         return ""; 
	    }
	    
	    public class Node{
	        String key;
	        int val;
	        
	        public Node(String k, int v){
	            key = k;
	            val = v;
	        }
	        public String toString(){
	        	return "Key="+key + " val=" + val;
	        }
	    }
	

public static void main(String arg[]){
	 AllOne obj = new AllOne();
	 obj.inc("a");
	 obj.inc("b");
	 obj.inc("b");
	 obj.inc("c");
	 
	 obj.inc("c");
	 obj.inc("c");
	 obj.dec("b");
	 obj.dec("b");
	 System.out.println("Min "+obj.getMinKey());
	 obj.dec("a");
	 
	 System.out.println("Max "+obj.getMaxKey());
	 System.out.println("Min "+obj.getMinKey());
}
}