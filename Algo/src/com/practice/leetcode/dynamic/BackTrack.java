package com.practice.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrack {
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		System.out.println("backtrack call : "+list + " : :"+tempList+"::: "+start);
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}
	
	
	public static void main(String[] args) {
		
		
		subsets(new int[] {1,2,3});
	}
}
