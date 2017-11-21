package com.practice.leetcode.facebook;

public class OneEdit {

	public boolean oneEdit(String a, String b) {

		int m = a.length();
		int n = b.length();

		if (m - n > 1) {
			return false;
		}

		int count = 0;
		int i = 0;

		if (m == n) {
			// replace
			int same = m;
			i = 0;
			while (a.charAt(i) == b.charAt(i))
				same--;

			if (same > 1) {
				return false;
			}

		} else {
			// delete /insert

		}

		return false;
	}

	boolean oneEditAway(String first, String second) {
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		/* Get shorter and longer string. */
		String s1 = first.length() < second.length() ? first : second;
		String s2 = first.length() < second.length() ? second : first;
		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;

		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {

				if (foundDifference)
					return false;
				foundDifference = true;
				if (s1.length() == s2.length()) {
					index1++;
				}
			} else {
				index1++;
			}
			index2++;
		}
		return true;
	}

}
