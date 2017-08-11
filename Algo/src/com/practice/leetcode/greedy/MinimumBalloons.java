package com.practice.leetcode.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
//
//An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.

public class MinimumBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}

		List<Interval> intervals = new ArrayList<>();

		for (int i = 0; i < points.length; i++) {

			intervals.add(new Interval(points[i][0], points[i][1]));

		}

		Collections.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {

				return o1.end - o2.end;

			}
		});

		int arrows = 1;
		int last = intervals.get(0).end;
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).start > last) {
				arrows++;
				last = intervals.get(i).end;

			}
		}

		return arrows;
	}
}
