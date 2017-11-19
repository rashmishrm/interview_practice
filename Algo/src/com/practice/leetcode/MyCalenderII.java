package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class MyCalenderII {

	public MyCalenderII() {

	}

	List<Event> events = new ArrayList<Event>();

	public boolean book(int start, int end) {

		if (events.size() == 0) {
			events.add(new Event(start, end));
			return true;
		}
		Collections.sort(events);

		boolean added = true;
		int count = 0;
		for (Event event : events) {

			List<Event> smallList = new ArrayList<Event>();
		

			smallList.add(event);
			smallList.add(new Event(start, end));
			Collections.sort(smallList);
			
			
			Event f = smallList.get(0);
			Event s = smallList.get(1);

			if (s.start < f.end) {

				if (count == 1) {

					return false;
				}
				count++;
			}

		}
		if (added) {
			events.add(new Event(start, end));
		}

		return added;
	}

	public static void main(String[] args) {
		int arr[][] = { { 10, 20 }, { 50, 60 }, { 10, 40 }, { 5, 15 }, { 5, 10 }, { 25, 55 } };
		MyCalenderII mc = new MyCalenderII();

		for (int i = 0; i < arr.length; i++) {
			System.out.print(mc.book(arr[i][0], arr[i][1]) + ", ");
		}

	}

}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo(); boolean param_1 =
 * obj.book(start,end);
 */
