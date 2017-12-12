package com.practice.leetcode.facebook;
//Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
//
//Formally the function should:
//Return true if there exists i, j, k 
//such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
//Your algorithm should run in O(n) time complexity and O(1) space complexity.
//
//Examples:
//Given [1, 2, 3, 4, 5],
//return true.
//
//Given [5, 4, 3, 2, 1],
//return false.
public class IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length == 0) {
			return false;
		}
		int count = 0;
		int a = Integer.MAX_VALUE;
		int b = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < a) {
				a = nums[i];
			} else if (nums[i] > a && nums[i] < b) {
				b = nums[i];
			} else if (nums[i] > a && nums[i] > b) {
				return true;
			}

		}

		return false;
	}
}
