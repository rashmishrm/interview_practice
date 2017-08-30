package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class CourseSchedule_207 {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		boolean canFinish = true;
		HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		if (prerequisites.length == 0) {
			return true;
		}

		for (int i = 0; i < prerequisites.length; i++) {
			if (map.get(prerequisites[i][0]) != null) {
				map.get(prerequisites[i][0]).add(prerequisites[i][1]);
			} else {
				List<Integer> list = new ArrayList<Integer>();

				list.add(prerequisites[i][1]);
				map.put(prerequisites[i][0], list);
			}
		}
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(prerequisites[0][0]);

		while (!stack.isEmpty()) {

			int l = stack.pop();
			if (visited.contains(l)) {
				canFinish = false;
				break;
			}

			visited.add(l);
			
			if (map.get(l) != null) {
				stack.addAll(map.get(l));
			}

		}

		return canFinish;

	}

	public static void main(String[] args) {
		int mat[][] = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
		System.out.println(canFinish(3, mat));
	}
}
