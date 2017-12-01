package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


 //Definition for undirected graph.
  class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };




public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode input) {
		if (input == null) {
			return null;
		}

		Map<Integer, UndirectedGraphNode> newClonedNodes = new HashMap<Integer, UndirectedGraphNode>();

		Queue<UndirectedGraphNode> traversalGraphq = new LinkedList<UndirectedGraphNode>();
		UndirectedGraphNode snode = new UndirectedGraphNode(input.label);
		newClonedNodes.put(input.label, snode);

		traversalGraphq.offer(input);

		while (!traversalGraphq.isEmpty()) {
			UndirectedGraphNode node = traversalGraphq.remove();

			for (UndirectedGraphNode neighbor : node.neighbors) {
				UndirectedGraphNode nnode = null;
				if (newClonedNodes.get(neighbor.label) == null) {
					nnode = new UndirectedGraphNode(neighbor.label);
					newClonedNodes.put(neighbor.label, nnode);
					traversalGraphq.offer(neighbor);
				} else {
					nnode = newClonedNodes.get(neighbor.label);
				}
				newClonedNodes.get(node.label).neighbors.add(nnode);

			}

		}

		return snode;
	}
}
