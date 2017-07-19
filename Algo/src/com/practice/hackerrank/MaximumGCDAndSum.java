package com.practice.hackerrank;

import java.util.Scanner;

public class MaximumGCDAndSum {
	static int gcd(int x, int y) {
		int r = 0;
		if ((x < 0) || (y < 0)) {
			r = -1;
		} else {
			if (x != 0 && y != 0) {

				int a = 0, b = 0;
				a = (x > y) ? x : y; // a is greater number
				b = (x < y) ? x : y; // b is smaller number

				r = b;
				while (a % b != 0) {
					r = a % b;
					a = b;
					b = r;
				}

			} else {
				r = x == 0 ? y : x;

			}
		}
		return r;
	}

	static int maximumGcdAndSum(int[] A, int[] B) {

		// Complete this function
		if(A==null ||B==null|| A.length!=B.length || A.length<=0 || B.length<=0){
			return 0;
		}
		int mat[][] = new int[A.length + 1][B.length + 1];

		for (int i = 0; i < A.length; i++) {
			mat[i][0] = 0;
		}

		for (int i = 0; i < B.length; i++) {
			mat[0][i] = 0;
		}
		int sum = 0;
		for (int i = 1; i <= A.length; i++) {
			for (int j = 1; j <= B.length; j++) {
				int gcd = Math.max(Math.max(gcd(A[i - 1], B[j - 1]), mat[i - 1][j]), mat[i][j - 1]);
				if (gcd == -1) {
					sum = -1;
					break;
				}
				mat[i][j] = gcd;
				// System.out.print(mat[i][j]+" ");

			}
		}
		if (sum != -1) {
			// backtracking
			int i = A.length;
			int j = B.length;
			int pair1 = A[A.length - 1];
			int pair2 = B[B.length - 1];

			int max = mat[A.length][B.length];
			// System.out.println(max);
			while (i > 1 && j > 1) {
				if (mat[i - 1][j] == max || mat[i][j - 1] == max) {
					if (mat[i][j - 1] == max) {
						pair1 = A[i - 1];
						pair2 = B[j - 2];
						j = j - 1;

					}
					else if (mat[i - 1][j] == max) {
						pair1 = A[i - 2];
						pair2 = B[j - 1];
						i = i - 1;

					} 
					if (gcd(pair1, pair2) == max) {
						sum = sum < pair1 + pair2 ? pair1 + pair2 : sum;
					}
				} else {
					break;
				}

			}
		} else {
			sum = 0;
		}

		return sum;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int A_i = 0; A_i < n; A_i++) {
			A[A_i] = in.nextInt();
		}
		int[] B = new int[n];
		for (int B_i = 0; B_i < n; B_i++) {
			B[B_i] = in.nextInt();
		}
		int res = maximumGcdAndSum(A, B);
		System.out.println(res);
	}
}
