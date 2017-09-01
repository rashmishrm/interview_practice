package com.practice.stanford.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class DFS {
	public static void dfs(int start, Map<Integer, List<Integer>> adjancylist) {

		Set<Integer> visited = new HashSet<Integer>();

		Stack<Integer> stack = new Stack<>();
		stack.add(start);
		visited.add(start);
		while (!stack.isEmpty()) {

			int v = stack.pop();

			List<Integer> connected = adjancylist.get(v);
			for (Integer w : connected) {

				if (!visited.contains(w)) {
					visited.add(w);
					System.out.println("w" + w);

					stack.push(w);

				}

			}

		}
		System.out.println(visited.size());

	}

	public static void dfs_rec(int start, Map<Integer, List<Integer>> adjancylist, Set<Integer> visited) {

		List<Integer> connected = adjancylist.get(start);
		for (Integer w : connected) {
			if (!visited.contains(w)) {
				visited.add(w);
				System.out.println("w" + w);
				dfs_rec(w, adjancylist, visited);

			}
		}

	}

	public static void main(String[] args) {

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		map.put(1, Arrays.asList(new Integer[] { 2, 3 }));
		map.put(2, Arrays.asList(new Integer[] { 4, 5 }));
		map.put(4, Arrays.asList(new Integer[] { 1, 3 }));
		map.put(3, Arrays.asList(new Integer[] { 2 }));
		map.put(5, Arrays.asList(new Integer[] { 3, 4 }));

		dfs(1, map);
		Set<Integer> visited = new HashSet<Integer>();
		visited.add(1);
		dfs_rec(1, map, visited);

	}
}
