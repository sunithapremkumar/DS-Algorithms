package graph;

import java.util.*;
/**
 * https://youtu.be/oP2-8ysT3QQ
 * 
 * Algorithm:  
 * 1. Maintain 3 data structure 
 *     1. BinaryHeap - to store the vertices ordered by weight ascending
 *     2. Vertex to Edge Map - to store the preferred path to this vertex
 *     3. resultList - to store the resultant edges .
 *     
 * 2. Extract the min from heap and update the resultList map
 * 3. Explore all adjacent vertices and update the heap with the minimum weight edge and also update the vertexToEdge map
 * 4. Do step 2 and 3 until heap is empty
 * 5. Return the resultList which contains the MST  
 *     
 * @author suni
 *
 */
public class PrimsMinimumSpanningTree {

	public static List<Edge> primsMST(Graph graph) {

		BinaryMinHeapMap<Vertex> binaryHeapMap = new BinaryMinHeapMap<>();
		Map<Vertex, Edge> vertexToEdge = new HashMap<>();
		List<Edge> resultList = new ArrayList<>();

		for (Vertex v : graph.getAllVertices()) {
			binaryHeapMap.add(Integer.MAX_VALUE, v);
		}

		Vertex startVertex = graph.getAllVertices().iterator().next();
		binaryHeapMap.decrease(startVertex, 0);
		
		while(!binaryHeapMap.empty()){
		  
			Vertex currentVertex = binaryHeapMap.extractMin();
			
			Edge edge = vertexToEdge.get(currentVertex);
			
			if(edge != null)
				resultList.add(edge);
			
			for(Edge e: currentVertex.getEdges()){
				
				Vertex v = getVertexForEdge(currentVertex, e);
				if(binaryHeapMap.containsData(v) && binaryHeapMap.getWeight(v) > e.weight){
					binaryHeapMap.decrease(v, e.weight);
					vertexToEdge.put(v,e);
				}
				
			}
			
		}
		return resultList;
	}

	 private static Vertex getVertexForEdge(Vertex v, Edge e){
	        return e.vertex1.equals(v) ? e.vertex2 : e.vertex1;
	    }
	 
	 public static void main(String... arg){
		 Graph graph = new Graph();

	        graph.addEdge(1, 2, 3);
	        graph.addEdge(2, 3, 1);
	        graph.addEdge(3, 1, 1);
	        graph.addEdge(1, 4, 1);
	        graph.addEdge(2, 4, 3);
	        graph.addEdge(4, 5, 6);
	        graph.addEdge(5, 6, 2);
	        graph.addEdge(3, 5, 5);
	        graph.addEdge(3, 6, 4);

	        Collection<Edge> edges = primsMST(graph);
	        for(Edge edge : edges){
	            System.out.println(edge);
	        }
	 }
}
