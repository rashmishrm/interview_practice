package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Meeting implements Comparable<Meeting> {
	int startTime;
	int endTime;

	public Meeting(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;

	}

	public int compareTo(Meeting m) {

		return startTime - m.startTime;

	}

}

public class Meetings {

	public boolean canAttendAllMeetings(List<Meeting> meetings) {

		if (meetings == null || meetings.size() == 0) {
			return false;
		}

		Collections.sort(meetings);

		Meeting m = meetings.get(0);

		for (int i = 1; i < meetings.size(); i++) {

			Meeting next = meetings.get(i);

			if (m.endTime > next.startTime) {

				return false;
			}

			m = next;

		}

		return true;

	}

	public static void main(String[] args) {

		int startTimes[] = { 10, 12, 18, 22 };
		int endTimes[] = { 12, 14, 23, 24 };
		List<Meeting> meetings = new ArrayList<Meeting>();
		for (int i = 0; i < startTimes.length; i++) {
			meetings.add(new Meeting(startTimes[i], endTimes[i]));

		}
		System.out.println(new Meetings().canAttendAllMeetings(meetings));

	}

}
