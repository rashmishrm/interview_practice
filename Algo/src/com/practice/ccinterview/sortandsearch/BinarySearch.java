package com.practice.ccinterview.sortandsearch;

public class BinarySearch {

	public boolean bsearch_recursive(int n[], int elem) {
		return search_recursive(n, 0, n.length - 1, elem);
	}

	public boolean search_recursive(int n[], int start, int end, int elem) {
		if (start > end) {
			return false;
		}

		int mid = start + ((end - start) / 2);

		if (n[mid] == elem) {
			return true;
		}

		if (elem < n[mid]) {
			return search_recursive(n, 0, mid - 1, elem);
		} else {
			return search_recursive(n, mid + 1, end, elem);

		}

	}

	public boolean search_iterative(int n[], int elem) {

		int low = 0;
		int high = n.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = ((n.length - 1) / 2);
			if (n[mid] == elem) {
				return true;

			}
			if (elem < n[mid]) {
				high = mid - 1;

			} else {
				low = mid + 1;
			}
		}
			return false;
		

		

	}

	public static void main(String[] args) {
		int n[] = new int[] { 1, 2, 3, 4, 5, 6 };

		System.out.println(new BinarySearch().bsearch_recursive(n, 8));
		System.out.println(new BinarySearch().search_iterative(n, 3));
		
	}
}
