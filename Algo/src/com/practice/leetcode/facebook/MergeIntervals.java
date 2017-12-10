package com.practice.leetcode.facebook;

//Given a collection of intervals, merge all overlapping intervals.

//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0) {
			return result;
		}

		Collections.sort(intervals, new IntervalSorter());

		int start = intervals.get(0).start;
		int end = intervals.get(0).end;

		for (int i = 1; i < intervals.size(); i++) {
			Interval current = intervals.get(i);

			if (current.start >= start && current.start <= end) {
				if (end < current.end) {
					end = current.end;
				}
			} else {
				result.add(new Interval(start, end));
				start = current.start;
				end = current.end;
			}

		}

		result.add(new Interval(start, end));

		return result;

	}
}

class IntervalSorter implements Comparator<Interval> {

	public int compare(Interval a, Interval b) {

		return a.start - b.start;

	}
}
