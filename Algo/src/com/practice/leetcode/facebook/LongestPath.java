package com.practice.leetcode.facebook;

import java.util.LinkedList;
import java.util.Queue;

class TNode {
	int val;
	TNode left;
	TNode right;
	int label;

	TNode(int x, int label) {
		val = x;
		this.label = label;
	}
}

public class LongestPath {

	int max = 0;
	int label = 0;

	public int solution(int[] n, int[] e) {
		if (n == null || e == null) {
			return 0;
		}

		int result = 0;
		int size = n.length;
		int edges = e.length;

		int j = 1;

		// forming tree first

		Queue<TNode> queue = new LinkedList<TNode>();

		if (size > 1 && edges > 1) {

			TNode node = new TNode(e[0], n[0]);
			queue.offer(node);

			for (int i = 1; i < edges; i = i + 4) {

				TNode l = queue.poll();

				if (l != null) {

					TNode left = new TNode(e[i], n[j]);
					l.left = left;
					queue.offer(left);

					if (edges > i + 2) {
						TNode right = new TNode(e[i + 2], n[j + 1]);
						l.right = right;
						queue.offer(right);
					}

				}
				j = j + 2;

			}

			result = longPath(node);

		}

		return result;
	}

	public int longPath(TNode root) {
		if (root == null) {
			return 0;
		}
		maxDepth(root, root.label);
		return max;
	}

	int maxDepth(TNode root, int label) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left, root.label);
		int right = maxDepth(root.right, root.label);

		max = Math.max(max, left + right);

		int depth = 0;
		if (root.label == label) {
			depth = 1 + Math.max(left, right);
		} else {
			depth = 0;
		}
		return depth;

	}

	public static void main(String[] args) {

		//int n[] = { 5, 5, 5, 4, 3, 5 };

		//int e[] = { 1, 2, 1, 5, 2, 3, 2, 4, 5, 6 };
		 int e[] = { 1, 2, 1, 3, 2, 4, 2, 5 };

		int n1[] = { 1, 1, 1, 2, 2 };

		// int n[] = { 1,1,1};

		// int e[] = { 1,2,1,3};
		System.out.println(new LongestPath().solution(n1, e));

	}

}
