package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
class Elevator {
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        
        int totCount =0, totWeight = 0, noOfStops = 0, personIndex =0;
        HashMap<Integer, Integer> stops = new HashMap();
        if(A.length == 0 || B.length == 0)
          return 0;
       while(personIndex < A.length){
          
          totCount++;
          totWeight += A[personIndex];
          updateMap(B[personIndex], stops, true);
          
          if((totCount > X) || (totWeight > Y)){
             
             totCount = 0;
             totWeight = 0;
             updateMap(B[personIndex], stops, false);
             noOfStops += stops.size() +1;
             stops.clear();
             continue;            
          }
          else if ((totCount == X) || (totWeight == Y)){
              
             totCount = 0;
             totWeight =0;
             noOfStops += stops.size() +1;
             stops.clear();
          }
          personIndex++;
       }
       if(stops.size() >0)
    	   noOfStops += stops.size()+1;
       return noOfStops;  
}
        
    
    private void updateMap(int val, Map<Integer, Integer> stops, boolean inc){
    	if(stops.containsKey(val)){
    		int cnt = stops.get(val);
    		if(inc)
    			stops.put(val,++cnt);
    		else{
    			if(cnt == 1) 
    				stops.remove(val);
    			else
    			   stops.put(val,--cnt);
    		}

    	}
    	else
    		stops.put(val, 1);
    }
    
 public static void main(String...strings){
	 
	 int[] A = {40, 40, 100, 80, 20};
	 int[] B = {3,3,2,2,3};
	 
	 System.out.println(new Elevator().solution(A, B, 3, 5, 200));
 }
}