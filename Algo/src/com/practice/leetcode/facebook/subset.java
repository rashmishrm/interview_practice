package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subset {
public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> list= new ArrayList<>();
        list.add(new ArrayList<Integer>());
        
       
            for(int i=0;i<nums.length;i++){  
            List<List<Integer>> temp= new ArrayList<>(); 
                
             for(List<Integer> l: list){
                 List<Integer> newList= new ArrayList<>(l);
                 newList.add(nums[i]);
                 temp.add(newList);
             }
                
               list.addAll(temp);  
                
                
                
                
            }
            
        return list;
           
        
    }


public List<List<Integer>> subsetsWithDup(int[] nums) {
Arrays.sort(nums);
 List<List<Integer>> list= new ArrayList<>();
    list.add(new ArrayList<Integer>());
    int startIndex=0;
    int size=0;
       
        for(int i=0;i<nums.length;i++){  
        List<List<Integer>> temp= new ArrayList<>(); 
        startIndex = ((i >= 1 )&& (nums[i] == nums[i - 1]) )? size : 0;
        size=list.size();
   
         for(int j=startIndex;j<size;j++){
            
             List<Integer> newList= new ArrayList<>(list.get(j));
             newList.add(nums[i]);
             temp.add(newList);
           

            
           
         }
                           list.addAll(temp);  
            
        }
        
    return list;
}

public List<List<Integer>> subsets1(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}


public List<List<Integer>> subsetsWithDup1(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack1(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack1(List<List<Integer>> list, List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
        tempList.add(nums[i]);
        backtrack1(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
} 

public List<List<Integer>> combinationSum2(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
    
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue; // skip duplicates
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i + 1);
            tempList.remove(tempList.size() - 1); 
        }
    }
} 

//using same elements

public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtracksame(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtracksame(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtracksame(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}




public List<List<String>> partition(String s) {
	   List<List<String>> list = new ArrayList<>();
	   backtrack(list, new ArrayList<>(), s, 0);
	   return list;
	}

	public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
	   if(start == s.length())
	      list.add(new ArrayList<>(tempList));
	   else{
	      for(int i = start; i < s.length(); i++){
	         if(isPalindrome(s, start, i)){
	            tempList.add(s.substring(start, i + 1));
	            backtrack(list, tempList, s, i + 1);
	            tempList.remove(tempList.size() - 1);
	         }
	      }
	   }
	}

	public boolean isPalindrome(String s, int low, int high){
	   while(low < high)
	      if(s.charAt(low++) != s.charAt(high--)) return false;
	   return true;
	} 
	
	
	public List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
		
		
		
		public List<List<Integer>> permuteUnique(int[] nums) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack(list, new ArrayList<>(), nums, new boolean[nums.length]);
		    return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, boolean [] used){
		    if(tempList.size() == nums.length){
		        list.add(new ArrayList<>(tempList));
		    } else{
		        for(int i = 0; i < nums.length; i++){
		            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) continue;
		            used[i] = true; 
		            tempList.add(nums[i]);
		            backtrack(list, tempList, nums, used);
		            used[i] = false; 
		            tempList.remove(tempList.size() - 1);
		        }
		    }
		}
		
		
		
		public List<List<Integer>> combinationSum3(int[] nums) {
		    List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums);
		    backtracksame3(list, new ArrayList<>(), nums, 0, 0);
		    return list;
		}

		private void backtracksame3(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		   // if(remain < 0) return;
			if(tempList.size()==3 && remain != 0) return;
			
		   if(tempList.size()==3 && remain == 0) list.add(new ArrayList<>(tempList));
		    else{ 
		        for(int i = start; i < nums.length; i++){
		            tempList.add(nums[i]);
		            backtracksame3(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
		            tempList.remove(tempList.size() - 1);
		        }
		    }
		}

public static void main(String[] args) {
//	System.out.println(new subset().subsetsWithDup1(new int[] {1,2,2}));
	//System.out.println(new subset().combinationSum2(new int[] {1,2,2},3));
	//System.out.println(new subset().combinationSum(new int[] {1,2,3,4,5},3));
	System.out.println(new subset().combinationSum3(new int[] {-5, 1, 10, 2, 3}));

}
}
