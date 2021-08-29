package org.graph;

public class App {

	public static void graphUsingAdjacencyMatrix() {
		Graph graph = new Graph(4, 0);
		int[][]arr = graph.matrix;
		arr[0][1] = 1;
		arr[0][3] = 1;
		arr[1][2] = 1;
		arr[2][0] = 1;
		arr[2][3] = 1;
		StringBuilder builder = new StringBuilder();
		for (int[]row : arr) {
			for (int num : row) {
				builder.append(num).append(",");
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}
	
	public static void main(String[] args) {
		System.out.println("Graph using adjacency matrix");
		graphUsingAdjacencyMatrix();
		
		
	}
}
