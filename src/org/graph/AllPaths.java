package org.graph;

import java.util.ArrayList;
import java.util.List;

public class AllPaths {

	public static void main(String[] args) {
		int[][]graph = {{1,2}, {3}, {3}, {}};
		int[][]graph2 = {{1,2,3},{2},{3},{}};
		List<List<Integer>> paths = new AllPaths().allPathsSourceTarget(graph2);
		StringBuilder builder = new StringBuilder();
		for (List<Integer> list : paths) {
			for (int val : list) {
				builder.append(val).append(",");
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}
	public void dfs(int[][] graph, List<List<Integer>> paths,List<Integer> list, int u) {
		list.add(u);
		System.out.println("added this item to list>" + u);
		if (u == graph.length - 1) {            
			paths.add(new ArrayList(list));
			System.out.print("added this list to paths and returning>");
			list.forEach(System.out::print);
			System.out.println();
			return;
		}        
		for (int val : graph[u]) {
			dfs(graph, paths, list, val);
			System.out.println("removing this item from list>" + list.get(list.size()-1));
			list.remove(list.size()-1);
		}


	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> paths = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		dfs(graph, paths, list, 0);
		return paths;
	}
}
