package com.practice.leetcode;

class PaintFill {
	public int[][] floodFill(int[][] grid, int sr, int sc, int newColor) {

		int r = grid.length;

		if (r <= 0) {
			return grid;
		}
		int c = grid[0].length;

		int newgrid[][] = new int[r][c];

		int startColor = grid[sr][sc];

		int count = 0;

		markIsland(grid, sr, sc, r, c, newColor, startColor, newgrid);

		return grid;
	}

	public void markIsland(int[][] grid, int i, int j, int r, int c, int newcolor, int oldColor, int[][] newgrid) {
		if (i < r && j < c && i >= 0 && j >= 0) {

			if (grid[i][j] == oldColor && newgrid[i][j] != 1) {
				grid[i][j] = newcolor;
				newgrid[i][j] = 1;
				markIsland(grid, i + 1, j, r, c, newcolor, oldColor, newgrid);
				markIsland(grid, i, j + 1, r, c, newcolor, oldColor, newgrid);
				markIsland(grid, i - 1, j, r, c, newcolor, oldColor, newgrid);
				markIsland(grid, i, j - 1, r, c, newcolor, oldColor, newgrid);

			}

		}

	}
}