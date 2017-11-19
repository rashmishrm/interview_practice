package com.practice.leetcode.facebook;

public class Divide {
	public int divide(int dividend, int divisor) {

		if (dividend == 0) {
			return 0;
		}
		if (divisor == 0) {
			return Integer.MAX_VALUE;
		}

		int multiplier = 1;
		if ((dividend < 0 && divisor > 0) || (divisor < 0 && dividend > 0)) {
			multiplier = -1;
		}

		int n = 0;
		divisor = Math.abs(divisor);
		dividend = Math.abs(dividend);
		
		if(dividend>Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		while (dividend >= divisor) {
			dividend = dividend - divisor;
			n = n + 1;
		}
		n = multiplier * n;
		return Math.min(Math.max(-2147483648, n), 2147483647);
	}

	public static void main(String[] args) {
		
		new Divide().divide(-2147483648, -1);

	}
}
