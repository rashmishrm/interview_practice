package com.practice.leetcode.dynamic;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        boolean istrue=false;
 		int mem[] = new int[nums.length];

 		for (int i = 0; i < nums.length; i++)
 			mem[i] = 1;

 		for (int i = 0; i < nums.length; i++) {

 			for (int j = 0; j < i; j++) {
 				if (nums[i] > nums[j] && mem[i] < mem[j] + 1) {
 					mem[i] = mem[i] + 1;
 				}
 			}
             if(mem[i]>=3){
                 istrue=true;
                 break;
             }
 		}
 		
 		

 		return  istrue;
     }
}
