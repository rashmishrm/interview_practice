package com.practice.leetcode.facebook;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {

		int r = grid.length;
		if (r <= 0) {
			return 0;
		}
		int c = grid[0].length;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					count++;
				}
				markIsland(grid, i, j, r, c);
			}

		}
		return count;

	}

	public void markIsland(char[][] grid, int i, int j, int r, int c) {
		if (i < r && j < c && i >= 0 && j >= 0) {

			if (grid[i][j] == '1') {
				grid[i][j] = '0';
				markIsland(grid, i + 1, j, r, c);
				markIsland(grid, i, j + 1, r, c);
				markIsland(grid, i - 1, j, r, c);
				markIsland(grid, i, j - 1, r, c);

			}

		}

	}
}
