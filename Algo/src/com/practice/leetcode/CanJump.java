package com.practice.leetcode;

public class CanJump {
	 public boolean canJump(int[] nums) {
	        if(nums==null ||nums.length==0){
	            return false;
	        }
	        int[] cache = new int[nums.length];
	        for(int i=0;i<nums.length;i++){
	            cache[i]=-1;
	        }
	     
	        return jump(0,nums,cache)==1;
	        
	    }
	    
	    public int jump(int current , int[] nums, int[] cache){
	        
	        if(current==nums.length-1){
	            return 1;
	        }
	       if (cache[current] != -1) {
	            return cache[current];
	        }
	        int max=Math.min(current+ nums[current],nums.length-1);
	           for(int i=current+1;i<=max;i++){           
	              if(jump(i,nums,cache)==1){
	                  cache[current]=1;
	                  return 1;
	              }
	         }
	        cache[current]=0;
	        return 0;
	        
	    }
	    
	    public boolean greedyCanJump(int[] nums) {
	        int lastPos = nums.length - 1;
	        for (int i = nums.length - 2; i >= 0; i--) {
	            if (i + nums[i] >= lastPos) {
	                lastPos = i;
	            }
	        }
	        return lastPos == 0;
	    }
}
