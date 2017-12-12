package com.practice.ccinterview.treeandgraphs;

public class Q2MinimalTree {
	public TreeNode formTree(int[] array) {

		return formTree(array, 0, array.length-1);

	}

	public TreeNode formTree(int[] array, int start, int end) {

		int mid = start + ((end - start) / 2);

		TreeNode root = new TreeNode(array[mid]);
		root.left = formTree(array, start, mid - 1);

		root.right = formTree(array, mid + 1, end);
		return root;

	}
}
