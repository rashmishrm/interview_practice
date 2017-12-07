package com.practice.leetcode.facebook;

public class AddBinary {
	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();

		if (a == null || b == null) {
			return null;
		}

		String big = a.length() > b.length() ? a : b;
		String small = a.length() > b.length() ? b : a;

		int f = big.length() - 1;
		int s = small.length() - 1;
		int carry = 0;
		while (f >= 0) {

			int one = Integer.parseInt(big.charAt(f) + "");
			int two = 0;
			if (s >= 0)
				two = Integer.parseInt(small.charAt(s) + "");

			int sum = one + two + carry;
			if (sum <= 1) {
				carry = 0;
			} else {
				carry = 1;
			}
			if (sum % 2 == 0) {
				result.insert(0, 0);
			} else {

				result.insert(0, 1);
			}

			f--;
			s--;
		}

		if (carry == 1) {
			result.insert(0, 1);
		}

		return result.toString();

	}
}
