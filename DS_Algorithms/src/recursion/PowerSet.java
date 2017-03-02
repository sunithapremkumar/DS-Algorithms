package recursion;

import java.util.ArrayList;

/**
 * Write a method to return all subset of a set
 * Exampl  - {1,2,3} returns {}, {1},{2},{1,2},{3}, {1,3}, {2,3},{1,2,3} 
 * @author suni
 *
 * Algo Base case and build approach
 *  {}  = {}
 *  {1} = {}, {1}   //previous list plus adding 1 to the previous list
 *  {1,2} = {}, {1}, {2} {1,2} //previous list plus adding digit 2 to the previous list.
 *  {1,2,3}={}, {1}, {2} {1,2}, {3}, {1,3},{2,3},{1,2,3} /previous list plus adding digit 3 to the previous list.
 */
public class PowerSet {

	//Using resultlist as a argument
	public void findSubset1(int[] arr, int size, ArrayList<String> resultList){
		
		if(size ==0)
		{
			resultList.add("");
			return;
		}
		
		findSubset1(arr, size-1, resultList);
		addToList(arr[size-1], resultList);
	}
	//Using result list in return
  public ArrayList<String> findSubset(int[] arr, int size){
		
		if(size ==0)
		{
			ArrayList<String> resultList = new ArrayList<>();
			resultList.add("");
			return resultList;
		}
		
		ArrayList<String> al = findSubset(arr, size-1);
		addToList(arr[size-1], al);
		return al;
	}
	private void addToList(int data, ArrayList<String> list){
		
		ArrayList<String> newList = new ArrayList<>();
		
		for(String s: list){
			String s1 = s+data;
			newList.add(s1);
		}
		list.addAll(newList);
	}
	
	public static void main(String arg[]){
		PowerSet obj = new PowerSet();
		int[] arr= {1,2,3};
		ArrayList<String> al = new ArrayList<>();
		//obj.findSubset(arr, arr.length, al);
		al = obj.findSubset(arr, arr.length);
		for(String s: al)
			System.out.println(s);
	}
	
}
