package com.practice.tushar.backtracking;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> output = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		permuteRec(nums, result, 0, output);

		return output;
	}

	public static void permuteRec(int[] nums, List<Integer> list, int level, List<List<Integer>> output) {

		if (level == nums.length) {
			output.add(new ArrayList<>(list));

			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (list.contains(nums[i])) {
				continue;
			}

			list.add(nums[i]);

			permuteRec(nums, list, level + 1, output);

			list.remove(list.size() - 1);

		}

	}

	public static void main(String[] args) {
		permute(new int[] { 1, 2, 3 });
	}

}
