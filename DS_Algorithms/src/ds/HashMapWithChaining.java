package ds;

import java.util.ArrayList;

public class HashMapWithChaining {
	
	  private ArrayList<Node> array = null;
	  
	  public HashMapWithChaining(int size){
		  array = new ArrayList<>(size);
		  for(int i=0; i< size; i++)
			  array.add(null);
	  }
	  public String get(String key){
		  Node n = getNodeForKey(key);
		  
		  if(n != null)
			  return n.value;
		  
		  return null;			  
	  }
	  
	  public void put(String key, String value){
		  Node n = getNodeForKey(key);

		  Node newNode = new Node(key, value);		  
		  if(n == null){
			  int index = getIndexForKey(key);
			  if(array.get(index) != null){
				  Node head = array.get(index);
				  newNode.next = head;
				  head.prev = newNode;
			  }
			  array.set(index,  newNode);

		  }else{
			  
			 n.value = value;
		  }
	  }

	  public void remove(String key){
		  Node n = getNodeForKey(key);
		  if(n == null)
			  return;
		  
		  if(n.prev != null)
			  n.prev.next = n.next;
		  else
			  array.set(getIndexForKey(key), n.next);  //updating head in array
		  if(n.next != null)
			  n.next.prev = n.prev;
		  
	  }
	  
	  private Node getNodeForKey(String key){
		  int index = getIndexForKey(key);
		  Node cur = array.get(index);
		  
		  while(cur != null){
			  if(cur.key.equals(key))
				  return cur;
			  cur = cur.next;
		  }
		  return null;
	  }
	  
	  private int getIndexForKey(String key){
		  int index = key.hashCode() % array.size();
		  return index;
	  }
}
