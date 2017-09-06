package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;

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
	
	public static void main(String[] args) {
		System.out.println(smallestSubWithSum(new int[]{1,2,3,4},4));
	}

}
