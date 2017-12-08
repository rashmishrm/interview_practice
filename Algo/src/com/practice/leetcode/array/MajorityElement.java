package com.practice.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			if (map.containsKey(nums[i])) {
				count = map.get(nums[i]) + 1;
			}
			map.put(nums[i], count);

			if (count > (nums.length / 2)) {
				return nums[i];

			}
		}
		return 0;

	}
}
