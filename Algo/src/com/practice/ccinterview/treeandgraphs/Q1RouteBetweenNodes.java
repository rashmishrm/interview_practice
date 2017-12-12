package com.practice.ccinterview.treeandgraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class GraphNode {
	int val;
	public List<GraphNode> nodes;
}

public class Q1RouteBetweenNodes {

	public boolean routeBetweenNodes(GraphNode start, GraphNode end) {

		java.util.Queue<GraphNode> queue = new LinkedList<>();

		Set<Integer> visited = new HashSet<Integer>();
		queue.offer(start);
		visited.add(start.val);
		while (!queue.isEmpty()) {

			GraphNode node = queue.remove();
			if (node != null) {
				if (node.val == end.val) {
					return true;
				}
				for (GraphNode neighbor : node.nodes) {
					if (neighbor.val == end.val) {
						return true;
					}
					if (!visited.contains(neighbor.val)) {

						visited.add(neighbor.val);
						queue.add(neighbor);

					}

				}

			}
		}

		return false;
	}

}
