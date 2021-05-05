package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

import Greedy.Edge;
import Greedy.Graph;

public class TravellingSalespersonProblem {
	public static Integer start;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(4, 12);
		graph.addEdge(new Edge(0, 1, 16));
		graph.addEdge(new Edge(0, 2, 11));
		graph.addEdge(new Edge(0, 3, 6));
		graph.addEdge(new Edge(1, 0, 8));
		graph.addEdge(new Edge(1, 2, 13));
		graph.addEdge(new Edge(1, 3, 16));
		graph.addEdge(new Edge(2, 1, 7));
		graph.addEdge(new Edge(2, 0, 4));
		graph.addEdge(new Edge(2, 3, 9));
		graph.addEdge(new Edge(3, 0, 5));
		graph.addEdge(new Edge(3, 1, 12));
		graph.addEdge(new Edge(3, 2, 2));
		Integer[][] adjancencyMatrix = graph.getAdjancencyMatrix();
		for(Integer i = 0;i < graph.getVertices();i++) {
			for(Integer j = 0;j < graph.getVertices();j++) {
				System.out.print(adjancencyMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		start = 0;
		ArrayList<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(2);
//		list.add(3);
		for(Integer i = 1;i < graph.getVertices();i++) {
			list.add(i);
		}
		System.out.println("The Minimum Cost after visiting Every City Once: "+TSP(adjancencyMatrix, 0, list));
//		System.out.println(graph.getList());
//		Visit all Cities Exactly ones and return backs to its Home city.
		
	}
	public static Integer TSP(Integer[][] adjancencyMatrix, Integer i, ArrayList<Integer> list) {
		Integer answer = Integer.MAX_VALUE;
		if(list.isEmpty()) {
			return weight(adjancencyMatrix, i, start);
		}
		for(Integer k = 0;k < list.size();k++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			
			for(Integer m = 0;m < list.size();m++) {
				temp.add(list.get(m));
			}
			
			Integer j = temp.get(k);
			temp.remove(j);
			
//			System.out.println(j+" and "+temp);
			
			answer =  Math.min(answer, weight(adjancencyMatrix, i, j) + TSP(adjancencyMatrix, j, temp));
		}
		return answer;
	}
	public static Integer weight(Integer[][] adjancencyMatrix ,Integer i, Integer j) {
		return adjancencyMatrix[i][j];
	}
}
