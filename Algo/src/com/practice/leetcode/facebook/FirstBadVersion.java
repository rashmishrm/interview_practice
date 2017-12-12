package com.practice.leetcode.facebook;
//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
//
//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
//
//You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
//
//Credits:
//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.


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
