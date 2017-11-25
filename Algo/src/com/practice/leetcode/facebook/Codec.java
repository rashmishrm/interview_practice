package com.practice.leetcode.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return null;
		}

		StringBuilder str = new StringBuilder();

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.offer(root);

		while (!queue.isEmpty()) {

			int n = queue.size();

			for (int i = 0; i < n; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					str.append("null,");
				} else {

					str.append(node.val + ",");

					queue.offer(node.left);
					queue.offer(node.right);
				}

			}

		}
		return str.toString();

	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {

		if (data == null) {
			return null;
		}

		String[] array = data.split(",");

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node = new TreeNode(Integer.parseInt(array[0]));
		queue.offer(node);

		for (int i = 1; i < array.length - 1; i = i + 2) {
			if (array[i] != null && !array[i].equals("")) {
				TreeNode l = queue.poll();
				if (!array[i].equals("null")) {
					TreeNode left = new TreeNode(Integer.parseInt(array[i]));
					l.left = left;
					queue.offer(left);
				}
				if (!array[i + 1].equals("null")) {
					TreeNode right = new TreeNode(Integer.parseInt(array[i + 1]));
					l.right = right;
					queue.offer(right);
				}
			}
		}
		return node;

	}
}