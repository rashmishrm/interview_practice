package com.practice.tushar.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		subsetsRec(nums, new ArrayList<Integer>(), 0, 0, result);
		return result;

	}

	public void subsetsRec(int[] nums, List<Integer> temp, int level, int pos, List<List<Integer>> result) {

		result.add(new ArrayList<>(temp));

		for (int i = pos; i < nums.length; i++) {

			if (temp.contains(nums[i])) {
				continue;
			}

			temp.add(nums[i]);

			subsetsRec(nums, temp, level + 1, i + 1, result);

			temp.remove(temp.size() - 1);

		}

	}
}
