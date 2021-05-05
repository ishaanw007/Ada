package BackTracking;

import java.util.Arrays;

import Greedy.Edge;
import Greedy.Graph;

public class Hamiltonian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(5,14);
		graph.addEdge(new Edge(0,1,1));
		graph.addEdge(new Edge(0,3,1));
		graph.addEdge(new Edge(1,0,1));
		graph.addEdge(new Edge(1,2,1));
		graph.addEdge(new Edge(1,3,1));
		graph.addEdge(new Edge(1,4,1));
		graph.addEdge(new Edge(2,1,1));
		graph.addEdge(new Edge(2,4,1));
		graph.addEdge(new Edge(3,0,1));
		graph.addEdge(new Edge(3,1,1));
		graph.addEdge(new Edge(3,4,1));
		graph.addEdge(new Edge(4,1,1));
		graph.addEdge(new Edge(4,2,1));
		graph.addEdge(new Edge(4,3,1));
		
		Integer[][] adjancencyMatrix = graph.getAdjancencyMatrix();
		
		for(Integer i = 0 ;i < adjancencyMatrix.length;i++) {
			for(Integer j = 0;j < adjancencyMatrix.length;j++) {
				System.out.print(adjancencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
		hamiltonianCycle(graph.getAdjancencyMatrix(), 1);
	}
	public static Boolean hamiltonianCycle(Integer[][] graph, Integer start) {
		Integer[] path = new Integer[graph.length];
		Arrays.fill(path, -1);
		
		/* Let us put vertex 0 as the first vertex in the path.
        If there is a Hamiltonian Cycle, then the path can be
        started from any point of the cycle as the graph is
        undirected */
		
		path[0] = start;
		
		if (hamiltonianCycleUtility(graph, path, 1) == false)
        {
            System.out.println("\nSolution does not exist");
            return false;
        }
		printSolution(path);
		return true;
		
	}
	public static Boolean hamiltonianCycleUtility(Integer[][] graph, Integer[] path, Integer position) {
		if (position == graph.length)
        {
            // And if there is an edge from the last included
            // vertex to the first vertex
            if (graph[path[position - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }
		// Try different vertices as a next candidate in
        // Hamiltonian Cycle. We don't try for 0 as we
        // included 0 as starting point in hamCycle()
        for (int v = 0; v < graph.length; v++)
        {
            /* Check if this vertex can be added to Hamiltonian
               Cycle */
            if (isSafe(v, graph, path, position))
            {
                path[position] = v;
  
                /* recur to construct rest of the path */
                if (hamiltonianCycleUtility(graph, path, position + 1) == true)
                    return true;
  
                /* If adding vertex v doesn't lead to a solution,
                   then remove it */
                path[position] = -1;
            }
        }
  
        /* If no vertex can be added to Hamiltonian Cycle
           constructed so far, then return false */
        return false;
	}
	/* A utility function to check if the vertex v can be
    added at index 'pos'in the Hamiltonian Cycle
    constructed so far (stored in 'path[]') */
	 public static Boolean isSafe(Integer v, Integer graph[][], Integer path[], Integer pos)
	 {
	     /* Check if this vertex is an adjacent vertex of
	        the previously added vertex. */
	     if (graph[path[pos - 1]][v] == 0)
	         return false;
	
	     /* Check if the vertex has already been included.
	        This step can be optimized by creating an array
	        of size V */
	     for (int i = 0; i < pos; i++)
	         if (path[i] == v)
	             return false;
	
	     return true;
	 }
	public static void printSolution(Integer path[])
	{
		System.out.println("Solution Exists: Following" +
	                           " is one Hamiltonian Cycle");
		for (int i = 0; i < path.length; i++)
			System.out.print(" " + path[i] + " ");
	  
	        // Let us print the first vertex again to show the
	        // complete cycle
	        System.out.println(" " + path[0] + " ");
	}
}
