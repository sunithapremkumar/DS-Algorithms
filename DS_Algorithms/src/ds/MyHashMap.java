package ds;
//linear probing
public class MyHashMap {

	  HashEntry[] entries;
	  int SIZE = 128;
	  
	  public MyHashMap(int size){
		  entries = new HashEntry[SIZE];
	  }
	
	  public int get(int key){
		  
		  int hash = key%SIZE;
		  
		  while(entries[hash] != null && entries[hash].key != key){
			  hash = (hash+1)%SIZE;
		  }
		  
		  if(entries[hash] == null)
			  return -1;
		  
		  return entries[hash].value;
	  }
	
	  public void put(int key, int val){
		  int hash = key%SIZE;
		  while(entries[hash] != null && entries[hash].key != key){
			  hash = (hash+1)%SIZE;
		  }
		  
		  entries[hash] = new HashEntry(key, val);
	  }
	  
	  
	public class HashEntry{
		int key;
		int value;
		
		public HashEntry(int k, int v){
			key = k;
			value = v;
		}
	}
}
