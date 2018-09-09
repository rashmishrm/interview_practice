package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CalculateEquation {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		Set<String> nodes = new HashSet<String>();
		List<String> nodesL = new ArrayList<String>();
		Map<String, Double> graphMap = new HashMap<String, Double>();
		Map<String, Integer> nodesM = new HashMap<String, Integer>();
		for (int i = 0; i < equations.length; i++) {
			nodes.add(equations[i][0]);
			nodes.add(equations[i][1]);
			graphMap.put(equations[i][0] + "->" + equations[i][1], values[i]);
			graphMap.put(equations[i][1] + "->" + equations[i][0], ((double) 1 / (double) values[i]));

		}
		int index = 0;
		for (String s : nodes) {
			nodesL.add(s);
			nodesM.put(s, index);
			index++;
		}

		// System.out.println(nodesL);

		double graph[][] = new double[nodes.size()][nodes.size()];
		for (int m = 0; m < nodesL.size(); m++) {
			for (int n = 0; n < nodesL.size(); n++) {
				if (m == n) {
					graph[m][n] = 1;
				} else {
					// System.out.println(nodesL.get(m)+"->"+nodesL.get(n));
					if (graphMap.containsKey(nodesL.get(m) + "->" + nodesL.get(n)))
						graph[m][n] = graphMap.get(nodesL.get(m) + "->" + nodesL.get(n));
				}
			}
		}

		double[] d = new double[queries.length];
		for (int q = 0; q < queries.length; q++) {
			String start = queries[q][0];
			String end = queries[q][1];

			int s = nodesM.get(start) != null ? nodesM.get(start) : 0;
			int e = nodesM.get(end) != null ? nodesM.get(end) : 0;
			if (!nodes.contains(start) || !nodes.contains(end)) {
				d[q] = (double) -1;
			} else if (start.equals(end)) {
				d[q] = (double) 1;
			}

			else if (graph[s][e] != 0) {

				d[q] = graph[s][e];
			} else {
				d[q] = bfs(s, e, graph, nodesL);
			}
		}
		return d;
	}

	public double bfs(int start, int end, double graph[][], List<String> nodesL) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Double> pqueue = new LinkedList<Double>();

		queue.add(start);
		pqueue.add(1d);

		boolean[] visited = new boolean[nodesL.size()];
		while (!queue.isEmpty()) {

			int n = queue.poll();
			double num = pqueue.poll();
			if (n == end) {
				return num;
			} else {
				for (int k = 0; k < nodesL.size(); k++) {
					if (graph[n][k] != 0 && n != k && !visited[k]) {
						// num=num*graph[n][k];

						// System.out.println(num);
						pqueue.add(num * graph[n][k]);
						queue.add(k);

						if (k == end) {
							return num * graph[n][k];
						}

					}
				}
				visited[n] = true;
			}
		}
		return -1;
	}
}
