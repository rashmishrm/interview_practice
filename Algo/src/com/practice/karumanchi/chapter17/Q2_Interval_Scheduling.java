package com.practice.karumanchi.chapter17;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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

	public static classSchedular(List<Time> list){
		int[] rooms= new int[list.size()];
		Collections.sort(lis
		
	int lastTime= list.get(0).endTime;
		rooms[0]=list.get(0).endTime;
		int numRoom=1;
		
		for(int i=1;i<list.size();i++){
			if(!(list.get(i).startTime>=lastTime)){
			numRoom++;
			}
		}
		
	}

}

class Time implements Comparable<Time> {
	int startTime;
	int endTime;

	public Time(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}

	@Override
	public int compareTo(Time o) {
		if (o.endTime > endTime) {
			return -1;
		} else if (o.endTime < endTime) {
			return 1;
		}
		return 0;
	}

}