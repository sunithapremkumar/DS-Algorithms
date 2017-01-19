package graph;

import java.util.LinkedList;

public class RouteBetweenNodes {
public boolean isRoute(Graph graph, Vertex v1, Vertex v2){
		
		LinkedList<Vertex> queue = new LinkedList<>();
		queue.add(v1);
		v1.setVisited(true);
		
		while(!queue.isEmpty()){
			
			Vertex ver = queue.poll();
			for(Vertex v : ver.getAdjacentVertexes()){
				
				if(!v.isVisited())
				{
					if(v.equals(v2))
						return true;
					else{
						v.setVisited(true);
						queue.add(v);
					}
				}
			}
		}
		return false;
		
	}
	
	public static void main(String arg[]){
		System.out.println("suni");
		RouteBetweenNodes obj = new RouteBetweenNodes();
		Graph graph = new Graph(true);
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 4, 15);
		graph.addEdge(2, 5, 4);
		graph.addEdge(6, 7,1);
		Vertex v1 = graph.getVertex(0);
		Vertex v2 = graph.getVertex(4);
		boolean result = obj.isRoute(graph, v1, v2);
		System.out.println(result);
		Vertex v3 = graph.getVertex(6);
		boolean result1= obj.isRoute(graph, v1, v3);
		System.out.println(result1);
}
}
