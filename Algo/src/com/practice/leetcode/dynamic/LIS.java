package com.practice.leetcode.dynamic;

class LIS {
	public int lengthOfLIS(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;

		}
		int[] array = new int[nums.length];
		for (int k = 0; k < nums.length; k++) {
			array[k] = 1;
		}

		int high = 1;

		for (int i = 1; i < nums.length; i++) {

			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					array[i] = Math.max(array[j] + 1, array[i]);

				}
				high = Math.max(high, array[i]);

			}
		}

		return high;

	}
}
