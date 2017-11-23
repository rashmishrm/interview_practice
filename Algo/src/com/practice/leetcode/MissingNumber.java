package com.practice.leetcode;

public class MissingNumber {
	public int missingNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int n = nums.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + nums[i];

		}

		int supposedSum = (n * (n + 1)) / 2;

		int diff = supposedSum - sum;
		return diff;

	}
}
