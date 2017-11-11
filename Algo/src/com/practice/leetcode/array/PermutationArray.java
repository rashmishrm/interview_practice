package com.practice.leetcode.array;

public class PermutationArray {

	public int solution(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int sum = 0;
		int indsum = 0;

		int count = 0;
		for (int i = 0; i < A.length; i++) {

			sum += A[i];
			indsum += (i + 1);

			if (sum == indsum) {
				count++;
			}

		}

		return count;

	}

	public static void main(String[] args) {
		int array[] = { 0, 1, 2 };

		System.out.println(new PermutationArray().solution(array));

	}

}
