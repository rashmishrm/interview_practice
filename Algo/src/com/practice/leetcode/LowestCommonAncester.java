package com.practice.leetcode;

public class LowestCommonAncester {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null || p == null || q == null) {
			return null;
		}

		if (root == p || root == q) {
			return root;
		}
		boolean pisLeft = isLeftSubtree(root.left, p);
		boolean qisLeft = isLeftSubtree(root.left, q);

		if (pisLeft != qisLeft) {
			return root;
		}

		return lowestCommonAncestor(!pisLeft && !qisLeft ? root.right : root.left, p, q);

	}

	public boolean isLeftSubtree(TreeNode root, TreeNode p) {

		if (root == null) {
			return false;
		}

		if (root.val == p.val) {
			return true;
		}

		isLeftSubtree(root.left, p);
		isLeftSubtree(root.right, p);

		return false;

	}
}
