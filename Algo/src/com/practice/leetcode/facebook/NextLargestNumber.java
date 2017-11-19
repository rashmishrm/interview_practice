package com.practice.leetcode.facebook;

import java.util.Arrays;

public class NextLargestNumber {

	public int[] next(int[] num) {

		boolean val = true;
		int minVal = Integer.MAX_VALUE;

		// find first lowest number from right
		int d = 0;
		int l = 0;
		for (int j = num.length - 1; j > 0; j--) {

			if (num[j] > num[j - 1]) {
				d = j - 1;
				break;
			}

		}
		if (d == 0) {
			return null;
		}

		for (int i = d + 1; i < num.length; i++) {

			if (num[d] < num[i] && num[i] < minVal) {
				minVal = num[i];
				l = i;
			}
		}

		int t = num[d];
		num[d] = num[l];
		num[l] = t;

		Arrays.sort(num, d + 1, num.length);
		for (int o : num) {
			System.out.println(o);
		}
		return num;
	}

	public static void main(String[] args) {
		int l[] = { 5, 3, 4, 9, 7, 6 };
		System.out.println(new NextLargestNumber().next(l));
	}
}
