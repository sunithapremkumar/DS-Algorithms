package graph;

import java.util.*;

import graph.DepthFirstSearch.Vertex;

public class BreadthFirstSearch {
	 int NUM_VERTICES = 5;
	 Vertex[] vertices = new Vertex[NUM_VERTICES];
	 int[][] adjMatrix = new int[NUM_VERTICES][NUM_VERTICES];
	 int vertexIndex =0;
	
	public void addVertex(char c){
		vertices[vertexIndex++] = new Vertex(c);
	}
	
	public void addEdge(int start, int end){
		adjMatrix[start][end] = 1;
		adjMatrix[end][start] = 1;
	}
	
	public int getAdjacentNonVisitedVertex(int v){
		
		for(int i=0;i<NUM_VERTICES; i++){
			if(adjMatrix[v][i] == 1 && !vertices[i].isVisited())
				return i;
		}
		return -1;
		
	}
	
	public void bfs(){
		
		Queue<Integer> queue = new LinkedList();
		vertices[0].visited = true;
		System.out.println(vertices[0]);
		queue.add(0);
		
		while(!queue.isEmpty()){
			int v;
			while((v = getAdjacentNonVisitedVertex(queue.peek()))!= -1){
				
					vertices[v].visited = true;
					System.out.println(vertices[v].toString());
					queue.add(v);
				
			}
			queue.poll();
		}
		
	}
	
	public static void main(String...strings){
		BreadthFirstSearch bfs = new BreadthFirstSearch();
		bfs.addVertex('A');
		bfs.addVertex('B');
		bfs.addVertex('C');
		bfs.addVertex('D');
		bfs.addVertex('E');
		
		bfs.addEdge(0, 1);
		bfs.addEdge(1, 2);
		bfs.addEdge(0, 3);
		bfs.addEdge(0, 4);

		bfs.bfs(); 
	}
	
	class Vertex{
		char cha;
		boolean visited = false;
		public Vertex(char c){
			cha = c;
		}
		
		public boolean isVisited(){
			return visited;
		}
		public String toString(){
			return cha+"";
		}
	}
}
