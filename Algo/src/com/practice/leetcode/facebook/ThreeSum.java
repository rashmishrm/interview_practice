package com.practice.leetcode.facebook;
//
//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
//Note: The solution set must not contain duplicate triplets.
//
//For example, given array S = [-1, 0, 1, 2, -1, -4],
//
//A solution set is:
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> output=  new HashSet<>();


 if(nums==null || nums.length<3){
     return new ArrayList<>(output);
 }
 
 
 Arrays.sort(nums);
 
 

 
 for(int i =0;i<nums.length-2;i++){

     int l=i+1;
     int h = nums.length-1;
     
     while(l<h){
         if(nums[l]+nums[h]+nums[i]==0){
           output.add(Arrays.asList(new Integer[]{nums[l],nums[h],nums[i]})) ;
             l++;
             h--;
         }else if(nums[l]+nums[h]+nums[i]<0){
             l++;
         }
         else{
            h--; 
         }
         
     }
     
     
 }
 
 return new ArrayList<>(output);
 
 
}
}
