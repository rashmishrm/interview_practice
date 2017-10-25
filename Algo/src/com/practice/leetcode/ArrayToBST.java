package com.practice.leetcode;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class ArrayToBST {

	public static TreeNode sortedArrayToBST(int[] nums) {
		TreeNode root = null;
		if (nums != null && nums.length > 0) {
			int start = 0;
			int end = nums.length - 1;
			root = sortedArrayToBST(nums, start, end);

		}

		return root;
	}

	public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		TreeNode root = null;
		if (start > end) {
			return null;

		}

		int mid = (start + end) / 2;

		root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBST(nums, start, mid - 1);
		root.right = sortedArrayToBST(nums, mid + 1, end);

	

	return root;

	}

	public static void main(String[] args) {



		sortedArrayToBST(new int[] { 1, 2, 3, 4, 5, 6, 7 });
	}

}
