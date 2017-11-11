package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {

		List<String> output = new ArrayList<String>();
		if (root == null) {
			return output;
		}
		binaryTreePaths(root, output, "");
		return output;

	}

	public void binaryTreePaths(TreeNode node, List<String> paths, String str) {

		if (node.left == null && node.right == null) {
			paths.add(str + node.val);
		}
		if (node.left != null) {
			binaryTreePaths(node.left, paths, str + node.val + "->");

		}
		if (node.right != null) {
			binaryTreePaths(node.right, paths, str + node.val + "->");

		}

	}

}
