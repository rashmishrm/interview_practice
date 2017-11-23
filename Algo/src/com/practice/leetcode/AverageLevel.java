package com.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevel {
	public List<Double> averageOfLevels(TreeNode root) {
		if (root == null) {
			return null;
		}
		List<Double> list = new ArrayList<Double>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {

			List<TreeNode> temp = new ArrayList<TreeNode>();

			Double avg = 0d;
			int n = queue.size();
			while (!queue.isEmpty()) {
				TreeNode polled = queue.poll();
				avg = avg + polled.val;
				if (polled.left != null)
					temp.add(polled.left);
				if (polled.right != null)
					temp.add(polled.right);

			}
			avg = avg / n;
			list.add(avg);
			queue.addAll(temp);

		}

		return list;

	}
}
