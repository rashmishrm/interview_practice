package com.practice.ccinterview.sortandsearch;

public class Q5_SparsedSearch {

	public int search(String[] array) {
		return search_recursive(array, 0, array.length - 1, "ball");

	}

	public int search_recursive(String n[], int start, int end, String elem) {
		if (start > end) {
			return -1;

		}

		int mid = start + ((end - start) / 2);

		if (n[mid].equals("")) {

			int left = mid - 1;
			int right = mid + 1;
			while (true) {
				if (n[left].equals("")) {
					left--;
				} else {
					mid = left;
					break;
				}

				if (n[right].equals("")) {
					right++;
				} else {
					mid = right;
					break;
				}

			}

		}

		if (n[mid].equals(elem)) {
			return mid;
		}

		if (elem.compareTo(n[mid]) > 1) {
			return search_recursive(n, 0, mid - 1, elem);
		} else {
			return search_recursive(n, mid + 1, end, elem);

		}

	}

}
