package com.practice.leetcode.dynamic;

public class MinPathSum {
	public int minPathSumrec(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		minPathSum(grid, grid.length - 1, grid[0].length - 1);
		return grid[grid.length - 1][grid[0].length - 1];

	}

	public int minPathSum(int[][] grid, int i, int j) {

		if (i < 0 || j < 0) {
			return -1;

		}
		int a = 0;
		int b = 0;
		if (i > 0) {
			a = minPathSum(grid, i - 1, j);
		}

		if (j > 0) {
			b = minPathSum(grid, i, j - 1);
		}

		int c = (a != 0 && b != 0) ? Math.min(a, b) : a > 0 ? a : b;

		grid[i][j] = grid[i][j] + c;

		return grid[i][j];

	}

	public static void main(String[] args) {
		int[][] mn = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 }

		};

		// int[][] mn = { { 1, 3 }, { 1, 5 }
		//
		// };
		System.out.println(new MinPathSum().minPathSum(mn));
	}

	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {

				if (i == 0 && j > 0) {
					grid[i][j] = grid[i][j] + grid[i][j - 1];
				}

				else if (j == 0 && i > 0) {
					grid[i][j] = grid[i][j] + grid[i - 1][j];

				} else if (i != 0 && j != 0) {
					grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
				}

			}

		}

		return grid[m - 1][n - 1];
	}

}
