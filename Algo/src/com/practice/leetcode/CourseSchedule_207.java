package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule_207 {
	class Solution {
		public  boolean canFinish(int numCourses, int[][] prerequisites) {
			boolean canFinish = true;
			HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
			if (prerequisites.length == 0) {
				return true;
			}

	        int[] indegree= new int[numCourses];
			for (int i = 0; i < prerequisites.length; i++) {
				if (map.get(prerequisites[i][1]) != null) {
					map.get(prerequisites[i][1]).add(prerequisites[i][0]);
				} else {
					List<Integer> list = new ArrayList<Integer>();

					list.add(prerequisites[i][0]);
					map.put(prerequisites[i][1], list);
				}
	            indegree[prerequisites[i][0]]++;
			}
	        Set<Integer> visited = new HashSet<Integer>();
			Queue<Integer> queue = new LinkedList<>();
	         for (int n = 0; n < indegree.length; n++) {
	             if(indegree[n]==0){
	                queue.offer(n); 
	                
	             }
	         }
	        


	        
	        
		
			int i = 1;
			while (!queue.isEmpty()) {

				int l = queue.poll();

				if (map.get(l) != null) {
					List<Integer> alist = map.get(l);
	                for(Integer c: alist){
	                    indegree[c]--;
	                    if(indegree[c]==0){
	                       queue.offer(c);  
	                    }
	                  
	                    
	                }
				}

			}
	        
	          for (int p = 0; p < indegree.length; p++) {
	             if(indegree[p]!=0){
	               return false;
	                
	             }
	         }

			return true;

		}
	}

	public static void main(String[] args) {
		int mat[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		//System.out.println(canFinish(3, mat));
	}
}
