package com.practice.leetcode.facebook;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
		int l = 1;
		int h = n;

		while (l <= h) {
			int m = l + (h - l) / 2;

			if (!isBadVersion(m)) {
				l = m + 1;
			} else {
				h = m - 1;
			}

		}

		return l;

	}

	public boolean isBadVersion(int m) {

		return true;

	}
}
