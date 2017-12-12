package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
//Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
//
//However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
//
//You need to return the least number of intervals the CPU will take to finish all the given tasks.
//
//Example 1:
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
//Note:
//The number of tasks is in the range [1, 10000].
//The integer n is in the range [0, 100].


public class TaskSchedular {
	public int leastInterval(char[] tasksc, int n) {

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		PriorityQueue<Task> tasks = new PriorityQueue<Task>();

		for (int i = 0; i < tasksc.length; i++) {
			int count = 1;
			if (map.containsKey(tasksc[i])) {
				count = map.get(tasksc[i]) + 1;
			}
			map.put(tasksc[i], count);

		}

		for (Character ch : map.keySet()) {
			tasks.add(new Task(ch, map.get(ch)));
		}

		int time = 0;

		while (!tasks.isEmpty()) {

			int k = n + 1;
			List<Task> tempList = new ArrayList<Task>();
			while (k > 0 && !tasks.isEmpty()) {
				Task l = tasks.remove();
				l.count = l.count - 1;
				tempList.add(l);
				k--;
				time++;
			}
			for (Task eachTask : tempList) {
				if (eachTask.count > 0)
					tasks.offer(eachTask);
			}

			if (tasks.isEmpty()) {
				break;
			}

			time = time + k;
		}

		return time;

	}
}

class Task implements Comparable<Task> {
	char task;
	int count;

	public Task(char task, int count) {
		this.task = task;
		this.count = count;
	}

	public int compareTo(Task other) {
		return other.count - this.count;
	}

}
