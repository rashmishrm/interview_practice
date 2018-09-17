package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];

		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		if (prerequisites.length == 0) {
			for (int k = 0; k < numCourses; k++) {
				result[k] = k;
			}

			return result;
		}

		int[] indegree = new int[numCourses];
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
		int i = 0;
		Queue<Integer> queue = new LinkedList<>();
		for (int n = 0; n < indegree.length; n++) {
			if (indegree[n] == 0) {
				queue.offer(n);
				result[i] = n;
				i++;
			}
		}

		while (!queue.isEmpty()) {

			int l = queue.poll();

			if (map.get(l) != null) {
				List<Integer> alist = map.get(l);
				for (Integer c : alist) {
					indegree[c]--;
					if (indegree[c] == 0) {
						queue.offer(c);
						result[i] = c;
						i++;
					}

				}
			}

		}

		for (int p = 0; p < indegree.length; p++) {
			if (indegree[p] != 0) {
				return new int[0];

			}
		}
		return result;
	}
}