package com.practice.leetcode.facebook;

public class WordSearch {

	boolean visited[][] = null;

	public boolean exist(char[][] board, String word) {

		if (board == null || board.length == 0) {
			return false;
		}
		int m = board.length;
		int n = board[0].length;
		visited = new boolean[m][n];
		char wordarr[] = word.toCharArray();
		int p = 0;
		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {
				if (board[i][j] == wordarr[p]) {
					boolean found = search(board, m, n, wordarr, i, j, p);
					if (found)
						return true;
				}
			}
		}
		return false;

	}

	public boolean search(char[][] board, int m, int n, char word[], int i, int j, int p) {

		if (p == word.length) {
			return true;
		}

		if (i < 0 || j < 0 || i >= m || j >= n || p > word.length || word[p] != board[i][j] || visited[i][j]) {
			return false;
		}

		visited[i][j] = true;

		if (search(board, m, n, word, i, j + 1, p + 1) || search(board, m, n, word, i + 1, j, p + 1)
				|| search(board, m, n, word, i, j - 1, p + 1) || search(board, m, n, word, i - 1, j, p + 1))
			return true;

		visited[i][j] = false;
		return false;

	}
}
