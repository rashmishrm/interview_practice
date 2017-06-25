package com.practice.leetcode;

import java.util.Arrays;

public class Courses {

	public static int scheduleCourse(int[][] courses) {

		int count = 0;
		int[] intervals = new int[courses.length];
		int[] days = new int[courses.length];
		for (int i = 0; i < courses.length; i++) {
			days[i] = courses[i][1];
			intervals[i] = courses[i][0];
		}

		Arrays.sort(days);

		int time = 0;
		for (int j = 0; j < days.length; j++) {
			if (time + intervals[j] <= days[j]) {
				time = time + intervals[j];
				count = count + 1;

			}

		}

		return count;
	}

	public static void main(String[] args) {
		int input[][] = new int[][] { { 1, 2 }, { 2, 3 } };

		System.out.println(scheduleCourse(input));
	}
}
