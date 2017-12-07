package com.practice.leetcode.facebook;

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
            findex--;


           }
            findex++;
            
            
        }
        
        
        
    }
    
    public static void main(String[] args) {
    	int nums[]= {1,1,2,0,0,2,1,1};
		new SortedColors().sortColors(nums);
	}
}
