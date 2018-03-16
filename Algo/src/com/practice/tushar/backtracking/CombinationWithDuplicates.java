package com.practice.tushar.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationWithDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsRec(nums, new ArrayList<Integer>(), 0, result);
        return result;

    }
    
    public void subsetsRec(int[] nums, List<Integer> temp, int pos,List<List<Integer>> result) {
        
        result.add(new ArrayList<>(temp));
       
        for(int i=pos;i<nums.length;i++){
            
            if(i>pos && nums[i-1]==nums[i]){continue;}
            
            temp.add(nums[i]);
            
            subsetsRec(nums, temp, i+1, result);
            
             temp.remove(temp.size()-1);
            
            
        }
    
        
        
        
    }
}
