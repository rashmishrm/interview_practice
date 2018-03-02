package com.practice.leetcode.dynamic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HouseRobbers {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		return rob(nums, nums.length - 1, new HashMap<Integer, Integer>());
	}

	public int rob(int[] nums, int position, Map<Integer, Integer> map) {
		if (position < 0) {
			return 0;
		}
		int sum = 0;
		if (map.get(position) == null) {
			
			sum = Math.max(rob(nums, position - 2, map) + nums[position], rob(nums, position - 1, map));
			map.put(position, sum);

		} else {
			sum = map.get(position);
		}

		return sum;

	}
	
	public int rob_2(int[] nums, int position, Map<Integer, Integer> map) {
		if (position < 0) {
			return 0;
		}
		int sum = 0;
		if (map.get(position) == null) {
			
			sum = Math.max(rob(nums, position - 2, map) + nums[position], rob(nums, position - 1, map));
			map.put(position, sum);

		} else {
			sum = map.get(position);
		}

		return sum;

	}

	public int rob_it(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int array[] = new int[nums.length + 1];

		array[0] = 0;
		array[1] = nums[0];

		for (int i = 2; i <= nums.length; i++) {
			array[i] = Math.max(array[i - 2] + nums[i - 1], array[i - 1]);
		}
		return array[nums.length];
	}

	public int robII(int[] nums) {
		Set<Integer> set = new HashSet<>();
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int array[] = new int[nums.length + 1];

		array[0] = 0;
		array[1] = nums[0];

		for (int i = 2; i <= nums.length; i++) {
			
			if(i==nums.length && set.contains(1)) {
			array[i]=	array[i - 1];
			}
			else {
			array[i] = Math.max(array[i - 2] + nums[i - 1], array[i - 1]);
			}
			if (array[i - 2] + nums[i - 1] > array[i - 1]) {
				set.add(i - 1);
			}
		}
		return array[nums.length];
	}
}
