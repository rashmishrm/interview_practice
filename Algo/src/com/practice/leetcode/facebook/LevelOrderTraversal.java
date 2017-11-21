package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(root);

		while (!queue.isEmpty()) {

			Queue<TreeNode> temp = new LinkedList<TreeNode>();
			List<Integer> rootList = new ArrayList<>();

			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				rootList.add(node.val);
				if (node.left != null)
					temp.add(node.left);
				if (node.right != null)
					temp.add(node.right);

			}

			queue.addAll(temp);

			list.add(rootList);

		}

		return list;

	}
}
