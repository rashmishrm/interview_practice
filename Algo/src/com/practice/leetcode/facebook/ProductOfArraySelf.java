package com.practice.leetcode.facebook;
//Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//Solve it without division and in O(n).
//
//For example, given [1,2,3,4], return [24,12,8,6].
//
//Follow up:
//Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
public class ProductOfArraySelf {

	public int[] productExceptSelf(int[] nums) {
	     
        int n=nums.length;
        
        int [] result= new int[n];
        
        int prefix=1;
        result[0]=1;
        for(int i=0;i<n;i++){
            result[i]=prefix;
            prefix=prefix*nums[i];
            
        }
        
        int suffix=1;
        
        for(int j=n-1;j>=0;j--){
            result[j]=result[j]*suffix;
            suffix=suffix*nums[j];
          
        }
        
        
        return result;
        
        
    }

    public static void main(String[] args) {
        System.out.println(new ProductOfArraySelf().productExceptSelf( new int[]{1,2,3,4} ));
    }
}
