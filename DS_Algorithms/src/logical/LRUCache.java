package logical;

import java.util.*;

public class LRUCache {

	private HashMap<Integer, Node> map = new HashMap<>();
	private Node head = null, tail = null;
	private int cacheSize;
	
	public LRUCache(int capacity){
		cacheSize = capacity;
	}
	
	public void add(int key, int value){
		removeKey(key);
		Node n = new Node(key, value);
		addToHead(n);
		map.put(key, n);
		if(map.size() > cacheSize){
			removeKey(tail.key);
		}
	
	}
	
	
	public int get(int key){
		
		if(map.containsKey(key)){
			Node value = map.get(key);
			if(value != head){
				removeFromLinkedList(value);
				addToHead(value);
			}
			return value.value;
			
		}else
			return -1;				
	}
	
	private void removeKey(int key){
		if(map.containsKey(key)){
			Node n = map.remove(key);
			removeFromLinkedList(n);
		}
		
	}


	private void removeFromLinkedList(Node n){
		if(n == null)
			return;
		if(n.prev != null)
			n.prev.next = n.next;
		if(n.next != null)
			 n.next.prev = n.prev;
		if(head == n)
			head = n.next;
		if(tail == n)
			tail = n.prev;		
	}
	
	private void addToHead(Node n){
	  	if(n == null)
	  		return;
	  	if(head == null)
	  		head = tail = n;
	  	else{
	  		head.prev = n;
	  		n.next = head;
	  		head = n;
	  	}
	}
	
	public class Node{
		
		public int key;
		public int value;
		public Node prev = null, next = null;
		
		public Node(int k, int v){
			key=k;
			value=v;
		}
		
	}
}
