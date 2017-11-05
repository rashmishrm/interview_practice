package com.practice.leetcode.facebook;

import java.util.Stack;

public class BSTIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {

		populate(root);

	}

	public boolean hasNext() {
		return stack.size() > 0 ? true : false;
	}

	public void populate(TreeNode node) {

		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public int next() {
		if (stack.size() > 0) {
			TreeNode node = stack.pop();
			populate(node.right);
			return node.val;
		}
		return -1;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}