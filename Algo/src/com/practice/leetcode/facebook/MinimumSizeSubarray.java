package com.practice.leetcode.facebook;

public class MinimumSizeSubarray {
	public int minSubArrayLen(int s, int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		;
		int sum = 0;
		int count = 0;
		int j = 0;

		for (int i = 0; i < nums.length; i++) {

			sum += nums[i];

			while (sum >= s) {
				if (min > i - j) {
					min = i - j;
				}
				sum -= nums[j];

				j++;

			}

		}

		return min == Integer.MAX_VALUE ? 0 : min + 1;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 3, 1, 2, 4, 3 };
		new MinimumSizeSubarray().minSubArrayLen(7, arr);
	}
}
