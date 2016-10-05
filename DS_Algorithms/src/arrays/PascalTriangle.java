package arrays;

import java.util.*;

public class PascalTriangle {
    
    List <List<Integer>> finalList = new ArrayList<List<Integer>>();
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0)
          return finalList;
        
          ArrayList<Integer> l1 = new ArrayList<Integer>();
          l1.add(1);
          finalList.add(l1);
          if(numRows == 1)
            return finalList;
          ArrayList<Integer> l2 = new ArrayList<Integer>();
          l2.add(1); l2.add(1);
          finalList.add(l2);
          if(numRows == 2)
            return finalList;
            
            ArrayList<Integer> list, previousList = l2;
            for(int i= 3; i <= numRows; i++){
                list = new ArrayList<Integer>();
                list.add(1);
                for(int j= 1; j < (i-1); j++){
                    int ans = previousList.get(j) + previousList.get( j-1);
                    list.add(ans);                    
                }
                list.add(1);
                previousList = list;
                finalList.add(list);
                
            }
            
            return finalList;
        }
        
    public static void main(String...strings ){
    	
    	int numRows = 5;
    	
    	List list = new PascalTriangle().generate(numRows);
    	
    	for(int i=0; i < list.size(); i++){
    		List l = (List<Integer>)list.get(i);
    		for(int j=0; j< l.size(); j++){
    			System.out.println(l.get(j));
    		}
    		System.out.println("\n");
    	}
    }
        
        
    }
