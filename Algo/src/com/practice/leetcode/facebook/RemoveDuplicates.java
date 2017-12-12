package com.practice.leetcode.facebook;

public class RemoveDuplicates {
	
//	Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.
//
//			Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//			Example:
//
//			Given nums = [1,1,2],
//
//			Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
//			It doesn't matter what you leave beyond the new length.
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        
        int id=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[id++]=nums[i];
            }
        }
        return id;
        
    }
//    Follow up for "Remove Duplicates":
//    	What if duplicates are allowed at most twice?
//
//    	For example,
//    	Given sorted array nums = [1,1,1,2,2,3],
//
//    	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


    public int removeDuplicatesII(int[] nums) {
        int j=2;
        int count=0;
        for(int i=2;i<nums.length;i++){
            
            if(nums[i]!=nums[j-2] ){
                nums[j++]=nums[i];
             
            }
            
            
            
        }
        return j;
    	}
    
    public int removeDuplicatesO(int[] nums) {
    	   int i = 0;
    	   for (int n : nums)
    	      if (i < 2 || n > nums[i - 2])
    	         nums[i++] = n;
    	   return i;
    	}
    
    public static void main(String[] args) {
		new RemoveDuplicates().removeDuplicatesII(new int[] {1,1,1,2,2,3});
	}
}
