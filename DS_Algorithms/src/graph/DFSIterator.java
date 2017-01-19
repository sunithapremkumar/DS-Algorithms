package graph;
 
import java.util.Stack;


public class DFSIterator {
	
	
	Graphs graph;
	Stack<Integer> stack = new Stack<>();
	
    public DFSIterator(Graphs graph){
    	this.graph = graph;
    	Vertex vertice = graph.getVertexAt(0);
    	if(vertice != null)
    	  stack.push(0);
    }

    public boolean hasNext(){
    	return (!stack.isEmpty());
    }
	
    public Vertex next(){
    	
    	if(!hasNext())
    		return null;

    	Vertex currentVertex = graph.getVertexAt(stack.peek());
    	currentVertex.visited = true;

    	int adjVertex = graph.getAdjacentNonVisitedVertex(stack.peek());
    	while(adjVertex == -1 && !stack.isEmpty())
    	{
    		stack.pop();
    		if(!stack.isEmpty())
    		 adjVertex = graph.getAdjacentNonVisitedVertex(stack.peek());
    		
    	}
    	if(adjVertex != -1)
    		stack.push(adjVertex);
    	
    	return currentVertex;
    }

	public static void main(String...strings){
		Graphs dfs = new Graphs(5);
		dfs.addVertex('A');
		dfs.addVertex('B');
		dfs.addVertex('C');
		dfs.addVertex('D');
		dfs.addVertex('E');
		
		dfs.addEdge(0, 1);
		dfs.addEdge(1, 2);
		dfs.addEdge(0, 3);
		dfs.addEdge(0, 4);

		DFSIterator iterator = new DFSIterator(dfs);
		while(iterator.hasNext())
			System.out.println(iterator.next().cha);
	}
	
	static class Graphs{
		 int NUM_VERTICES = 0;;
		 Vertex[] vertices;
		 int[][] adjMatrix;
		 int vertexIndex =0;
		 
		public Graphs(int numVertices){
			NUM_VERTICES = numVertices;
			vertices = new Vertex[NUM_VERTICES];
			adjMatrix = new int[NUM_VERTICES][NUM_VERTICES];
		}
		public void addVertex(char c){
			vertices[vertexIndex++] = new Vertex(c);
		}
		
		public void addEdge(int start, int end){
			adjMatrix[start][end] = 1;
			adjMatrix[end][start] = 1;
		}
		public Vertex getVertexAt(int index){
			return vertices[index];
		}
		public int getAdjacentNonVisitedVertex(int v){
			
			for(int i=0;i<NUM_VERTICES; i++){
				if(adjMatrix[v][i] == 1 && !vertices[i].isVisited())
					return i;
			}
			return -1;
			
		}
	}
	
	static class Vertex{
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
