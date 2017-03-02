package binarysearchtree;

import java.util.ArrayList;

/**
 * You are given a array like dat structure Listy which lacks the size method. However elementAt() method returns -1 if it
 * is beyond the bound. This contains only positive integers. Given a Listy which contains sorted positive integers, 
 * find the index at which element x occurs
 * @author suni
 *
 */
public class ListNoSize {
	
	/**
	 * How about increasing the size exponentially like 2, 4, 8, 16 ...and see if it is end of list..
	 * Time complezity is O(log n) for finding size and anothjer O(log n) for finding element in binary search. 
	 * So O(2log n) which is equal to O(log n)
	 */
	
	public int search(Listy list, int x){
		
		int index = 1;
		while(index != -1 && x > list.elementAt(index))
			index = index * 2;
		
		return binarySearch(list, index/2, index, x);
	}
	
	
	private int binarySearch(Listy list, int start, int end, int x){
		
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		int midElement = list.elementAt(mid);
		if(midElement == x)
			return mid;
		else if(x < midElement || midElement == -1)
			return binarySearch(list, start, mid-1, x);
		else
			return binarySearch(list, mid+1, end, x);
	}
	
	
	public class Listy {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		public void add(int x){
			list.add(x);
		}
		public int elementAt(int index){
			if(index < list.size())
				return list.get(index);
			return -1;
		}
	}
	
	public static void main(String arg[]){
		ListNoSize obj = new ListNoSize();
		ListNoSize.Listy list = obj.new Listy();
		list.add(3);
		list.add(5);
		list.add(10);
		list.add(30);
		
		System.out.println(obj.search(list, 10));
		
	}

}
