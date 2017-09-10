package com.practice.leetcode.tree;

//  Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class KSmallest {

	public int kthSmallest(TreeNode root, int k) {
		return inorder(root, k, 0);
	}

	public int inorder(TreeNode root, int k, int level) {
		if (root != null) {
			level++;
			inorder(root.left, k, level);

			if (k == level) {
				return root.val;
			}

			inorder(root.right, k, level);

		}
		return 0;

	}
	
	
}
