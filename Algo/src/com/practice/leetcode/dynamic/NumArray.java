package com.practice.leetcode.dynamic;


public class NumArray {
    int nums[];
    int numsc[];
    public NumArray(int[] nums) {
        this.nums=nums;
        this.numsc= new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++){
        	sum=sum+nums[i];
        	numsc[i]=sum;
        }
        
    }
    
    public int sumRange(int i, int j) {
    	int result=0;
    	if(i==0){
    		result=numsc[j];
    	}
    	else{
    		result=numsc[j]-numsc[i-1];
    		
    	}
    	
    	return result;
        
    }
    
    public static void main(String[] args) {
		NumArray num= new NumArray(new int[]{-2,0,3,-5,2,-1});
		
		System.out.println(num.sumRange(0, 2));
		
	}
}