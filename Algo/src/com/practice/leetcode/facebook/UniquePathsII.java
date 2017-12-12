package com.practice.leetcode.facebook;
//Follow up for "Unique Paths":

//
//Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
//For example,
//There is one obstacle in the middle of a 3x3 grid as illustrated below.
//
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//The total number of unique paths is 2.
//
//Note: m and n will be at most 100.

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
