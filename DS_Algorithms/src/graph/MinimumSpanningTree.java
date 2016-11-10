package graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

import graph.Graph.*;

/**
 * https://youtu.be/fAuF0EuZVCk
 * @author prasunit
 *
 *  MST is the tree with the minimum number of edges required. Can also be defined as tree with edges whose weights totals to minimum.
 *  Kruskal Algorithm
 *   1. Sort the edges by weight (ascending)
 *   2. Take each edge and see of it forms a cycle, if not add to the resultset else ignore. 
 */
public class MinimumSpanningTree {

   	 
	
	public static List<Edge> getMST(Graph graph){
		List<Edge> resultEdges = new ArrayList<>();
		List<Edge> edges = graph.getAllEdges();
		//Sort by edges weight
		Collections.sort(edges, new Comparator<Edge>(){
			public int compare(Edge e1, Edge e2){
				return e1.weight-e2.weight;
			}
		});
		
		
		DisjointSet disjointSet = new DisjointSet();
		for(Vertex v: graph.getAllVertices()){
			disjointSet.makeSet(v.id);
		}
		
		//walk thru each edge and see if the vertices are from same subset/forms cycle, if so ignore, 
		//else add to result set and merge
		for(Edge edge:edges){
			Vertex vertex1 = edge.vertex1;
			Vertex vertex2 = edge.vertex2;
			long vertex1Root = disjointSet.findSet(vertex1.id);
			long vertex2Root = disjointSet.findSet(vertex2.id);
			
			if(vertex1Root == vertex2Root)
				continue;
			
			resultEdges.add(edge);
			disjointSet.union(vertex1.id, vertex2.id);
		}
		
		return resultEdges;
	}
	
	public static void main(String...strings){
		Graph graph = new Graph();
		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 4);
		
		List<Edge> resultEdges = getMST(graph);
		for(Edge e: resultEdges){
			System.out.println(e.vertex1.id + "--" + e.vertex2.id + "=" + e.weight);
		}
		
		
	}
}
