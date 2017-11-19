package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class MyCalendar {

	TreeSet<Event> events = new TreeSet<Event>();

	public MyCalendar() {

	}

	public boolean book(int start, int end) {

		if (events.size() == 0) {
			events.add(new Event(start, end));
			return true;
		}

		boolean added = true;

		for (Event event : events) {

			TreeSet<Event> smallList = new TreeSet<Event>();

			smallList.add(event);
			smallList.add(new Event(start, end));
			Event f = smallList.first();
			Event s = smallList.last();

			if (s.start < f.end) {
				return false;
			}

		}
		if (added) {
			events.add(new Event(start, end));
		}

		return added;
	}

	public static void main(String[] args) {
		int arr[][] = { { 97, 100 }, { 33, 51 }, { 89, 100 }, { 83, 100 }, { 75, 92 }, { 76, 95 }, { 19, 30 },
				{ 53, 63 }, { 8, 23 }, { 18, 37 }, { 87, 100 }, { 83, 100 }, { 54, 67 }, { 35, 48 }, { 58, 75 },
				{ 70, 89 }, { 13, 32 }, { 44, 63 }, { 51, 62 }, { 2, 15 } };
		MyCalendar mc = new MyCalendar();

		for (int i = 0; i < arr.length; i++) {
			System.out.print(mc.book(arr[i][0], arr[i][1]) + ", ");
		}

	}
}

class Event implements Comparable<Event> {
	int start;
	int end;

	public Event(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int compareTo(Event o) {

		return this.start - o.start;
	}

}

/**
 * Your MyCalendar object will be instantiated and called as such: MyCalendar
 * obj = new MyCalendar(); boolean param_1 = obj.book(start,end);
 */