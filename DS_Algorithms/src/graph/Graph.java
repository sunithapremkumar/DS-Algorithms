package graph;

import java.util.*;

public class Graph {
	private List<Edge> edges = new ArrayList<>();
	private Map<Long, Vertex> vertexMap = new HashMap<>();
	
	public List<Edge> getAllEdges(){
		return edges;
	}
	
	public Collection<Vertex> getAllVertices(){
		return vertexMap.values();
	}
	public void addVertex(Vertex v){
		Vertex v1 = vertexMap.get(v.id);
		if(v1 == null)
			vertexMap.put(v.id, v);
	}
	
	public void addEdge(long v1, long v2, int weight){
		Vertex vertex1 = null;
		if(vertexMap.containsKey(v1))
			vertex1 = vertexMap.get(v1);
		else{
		   vertex1 = new Vertex(v1);
			vertexMap.put(vertex1.id, vertex1);
		}
		Vertex vertex2 = null;
		if(vertexMap.containsKey(v2))
			vertex2 = vertexMap.get(v2);
		else{
		   vertex2 = new Vertex(v2);
			vertexMap.put(vertex2.id, vertex2);
		}
		
		Edge edge = new Edge(vertex1, vertex2, weight);
		edges.add(edge);
	}
	
	class Edge{
		Vertex vertex1;
		Vertex vertex2;
		int weight;
		boolean isDirected = false;
	
		public Edge(Vertex v1, Vertex v2, int wei){
			vertex1 = v1;
			vertex2 = v2;
			weight = wei;
		}
	}
	
	class Vertex{
		long id;
		long data;
		List<Edge> edges;
		
		Vertex(long id){
			this.id = id;
		}
	}

}
