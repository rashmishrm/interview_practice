package com.practice.leetcode;

public class GameOfLife {

	public void gameOfLife(int[][] board) {
		int row = board.length;
		int col = board[0].length;
		int[][] boardupdate = new int[row][col];
		if (row > 4 && col > 4) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {

					int lifeCount = 0;
					int status = 0;
					if (i != 0 && j != 0 && i != row - 1 && j != col - 1) {

						lifeCount = board[i - 1][j - 1] + board[i + 1][j - 1] + board[i - 1][j + 1]
								+ board[i + 1][j + 1] + board[i][j - 1] + board[i - 1][j] + board[i][j + 1]
								+ board[i + 1][j];

					}

					if (board[i][j] == 1 && (lifeCount == 2 || lifeCount == 3)) {
						status = 1;
					}
					if (board[i][j] == 0 && (lifeCount == 3)) {
						status = 1;
					}

					boardupdate[i][j] = status;
				}

			}
		}
	}

}
