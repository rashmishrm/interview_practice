package com.practice.leetcode.facebook;
//Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
//Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
//Note:
//You are not suppose to use the library's sort function for this problem.
//
//click to show follow up.
public class SortedColors {
    public void sortColors(int[] nums) {
        
        int p1 =0;
        int p2 =nums.length-1;
        int findex=0;
        
        while(findex<=p2){
           if(nums[findex]==0){
               nums[findex]=nums[p1];
               nums[p1]=0;
               p1++;

           } 
           else if(nums[findex]==2){
                 nums[findex]=nums[p2];
               nums[p2]=2;
               p2--;
          //  findex--;


           }
            findex++;
            
            
        }
        
        
        
    }
    
    public static void main(String[] args) {
    	int nums[]= {1,1,2,0,0,2,1,1};
		new SortedColors().sortColors(nums);
	}
}
