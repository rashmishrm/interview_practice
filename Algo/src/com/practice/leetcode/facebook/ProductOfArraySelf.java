package com.practice.leetcode.facebook;

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
