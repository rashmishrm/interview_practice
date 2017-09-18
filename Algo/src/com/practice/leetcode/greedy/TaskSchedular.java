package com.practice.leetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskSchedular {

	static class  Task implements Comparable<Task> {

		String task;
		int count;

		@Override
		public int compareTo(Task o) {
			// TODO Auto-generated method stub
			return o.count-this.count;		}

		public Task(String task, int count) {
			super();
			this.task = task;
			this.count = count;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return task+"::"+count;
		}
	}

	public static int leastInterval(char[] tasks, int n) {
		Map<String, Integer> countMap = new HashMap<String, Integer>();
		for (char c : tasks) {
			int count = 1;
			if (countMap.containsKey(c + "")) {
				count = count + countMap.get(c + "");
			}
			countMap.put(c + "", count);
		}

		PriorityQueue<Task> q = new PriorityQueue<>();
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			Task task = new Task(entry.getKey(), entry.getValue());
			q.add(task);
		}
		
		System.out.println(q);
		int time = 0;
		while (!q.isEmpty()) {

			List<Task> temp = new ArrayList<Task>();
			int i = 0;

			while (i <= n) {
				if (!q.isEmpty()) {
					Task t = q.poll();

					t.count = t.count - 1;

					if (t.count > 0) {
						temp.add(t);
					}
				}
				
				time++;
				
				if(q.isEmpty() &&temp.size()==0)
					break;
				i++;
			}

			q.addAll(temp);

		}

		return time;

	}
	
	public static void main(String[] args) {
		System.out.println(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2));
	}
}
