package com.practice.ccinterview.sortandsearch;

import java.util.List;

public class Q4_Sorted_Search {
	public int findsize(List<Integer> list, int value) {
		int i = 2;
		while (list.get(i) != -1 && value > list.get(i)) {
			i = i * 2;
		}
		return i;

	}
}
