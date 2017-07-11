package com.practice.leetcode;

public class MaxDepth {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int minL= minDepth(root.left);
		int minR= minDepth(root.right);
		
		return minL==0 && minR!=0?1+minR:minR==0 && minL!=0?1+minL:1 + Math.min(minL, minR);
		
		
	}

}
