package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSubset {

	public static ArrayList<ArrayList<Integer>> findSubSets(int[] set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<Integer>());

		for (int i = 0; i < set.length; i++) {

			ArrayList<ArrayList<Integer>> newsubsets = new ArrayList<>();
			for (ArrayList<Integer> list : subsets) {
				int current = set[i];

				ArrayList<Integer> newList = new ArrayList<Integer>(list);
				newList.add(current);
				newsubsets.add(newList);
			}
			subsets.addAll(newsubsets);
		}

		return subsets;

	}
	
	 static int smallestSubWithSum(int arr[], int x) 
	    {
		 int n = arr.length;
	        // Initialize current sum and minimum length
	        int curr_sum = 0, min_len = n + 1;
	 
	        // Initialize starting and ending indexes
	        int start = 0, end = 0;
	        while (end < n) 
	        {
	            // Keep adding array elements while current sum
	            // is smaller than x
	            while (curr_sum >= x && end < n)
	                curr_sum += arr[end++];
	 
	            // If current sum becomes greater than x.
	            while (curr_sum < x && start < n) 
	            {
	                // Update minimum length if needed
	                if (end - start > min_len)
	                    min_len = end - start;
	 
	                // remove starting elements
	                curr_sum += arr[start++];
	            }
	        }
	        return min_len;
	    }
	 
	 
	 static int bsearch(int prefixsum[], int n, int k)
	 {
	     int ans = -1;    // Initialize result
	  
	     // Do Binary Search for largest subarray size 
	     int left = 1, right = n;
	     while (left <= right)
	     {
	         int mid = (left + right)/2;
	  
	         // Check for all subarrays after mid
	         int i;
	         for (i = mid; i <= n; i++)
	         {
	             // Checking if all the subarrays of a size
	             // is less than k.
	             if (prefixsum[i] - prefixsum[i - mid] > k)
	                 break;
	         }
	  
	         // All subarrays of size mid have sum less
	         // than or equal to k
	         if (i == n+1)
	         {
	             left = mid + 1;
	             ans = mid;
	         }
	  
	         // We found a subrray of size mid with sum
	         // greater than k
	         else
	             right = mid -1;
	     }
	  
	     return ans+1;
	 }
	static  int maxSize(int arr[], int k)
	 {
		 int n=arr.length;
	     // Initialize prefix sum array as 0.
	     int[] prefixsum= new int[n+1];
	  
	  
	     // Finding prefix sum of the array.
	     for (int i = 0; i < n; i++)
	         prefixsum[i+1] = prefixsum[i] + arr[i];
	  
	     return bsearch(prefixsum, n, k);
	 }
	
    static int maxLength(int[] a, int k) {
		int sum = 0;
		int len = 0;
		int temp=0;
		for (int i = 0; i < a.length; i++) {
			sum = a[i];
			temp=1;
			for (int j = i + 1; j < a.length; j++) {
				temp++;
				sum = sum + a[j];
				if(sum<=k){
					if(temp>len){
						len=temp;
					}
				}else{
					break;
				}
			}
		}
		
		return len;
	}
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
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
	public static void main(String[] args) {
		System.out.println(maxSize(new int[]{3,1,2,1},4));
		
		System.out.println(findSubSets(new int[]{3,1,2,1}));

		System.out.println(subsetsWithDup(new int[]{1,2,2}));
	}

}
