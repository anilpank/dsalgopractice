package org.graph;

public class Graph {
	int v;
	int e;
	
	public int [][]matrix;
	
	public Graph(int v, int e) {
		this.v = v;
		this.e = e;
		this.matrix = new int[v][v];
	}
}
