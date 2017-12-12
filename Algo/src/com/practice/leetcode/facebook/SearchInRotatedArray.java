package com.practice.leetcode.facebook;

//Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
//(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//You are given a target value to search. If found in the array return its index, otherwise return -1.
//
//You may assume no duplicate exists in the array.
public class SearchInRotatedArray {

	public static int search(int[] nums, int target) {
		int result = -1;
		int low = 0;
		int high = nums.length - 1;

		while (low <= high) {

			int mid = low + ((high - low) / 2);
			if (nums[mid] == target) {
				return mid;
			}

			else if (nums[low] <= nums[mid]) {
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}

			} else if (nums[low] > nums[mid]) {
				if (nums[mid] < target && target < nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;

				}

			}

		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 15, 16, 18, 19, 1, 3, 4, 5, 7, 10, 14 }, 5));
	}
}
