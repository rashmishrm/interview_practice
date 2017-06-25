package com.practice.leetcode;

import java.util.Arrays;

public class MaxProduct {
	public static  int maximumProduct(int[] nums) {
		int output=0;
		
		
	
		
		
		
		if(nums!=null){
			Arrays.sort(nums);
			int left= nums[0] * nums[1] *nums[2];
			
			
			int right= nums[nums.length-1] * nums[nums.length-2] *nums[nums.length-3];
			
			int middle1 = nums[0] * nums[1] * nums[nums.length-1];
			
			int middle2 = nums[0] * nums[nums.length-1] * nums[nums.length-2];
			
			
			if(left>right){
				output=left;
				
				
				
			}else{
				output=right;
			}
			
			if(output<middle1){
				output=middle1;
			}
			
			if(output<middle2){
				output=middle2;
			}
			
			
			
		}
		
		return output;
		
	}

	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[] { -4, -2, -1, 60 }));
	}

}
