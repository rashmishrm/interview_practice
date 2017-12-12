package com.practice.leetcode.facebook;

//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
//The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
//How many possible unique paths are there?
public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int grid[][] = new int[m][n];
		return paths(m - 1, n - 1, grid);
	}

	public int paths(int m, int n, int grid[][]) {
		int output = 0;
		if (m == 0 && n == 0) {
			return 1;
		} else if (m < 0 || n < 0) {
			return 0;
		}

		if (grid[m][n] != 0) {
			output = grid[m][n];
		} else {
			output = paths(m - 1, n, grid) + paths(m, n - 1, grid);
			grid[m][n] = output;
		}

		return output;

	}
}
