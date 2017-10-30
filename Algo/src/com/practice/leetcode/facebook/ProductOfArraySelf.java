package com.practice.leetcode.facebook;

public class ProductOfArraySelf {

    public int[] productExceptSelf(int[] nums) {
        int leng = nums.length;
        int[] ret = new int[leng];
        if(leng == 0)
            return ret;
        int runningprefix = 1;
        for(int i = 0; i < leng; i++){
            ret[i] = runningprefix;
            runningprefix*= nums[i];
        }
        int runningsufix = 1;
        for(int i = leng -1; i >= 0; i--){
            ret[i] *= runningsufix;
            runningsufix *= nums[i];
        }
        return ret;

    }

    public static void main(String[] args) {
        System.out.println(new ProductOfArraySelf().productExceptSelf( new int[]{1,2,3,4} ));
    }
}
