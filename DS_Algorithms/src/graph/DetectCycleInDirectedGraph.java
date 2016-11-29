package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * https://youtu.be/rKQaZuoUR4M
 * 
 * Given a directed  graph, detec a cycle in this graph.
 *
 * Maintain grey list and black list. 
 * Do DFS by adding the visited node into grey list. Move the vertex which are completely explored from greylist into blacklist.
 * 
 * While exploring if a vertex is already in greylist then there is a cycle.
 * @author suni
 *
 */
public class DetectCycleInDirectedGraph {
	private static Set<Vertex> greyList = new HashSet<>(); //visited nodes. In topology sort, nodes in this set will not be movesd out once comppletely exlored, instead add to stack.
	private static Set<Vertex> blackList = new HashSet<>(); //completely done exploring move to this list. In topology sort we add to stack.
	
    public static boolean detectCycle(Graph graph){
    
      for(Vertex v: graph.getAllVertices()){
         if(blackList.contains(v))
            continue;
         if(exploreNode(v))
        	 return true;
      }
    
     return false;
    }
    //DFS
    private static boolean exploreNode(Vertex v){
        greyList.add(v);
        
        for(Vertex v1 : v.getAdjacentVertexes()){
            if(blackList.contains(v1))
	            continue;
            if(greyList.contains(v1))
            	return true;
            if(exploreNode(v1))
            	return true;
        } 
        moveToList(greyList, blackList,v);  
        return false;
    }

     private static void moveToList(Set<Vertex> source, Set<Vertex> target, Vertex v)
     {
    	 source.remove(v);
    	 target.add(v);
     }
     
     public static void main(String arg[]){
    	 
    		   Graph graph = new Graph(true);
    		   graph.addEdge(4,1);
    		   graph.addEdge(4,5);
    		   graph.addEdge(1,2);
    		   graph.addEdge(5,6);
    		   graph.addEdge(6,4);
    		   
    		   System.out.println(detectCycle(graph));
    		   
     }

}
