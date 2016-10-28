package graph;

import java.util.Stack;

public class DepthFirstSearch {
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
	
	public void dfs(){
		
		Stack<Integer> st = new Stack<Integer>();
		vertices[0].visited = true;
		System.out.println(vertices[0]);
		st.push(0);
		
		while(!st.isEmpty()){
			
			int v = getAdjacentNonVisitedVertex(st.peek());
			if(v == -1){
				st.pop();
			}
			else{
				
				vertices[v].visited = true;
				System.out.println(vertices[v].toString());
				st.push(v);
			}
		}
		
	}
	
	public static void main(String...strings){
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.addVertex('A');
		dfs.addVertex('B');
		dfs.addVertex('C');
		dfs.addVertex('D');
		dfs.addVertex('E');
		
		dfs.addEdge(0, 1);
		dfs.addEdge(1, 2);
		dfs.addEdge(0, 3);
		dfs.addEdge(0, 4);

		dfs.dfs(); 
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
