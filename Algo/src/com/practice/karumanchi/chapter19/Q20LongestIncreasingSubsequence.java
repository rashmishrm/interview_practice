package com.practice.karumanchi.chapter19;

public class Q20LongestIncreasingSubsequence {

	public static int lengthOfLIS(int[] nums) {
		int max=0;
		int mem[] = new int[nums.length];

		for (int i = 0; i < nums.length; i++)
			mem[i] = 1;

		for (int i = 0; i < nums.length; i++) {

			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && mem[i] < mem[j] + 1) {
					mem[i] = mem[i] + 1;
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(max<mem[i]){
				max=mem[i];
			}
		}

		return max;
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {5,6,3,2,4,7,5,8,9,0}));
	}
}
