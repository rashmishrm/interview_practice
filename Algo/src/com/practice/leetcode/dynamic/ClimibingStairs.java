package com.practice.leetcode.dynamic;

public class ClimibingStairs {
	 public int climbStairs(int n) {
	        return climbStairsMemo(n, new int[n+1]);
	    }
	    public int climbStairsMemo(int n, int[] memo) {
	        if(n<0) return 0;
	        if(n==1 || n==0) return 1;
	        if(memo[n]==0 ){
	            memo[n]= climbStairsMemo(n-1, memo) + climbStairsMemo(n-2, memo);
	        }               
	        return  memo[n];
	    }
}
