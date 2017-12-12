package com.practice.leetcode.facebook;

//Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
//
//For example, given the array [2,3,1,2,4,3] and s = 7,
//the subarray [4,3] has the minimal length under the problem constraint.
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

	boolean hasSequence(int[] nums, int T) {
		if (T <= 0)
			return false;
		if (nums.length == 0)
			return false;
		int i = 0;
		int start = 0;
		int sum = 0;
		while (i < nums.length) {
			if (sum + nums[i] < T)
				sum += nums[i];
			else if (sum + nums[i] == T)
				return true;
			else {
				sum += nums[i];
				while (sum > T) {
					sum -= nums[start];
					start++;
				}
				if (sum == T)
					return true;
			}
			i++;
		}
		return false;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 3, 1, 2, 4, 3 };
		new MinimumSizeSubarray().minSubArrayLen(7, arr);
	}
}
