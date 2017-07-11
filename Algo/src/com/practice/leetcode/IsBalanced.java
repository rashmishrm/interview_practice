package com.practice.leetcode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class IsBalanced {

	public boolean isBalanced(TreeNode root) {

		return height(root) == -1 ? false : true;

	}

	public int height(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int lDepth = height(root.left);
		if(lDepth==-1)
			return -1;
		
		int rDepth = height(root.right);
		
		if(rDepth==-1)
			return -1;

		if (Math.abs(lDepth - rDepth) > 1) {
			return -1;
		}

		return 1 + Math.max(lDepth, rDepth);

	}
}
