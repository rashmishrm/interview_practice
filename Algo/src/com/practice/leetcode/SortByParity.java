package com.practice.leetcode;

public class SortByParity {
	public int[] sortArrayByParity(int[] A) {
		int o = A.length - 1;
		int e = 0;
		while (e < o) {
			if (A[e] % 2 == 1) {
				int temp = A[e];
				A[e] = A[o];
				A[o] = temp;
				if (A[o] % 2 == 1) {
					e--;
				}
				o--;
			}
			e++;

		}
		return A;

	}
}
