package com.practice.leetcode.facebook;

public class DiameterOfTree {
	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxDepth(root);
		return max;
	}

	int maxDepth(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int left = maxDepth(root.left);
		int right = maxDepth(root.right);

		max = Math.max(max, left + right);

		return 1 + Math.max(left, right);

	}
}
