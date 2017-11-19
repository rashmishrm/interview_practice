package com.practice.leetcode.facebook;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int grid[][] = new int[m][n];
		return paths(m - 1, n - 1, grid, obstacleGrid);
		
	}

	public int paths(int m, int n, int grid[][], int[][] obstacleGrid) {
		int output = 0;

		if (m == 0 && n == 0 && obstacleGrid[m][n] != 1) {
			return 1;
		} else if (m < 0 || n < 0) {
			return 0;
		}
		if (obstacleGrid[m][n] == 1) {
			return 0;
		}

		if (grid[m][n] != 0) {
			output = grid[m][n];
		} else {
			output = paths(m - 1, n, grid, obstacleGrid) + paths(m, n - 1, grid, obstacleGrid);
			grid[m][n] = output;
		}

		return output;

	}
}
