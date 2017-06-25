package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SumThreeArray {

	public static List<List<Integer>> threeSum(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		Set<String> checkSet= new HashSet<String>();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {

			for (int j = i + 1; j < (nums.length - 1); j++) {
				int sum = -(nums[i] + nums[j]);
				if (set.contains(sum)) {
					Set<Integer> val= new TreeSet<Integer>();
					val.addAll(Arrays.asList(new Integer[] { nums[i], nums[j], -(nums[i] + nums[j]) }));
					
					output.add(Arrays.asList(new Integer[] { nums[i], nums[j], -(nums[i] + nums[j]) }));
					
				} else {
					set.add(nums[j]);
				}

			}
			
		

		}

		return output;

	}
	
	public static void main(String[] args) {
		System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
	}
	
	

}
