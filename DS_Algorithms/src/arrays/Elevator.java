package arrays;
/**
 * There is an elevator in a building with M floors. This elevator can take a max of X people at a time or max of total weight Y. Given that a set of people and their weight and the floor they need to stop, how many stops has the elevator taken to serve all the people? Consider the elevator serves in “first come first serve” basis and the order for the queue can not be changed.

Example:

Let Array A be the weight of each person A = [60, 80, 40].
Let Array B be the floors where each person needs to be dropped off B = [2, 3, 5].

The building has 5 floors, maximum of 2 persons are allowed in the elevator at a time with max weight capacity being 200. For this example, the elevator would take total of 5 stops in floors: 2, 3, G, 5 and finally G.
 */
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