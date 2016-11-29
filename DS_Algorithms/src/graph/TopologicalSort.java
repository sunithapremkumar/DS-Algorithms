package graph;

import java.util.*;
/**
 * https://youtu.be/ddTC4Zovtbc
 * 
 * Given a directed  graph, do a topological sort on this graph.
 *
 * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
 *
 * Space and time complexity is O(n).
 * @author suni
 *
 */
public class TopologicalSort {
  
	private static Set visited = new HashSet();
	private static Stack stack = new Stack();
	
    public static Stack sort(Graph graph){
    
      for(Vertex v: graph.getAllVertices()){
         if(visited.contains(v))
            continue;
         exploreNode(v);
      }
    
     return stack;
    }
    //DFS
    private static void exploreNode(Vertex v){
        visited.add(v);
        
        for(Vertex v1 : v.getAdjacentVertexes()){
            if(visited.contains(v1))
	            continue;
            exploreNode(v1);
        } 
        stack.push(v);  
    
    }

public static void main(String arg[]){

   Graph graph = new Graph(true);
   graph.addEdge(1,3);
   graph.addEdge(1,2);
   graph.addEdge(3,4);
   graph.addEdge(5,6);
   graph.addEdge(6,3);
   graph.addEdge(3,8);
   graph.addEdge(8,11);
   
   Stack st = sort(graph);
   
   while(!st.isEmpty()){
      System.out.println(st.pop());
   
   }	   
}

}

