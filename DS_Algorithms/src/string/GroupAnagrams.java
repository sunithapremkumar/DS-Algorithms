package string;

import java.util.*;
import java.util.Comparator;

public class GroupAnagrams {

	 //Method 1
	public void sort(String[] strArr){
		
		Arrays.sort(strArr, new AnagramComparator());
		for(String s:strArr)
			System.out.println(s);
	}
	
	public class AnagramComparator implements Comparator<String>{

		public int compare(String s1, String s2) {
			
			char[] a =s1.toCharArray();
			char[] b = s2.toCharArray();
			Arrays.sort(a); Arrays.sort(b);
			String sortedS1 = new String(a);
			String sortedS2 = new String(b);
			return sortedS1.compareTo(sortedS2);
		}
		
		
	}
	
	//Method 2
	public void sort2(String[] strArr){
		HashMap<String, List> map = new HashMap<>();
		for(String s:strArr){
			char[] cArr = s.toCharArray();
			Arrays.sort(cArr);
			String sortedS = new String(cArr);
			if(map.containsKey(sortedS)){
				List<String> list = map.get(sortedS);
				list.add(s);
			}
			else{
				List<String> list = new ArrayList<>();
				list.add(s);
				map.put(sortedS, list);
			}
		}
		//print the map as they are grouped now
		Set<String> set= map.keySet();
		for(String s: set){
			List<String> list = map.get(s);
			for(String str : list)
				System.out.println(str);
		}
	}
	
	
	public static void main(String arg[]){
		String[] strArr= {"CAT", "MAP", "DOG", "TAC", "PAM", "FOG", "GOD"};
		
		//new GroupAnagrams().sort(strArr);
		
		
		new GroupAnagrams().sort2(strArr);
	}
}
