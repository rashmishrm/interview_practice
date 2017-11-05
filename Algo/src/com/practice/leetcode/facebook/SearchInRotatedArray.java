package com.practice.leetcode.facebook;

public class SearchInRotatedArray {
	
	
	public static int search(int[] nums, int target) {
        int result=-1;
        int low=0;
        int high=nums.length-1;
        
        while(low<=high){
            
            int mid= low+ ((high-low)/2);
            if(nums[mid]==target){
                return mid;
            }
            
           else if(nums[low]<=nums[mid] ){
                if(nums[low]<= target && target < nums[mid]){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
                
                
            }
            else if(nums[low]>nums[mid] ){
                if(nums[mid]<target && target<nums[low]){
                    low=mid+1;
                }
                else{
                    high=mid-1;

                }
                
                
            }
            
            
            
        }
        return result;
        
    }
	
	
	
	
	public static void main(String[] args) {
		search(new int[] {1}, 1);
	}
}
