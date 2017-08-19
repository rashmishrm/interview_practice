package com.practice.karumanchi.chapter19;

public class LongestCommonSubsequence {

	public static int lcs(char a1[], char a2[], int aindex, int bindex) {
		if (aindex > a1.length - 1 || bindex > a2.length - 1) {
			return 0;
		}

		if (a1[aindex] == a2[bindex]) {
			return 1 + lcs(a1, a2, aindex + 1, bindex + 1);
		} else {
			return Math.max(lcs(a1, a2, aindex + 1, bindex), lcs(a1, a2, aindex, bindex + 1));
		}
	}

	public static int lcs_faster_memo(char a1[], char a2[], int aindex, int bindex, int[][] matrix) {
		if (aindex > a1.length - 1 || bindex > a2.length - 1) {
			return 0;
		}

		if (matrix[aindex][bindex] != 0) {
			return matrix[aindex][bindex];
		}
		int count = 0;
		if (a1[aindex] == a2[bindex]) {
			count = 1 + lcs_faster_memo(a1, a2, aindex + 1, bindex + 1, matrix);
		} else {
			count = Math.max(lcs_faster_memo(a1, a2, aindex + 1, bindex, matrix),
					lcs_faster_memo(a1, a2, aindex, bindex + 1, matrix));
		}

		matrix[aindex][bindex] = count;
		return count;
	}

	public static int lcs_faster_memo_iterative(char a1[], char a2[]) {

		int matrix[][] = new int[a1.length + 1][a2.length + 1];

		for (int i = 1; i <= a1.length; i++) {
			for (int j = 1; j <= a2.length; j++) {
				int res = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				if (a1[i - 1] == a2[j - 1]) {
					res = 1 + matrix[i - 1][j - 1];
				}

				matrix[i][j] = res;
				System.out.print(matrix[i][j]);
			}
			System.out.println("");

		}

		return matrix[a1.length][a2.length];
	}

	public static String lcs_faster_memo_iterative_findString(char a1[], char a2[]) {
		String s = "";
		int matrix[][] = new int[a1.length + 1][a2.length + 1];

		for (int i = 1; i <= a1.length; i++) {
			for (int j = 1; j <= a2.length; j++) {
				int res = Math.max(matrix[i][j - 1], matrix[i - 1][j]);
				if (a1[i - 1] == a2[j - 1]) {
					res = 1 + matrix[i - 1][j - 1];
				}

				matrix[i][j] = res;
				// System.out.print(matrix[i][j]);
			}
			// System.out.println("");

		}
		int i = a1.length;
		int j = a2.length;
		while (i >= 1 && j >= 1) {
			if (a1[i-1] == a2[j-1]) {
				i = i - 1;
				j = j - 1;
				s = a1[i] + s;
			} else if (matrix[i][j - 1] >= matrix[i - 1][j]) {
				j = j - 1;
			} else {
				i = i - 1;
			}
		}
		
		return s;

	}

	public static void main(String[] args) {
		String str = "abcbdab";
		String str2 = "bdca";

		System.out.println(lcs(str.toCharArray(), str2.toCharArray(), 0, 0));
		System.out.println(lcs_faster_memo(str.toCharArray(), str2.toCharArray(), 0, 0,
				new int[str.length() + 1][str2.length() + 1]));

		System.out.println(lcs_faster_memo_iterative(str.toCharArray(), str2.toCharArray()));
		System.out.println(lcs_faster_memo_iterative_findString(str.toCharArray(), str2.toCharArray()));

	}
}
