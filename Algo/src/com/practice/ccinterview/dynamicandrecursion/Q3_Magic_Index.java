package com.practice.ccinterview.dynamicandrecursion;

public class Q3_Magic_Index_Distinct {

	public boolean checkMagic(int n[]) {
		if (n == null || n.length == 0) {
			return false;
		}

	}

	public boolean checkMagic(int n[], int start, int end) {

		if (start < 0 || end < 0 || end > n.length) {
			return false;
		}

		int mid = start + (end - start) / 2;
		if (n[mid] == mid) {
			return true;
		}

		else if (n[mid] > mid) {
			return checkMagic(n, mid + 1, n.length);
		} else {
			return checkMagic(n, 0, mid - 1);
		}

	}

}
