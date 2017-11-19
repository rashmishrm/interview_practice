package com.practice.leetcode.facebook;

import java.util.HashMap;

public class TwoSum {
public int[] twoSum(int[] nums, int target) {
        
        int one=0;
        int two=0;
        HashMap<Integer,Integer> map= new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++){
            int wanted=target - nums[i];
            if(map.containsKey(wanted)){
                two= map.get(wanted);
                one=i;
                break;
            }
               map.put(nums[i],i);
        }
        
       
       
        
        return new int[] {one,two};
        
        
    }

public int[] twoSum1(int[] numbers, int target) {
    
    
    int low=0;
    int  high=numbers.length-1;
    
    int one=0;
    int two=0;
    
    while(low<high){
        if(numbers[low]+numbers[high]<target){
            low++;
        }
        else if(numbers[low]+numbers[high]>target){
            high--;
        }
        else{
            one=low;
            two=high;
            break;
        }
        
        
    }
    return new int[]{one+1,two+1};
    
}
}
