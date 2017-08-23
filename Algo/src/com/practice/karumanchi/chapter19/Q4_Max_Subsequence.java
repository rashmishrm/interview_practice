package com.practice.karumanchi.chapter19;

public class Q4_Max_Subsequence {

	public static int max_sum(int a[]) {
		int sum = 0;
		int m[] = new int[a.length];

		for (int i = 1; i < a.length; i++) {
			if (m[i - 1] + a[i] > 0) {
				m[i] = m[i - 1] + a[i];
			} else {
				m[i] = 0;
			}
		}

		int msum = 0;
		for (int i = 0; i < m.length; i++) {
			sum = m[i];
			if (msum < sum) {
				msum = sum;
			}
		}

		return msum;

	}

	public static void main(String[] args) {
		System.out.println(max_sum(new int[] { -2, 11, -4, 13, -5, 2 }));
	}
}
