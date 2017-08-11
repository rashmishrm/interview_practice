package com.practice.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
	public static int eraseOverlapIntervals(Interval[] intervals) {

		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {

				return o1.end - o2.end;

			}
		});

		int discard = 0;
		int last = intervals[0].end;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < last) {
				discard++;
			} else {
				last = intervals[i].end;
			}
		}

		return discard;
	}

	public static void main(String[] args) {

		Interval[] ints = { new Interval(1, 2), new Interval(2, 3), new Interval(3, 4), new Interval(1, 3) };
		System.out.println(eraseOverlapIntervals(ints));

	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}