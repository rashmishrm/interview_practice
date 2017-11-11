package com.practice.leetcode.facebook;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
	  public int findKthLargest(int[] nums, int k) {
	        
	        
	        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(5,Collections.reverseOrder());
	        
	        
	        
	        for(int num:nums){
	            pq.add(num);
	            
	        }
	        int l=0;
	        while(k>0){
	           l=  pq.remove();
	            k--;
	        }
	        

	        
	        
	        return l;
	        
	    }
}
