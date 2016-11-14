package graph;


import java.util.HashMap;
import java.util.Map;

/**
 * https://youtu.be/lAXZGERcDf4
 * 
 * Algorithm:  (Same as Prims algorithm with difference that heap stores the total distance to that vertex 
 * instead of the edge leading to that vertex in case of prims and vertexToParent DS instead of VertexToEdge (both serves the same purpose)
 * and VertexToDistance map an extra DS to calculate the total distance here)
 * 1. Maintain 3 data structure 
 *     1. BinaryHeap - to store the vertices ordered by weight ascending
 *     2. Vertex to parent Map - to store the preferred path to this vertex
 *     3. VertextoDistance map - to store the mininum distance to each vertex.
 *     
 * 2. Extract the min from heap and update the vertexToDistanc map
 * 3. Explore all adjacent vertices and update the heap with the minimum weight edge and also update the vertexToParent map
 * 4. Do step 2 and 3 until heap is empty
 * 5. Return the vertexToParent map which contains the shortest path  
 *     
 * @author suni
 *
 */
public class DijiktrasShortestPath {
	public static Map<Vertex, Vertex> shortestPath(Graph graph, Vertex source) {

		BinaryMinHeapMap<Vertex> binaryHeapMap = new BinaryMinHeapMap<>();
		Map<Vertex, Vertex> vertexToParent = new HashMap<>();
		Map<Vertex, Integer> vertexToDistance = new HashMap<>();

		for (Vertex v : graph.getAllVertices()) {
			binaryHeapMap.add(Integer.MAX_VALUE, v);
		}

		binaryHeapMap.decrease(source, 0);
		vertexToParent.put(source,null);
		while(!binaryHeapMap.empty()){
		  
			BinaryMinHeapMap<Vertex>.Node heapNode = binaryHeapMap.extractMinNode();
			Vertex currentVertex = heapNode.key;
			
			//Update the vertexToDistance map as and when we extract Min. This map is used to get the total distance whenever we update the binaryHeapMap
			vertexToDistance.put(currentVertex, heapNode.weight);
			
			
			for(Edge e: currentVertex.getEdges()){
				
				Vertex v = getVertexForEdge(currentVertex, e);
				int totalDistance = (vertexToDistance.containsKey(currentVertex))?(vertexToDistance.get(currentVertex) + e.weight) : e.weight;

				if(binaryHeapMap.containsData(v) && binaryHeapMap.getWeight(v) > totalDistance){
					binaryHeapMap.decrease(v, totalDistance);
					vertexToParent.put(v,currentVertex);
				}
				
			}
			
		}
		return vertexToParent;
	}

	 private static Vertex getVertexForEdge(Vertex v, Edge e){
	        return e.vertex1.equals(v) ? e.vertex2 : e.vertex1;
	    }
	 public static void main(String... arg){
		 Graph graph = new Graph();


	        graph.addEdge(1, 2, 5);
	        graph.addEdge(2, 3, 2);
	        graph.addEdge(3, 4, 3);
	        graph.addEdge(1, 5, 2);
	        graph.addEdge(5, 6, 3);
	        graph.addEdge(1, 4, 9);
	        graph.addEdge(6, 4, 2);
   
	        Map<Vertex, Vertex> vertexToParent = shortestPath(graph, graph.getVertex(1));
	        System.out.println(vertexToParent);

	 }
}
