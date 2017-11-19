package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingsII {

	public int minMeetingRooms(List<Meeting> meetings) {

		if (meetings == null || meetings.size() == 0) {
			return 0;
		}

		Collections.sort(meetings);

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		Meeting m = meetings.get(0);

		queue.offer(m.endTime);

		int count = 1;

		for (int i = 1; i < meetings.size(); i++) {

			// get currentkly running meeting which will end first
			Integer end = queue.peek();
			Meeting l = meetings.get(i);
			if (end > l.startTime) {
				// meeting is not yet over, need one more conference room
				count++;
				// add new meeting to queue

			} else {

				// remove meeting from queue as it is over.
				queue.poll();
			}
			queue.offer(l.endTime);

		}

		return count;

	}

	public static void main(String[] args) {

		int startTimes[] = { 10, 12, 13 };
		int endTimes[] = { 12, 14, 14 };
		List<Meeting> meetings = new ArrayList<Meeting>();

		for (int i = 0; i < startTimes.length; i++) {
			meetings.add(new Meeting(startTimes[i], endTimes[i]));
		}
		System.out.println(new MeetingsII().minMeetingRooms(meetings));

	}

}
