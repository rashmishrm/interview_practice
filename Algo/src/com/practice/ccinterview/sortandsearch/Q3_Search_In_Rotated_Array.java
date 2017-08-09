package com.practice.ccinterview.sortandsearch;

public class Q3_Search_In_Rotated_Array {
	public static int search(int[] nums, int target) {

		return search(nums, target, 0, nums.length - 1);

	}

	public static int search(int[] nums, int target, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + ((high - low) / 2);
		if (nums[mid] == target) {
			return mid;
		}

		if (nums[low] <= nums[mid]) {
			if (target < nums[mid] && target >= nums[low]) {
				return search(nums, target, low, mid - 1);
			} else {
				return search(nums, target, mid + 1, high);

			}

		} else if (nums[high] > nums[mid]) {
			if (target > nums[mid] && target <= nums[high]) {
				return search(nums, target, mid + 1, high);

			} else {
				return search(nums, target, low, mid - 1);

			}

		}

		return -1;

	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { 3, 3 ,4, 5}, 3));
	}
}
