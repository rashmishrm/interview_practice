package com.practice.karumanchi.chapter19;

public class BoardProblem {

	public static int board(int m, int n) {

		if (m == 0 || n == 0) {
			return 1;
		}

		return board(m - 1, n - 1) + board(m - 1, n) + board(m, n - 1);

	}

	public static int board_memo(int m, int n, int mat[][]) {

		if (m == 0 || n == 0) {
			return 1;
		}

		if (mat[m][n] == 0) {
			mat[m][n] = board_memo(m - 1, n - 1,mat) + board_memo(m - 1, n,mat) + board_memo(m, n - 1,mat);
		}

		return mat[m][n];

	}

	public static void main(String[] args) {
		int mat[][] = new int[101][101];
		//System.out.println(board(100, 100));
		System.out.println(board_memo(100, 100, mat));

	}

}
