package com.practice.leetcode.facebook;

public class RemoveDuplicates {
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
