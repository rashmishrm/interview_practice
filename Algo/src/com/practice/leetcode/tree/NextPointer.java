package com.practice.leetcode.tree;


/**
 * 
 * @author rash
 *
 *
 *
 *
 */


// Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}

public class NextPointer {
	public void connect(TreeLinkNode root) {

		if (root == null || root.left == null || root.right == null)
			return;

		root.left.next = root.right;

		connect(root.left);

		if (root.next != null)
			root.right.next = root.next.left;

		connect(root.right);

	}
}
