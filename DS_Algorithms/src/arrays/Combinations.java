package arrays;

import java.util.*;
/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author suni
 *
 */
public class Combinations {
	 public List<List<Integer>> combine(int n, int k) {
	        
	        
	        List<List<Integer>> myList = getCombinations(n, k);
	        List<List<Integer>> newList= new ArrayList<>();
	        
	        for(List<Integer> cur: myList){
	            if(cur.size() == k){
	                newList.add(cur);
	            }
	        }
	        return newList;
	    }
	    
	    public List<List<Integer>> getCombinations(int n, int k){
	        if(n == 1)
	        {
	            //List<List<Integer>> l = new ArrayList<>();
	            List<Integer> innerList = new ArrayList<>();
	            innerList.add(1); 
	            //l.add(innerList);
	            //return l;
	            return new ArrayList(Arrays.asList(innerList));
	        }
	        
	        List<List<Integer>> mList = getCombinations(n-1, k);
	        return updateList(mList, n, k);
	    }
	    
	    private List<List<Integer>> updateList(List<List<Integer>> list, int n, int k){
	        List<List<Integer>> newList = new ArrayList<>();
	        newList.addAll(list);
	        //add itself
	        List<Integer> l = new ArrayList<>(); l.add(n);
	        newList.add(l);
	        
	        for(List<Integer> q: list){
	            if(q.size() <k){
	                List<Integer> nn = new ArrayList<>(q);
	                nn.add(n);
	                newList.add(nn);
	            }
	        }
	     
	     return newList;   
	    }
	    
	    public static void main(String[] arg){
	    	
	    	List<List<Integer>> list = new Combinations().combine(4,2);
	    	
	    	for(List<Integer> l: list){
	    		
	    		for(int i: l)
	    			System.out.print(i);
	    	System.out.println("");
	    	}
	    	
	    }
}
