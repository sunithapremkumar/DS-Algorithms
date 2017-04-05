package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
/**
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth
 * For example, given the list {{1,1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) 2*1 + (1 + 1 + 1 + 1) * 2 = 10
 * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
 *
 * @author suni
 *
 */
public class DepthSum {


	int sum = 0;
	public int depthSum(List<NestedInteger> input, int depth){
		
		for(NestedInteger val: input ){
		
			  if(val.isInteger()){
				  System.out.println(" val: " + val.getInteger() + "depth :"+ depth);
				  sum = sum + (val.getInteger() * depth);
				  System.out.println("sum:" + sum);
			  }
			  else{
				  depthSum(val.getList(), depth + 1);
			  }
		}
		return sum;
	}
	
	HashMap<Integer,Integer> map = new HashMap();
	public void depthSumReverse(List<NestedInteger> input, int depth){
		for(NestedInteger val: input ){
		
			  if(val.isInteger()){
				  updateMap(depth, val.getInteger());

			  }
			  else{
				  depthSumReverse(val.getList(), depth + 1);
			  }			  
		}
	}
	
	
	public void reverseSum(List<NestedInteger> input, int depth){
		depthSumReverse(input, depth);
		System.out.println("MAP : "+ map);
		Set<Integer> keys = map.keySet();
		int sum = 0;
		int size = map.size();
		for(int key: keys){
			
			int weigh = size - (key -1);
			sum = sum + (weigh * map.get(key));
		}
		System.out.println(" FINAL SUM:" + sum);
		
	}
	private void updateMap(int depth, int valArg){
		System.out.println("Updating Map" + depth + valArg);
		if(map.containsKey(depth)){
			int val = (Integer)map.get(depth);
			val = val + valArg;
			map.put(depth, val);
		}
		else{
			map.put(depth,  valArg);
		}
	}
	
	public static void main(String args[]){
		
		DepthSum sum = new DepthSum();
	    ArrayList list = new ArrayList();
	    
	    MyInteger list1 =sum.new MyInteger();
	    list1.addInteger(sum.new MyInteger(1));
	    list1.addInteger(sum.new MyInteger(1));	    
	    list.add(list1);

	    list.add(sum.new MyInteger(2));
	    
	    MyInteger list2 = sum.new MyInteger();
	    list2.addInteger(sum.new MyInteger(1));
	    list2.addInteger(sum.new MyInteger(1));
	    list.add(list2);
	    
	   // System.out.println("FINAL: "+sum.depthSum(list, 1));
	    
	    sum.reverseSum(list,1);
	    
	    
	}
	
	
	public class MyInteger implements NestedInteger{
		
		private List data = new ArrayList();
		
		public MyInteger(Integer dataArg){
			
			data.add(dataArg);
		}
		
		public MyInteger(){
	
		}
		
		public void addInteger(NestedInteger i){
			data.add(i);
		}
		
		public boolean isInteger(){
			return (data.size() ==1);
		}
		
		public Integer getInteger(){
			if(data.size() ==1)
				return (Integer)data.get(0);
			else 
				return -1;
			
		}
		
		public List<NestedInteger> getList(){
			return (List<NestedInteger>)data;
		}
	}
	
}
