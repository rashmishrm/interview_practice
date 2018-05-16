package com.practice.leetcode.tree;

public class TopInterviewKSmallest {

	static int i = 0;
	static int val = 0;

	public static int kthSmallest(TreeNode root, int k) {
		i = k;
		if (root == null) {
			return 0;
		}
		inorder(root, k);
		return val;
	}

	public static void inorder(TreeNode node, int k) {
		if (node == null) {
			return;
		}
		if (node.left != null)
			inorder(node.left, k);
		i--;
		if (i == 0) {
			val = node.val;
			return;
		}

		if (node.right != null)
			inorder(node.right, k);

	}

}
