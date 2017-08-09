package com.practice.ccinterview.sortandsearch;

public class Q9_Sorted_Matrix_Search {

	public boolean searchMatrix(int[][] matrix, int n) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int row = 0;
		int col = matrix[0].length - 1;
		while (col >= 0 && row < matrix.length) {
			if (matrix[row][col] == n) {
				return true;
			} else if (matrix[row][col] > n) {
				col--;
			} else if (matrix[row][col] < n) {
				row++;
			}

		}
		return false;

	}

	public static void main(String[] args) {
		System.out.println(new Q9_Sorted_Matrix_Search().searchMatrix(new int[][] { { 1 } }, 0));
	}
}
