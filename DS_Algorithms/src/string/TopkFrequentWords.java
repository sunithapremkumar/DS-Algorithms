package string;

import java.util.HashMap;
import java.util.*;
/**
 * http://www.programcreek.com/2013/03/java-sort-map-by-value/
 * Find the top k most frequent words in a sentence
 * 
 * this program not fully working 
 * 
 * ALGO - just create map with count and sort the map by value
 * @author suni
 *
 */
public class TopkFrequentWords {
	
	public void countWords(String[] arr){
		
		//Counting the frequency
		HashMap<String, Integer> map = new HashMap<>();
		for(String s: arr){
			map.put(s, map.getOrDefault(s, 0)+1);
		}
		
		//sorting map based on values
		
		ValueComparator<String, Integer> comparator = new ValueComparator<>(map);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(comparator);
	    sortedMap.putAll(map);
	    
	    //print
	    Set<String> keySet = sortedMap.keySet();
	    for(String s: keySet)
	    	System.out.println(s + " " + sortedMap.get(s));
	}
	
	public class ValueComparator<K,V> implements Comparator<K>{
		
		HashMap<K, V> map = new HashMap<>();
		
		public ValueComparator(HashMap<K,V> map){
			this.map = map;
		}

		@Override
		public int compare(K o1, K o2) {
			 Comparable v1 = (Comparable)map.get(o1);
			 Comparable v2 = (Comparable)map.get(o2);
			 
			return v2.compareTo(v1);
		}
		
		
	}
	
	public static void main(String arg[]){
			String s = "Welcome to the world of Geeks. This portal has been created to provide well written well thought and well explained solutions for selected questions If you like Geeks for Geeks and would like to contribute here is your chance You can write article and mail your article to contribute at geeksforgeeks org See your article appearing on the Geeks for Geeks main page and help thousands of other Geeks";
            String[] arr = s.split(" ");
            TopkFrequentWords obj = new TopkFrequentWords();
            obj.countWords(arr);
	}

}
