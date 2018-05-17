package com.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopInterviewINorde_Recursive {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		TreeNode node = root;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(node);
		while (node.left != null) {
			node = node.left;
			stack.push(node);

		}

		while (!stack.isEmpty()) {

			TreeNode popNode = stack.pop();

			list.add(popNode.val);
			if (popNode.right != null) {

				TreeNode right = popNode.right;
				stack.push(right);
				while (right.left != null) {

					stack.push(right.left);
					right = right.left;

				}
			}

		}

		return list;

	}

}
