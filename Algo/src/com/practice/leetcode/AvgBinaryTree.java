package com.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class AvgBinaryTree {

	public List<Double> averageOfLevels(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<Double> output = new ArrayList<Double>();
		if (root == null) {
			return null;
		}

		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0;
			List<TreeNode> list = new ArrayList<TreeNode>();
			while(!queue.isEmpty()) {
				TreeNode val = queue.remove();
				list.add(val);
				sum = sum + val.val;
			}
			output.add((sum / size));
			for (int j = 0; j < list.size(); j++) {
				if(list.get(j).left!=null)
				queue.offer(list.get(j).left);

				if(list.get(j).right!=null)	
				queue.offer(list.get(j).right);
			}

		}
		return output;
	}
}