package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

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
