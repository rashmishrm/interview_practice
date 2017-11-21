package com.practice.stanford.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TopologicalSort {
	static int num = 0;

	public static void dfs_rec(int start, Map<Integer, List<Integer>> adjancylist, Set<Integer> visited, int[] f) {

		List<Integer> connected = adjancylist.get(start);
		visited.add(start);
		for (Integer w : connected) {
			if (!visited.contains(w)) {
				visited.add(w);
				System.out.println("w" + w);
				dfs_rec(w, adjancylist, visited, f);

			}
		}

		f[start] = num;
		num--;

	}

	public static void topologicalsort(Map<Integer, List<Integer>> adjancylist) {

		Set<Integer> visited = new HashSet<Integer>();

		num = adjancylist.size() - 1;
		int f[] = new int[adjancylist.size()];

		Set<Integer> set = adjancylist.keySet();

		for (Integer node : set) {

			if (!visited.contains(node)) {

				dfs_rec(node, adjancylist, visited, f);

			}

		}

		for (int o : f) {

			System.out.println(o);
		}

	}

	public static void main(String[] args) {

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		map.put(2, Arrays.asList(new Integer[] { 3 }));
		map.put(3, Arrays.asList(new Integer[] {}));
		map.put(1, Arrays.asList(new Integer[] { 3 }));
		map.put(0, Arrays.asList(new Integer[] { 1, 2 }));

		topologicalsort(map);

	}

}
