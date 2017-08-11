package com.practice.karumanchi.chapter17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Interval Scheduling Algorithm: Given a set of n intervals S = {(starti, endj)|1 ≤ i
//≤ n}. Let us assume that we want to find a maximum subset S′ of S such that no pair of
//intervals in S′ overlaps. Check whether the following algorithm works or not.

//Consider the following problem.
//Input: S = {(starti,endi)|1 ≤ i ≤ n} of intervals. The interval (starti,endi) we can treat as a
//request for a room for a class with time start; to time endi.
//Output: Find an assignment of classes to rooms that uses the fewest number of rooms.
//Consider the following iterative algorithm. Assign as many classes as possible to the first
//room, then assign as many classes as possible to the second room, then assign as many
//classes as possible to the third room, etc. Does this algorithm give the best soluti

public class Q2_Interval_Scheduling {

	public static int classSchedular(List<Time> list) {

		int rooms = 1;
		Collections.sort(list, new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				return o1.startTime - o2.startTime;
			}
		});

		PriorityQueue<Time> pq = new PriorityQueue<>(list.size(), new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				return o1.endTime - o2.endTime;
			}
		});

		pq.add(list.get(0));

		for (int i = 1; i < list.size(); i++) {

			Time lastTime = pq.poll();
			if (lastTime != null && list.get(i).startTime < lastTime.endTime) {
				rooms++;
				pq.add(lastTime);

				pq.add(list.get(i));
			}

		}

		return rooms;

	}

	public static void main(String[] args) {
		List<Time> list = new ArrayList<>();
		list.add(new Time(10, 12));
		list.add(new Time(12, 14));

		list.add(new Time(9, 11));

		list.add(new Time(8, 10));

		list.add(new Time(11, 12));

		list.add(new Time(6, 12));

		System.out.println(classSchedular(list));

	}
}

class Time {
	int startTime;
	int endTime;

	public Time(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

}