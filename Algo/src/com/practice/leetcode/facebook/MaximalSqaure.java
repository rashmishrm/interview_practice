package com.practice.leetcode.facebook;

public class MaximalSqaure {
	public int maximalSquare(char[][] matrix) {

		if (matrix == null || matrix.length == 0)
			return 0;
		int m = matrix.length;
		int n = matrix[0].length;

		int count[][] = new int[m][n];
		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {

				if (i == 0 || j == 0) {
					count[i][j] = matrix[i][j] == '1' ? 1 : 0;

				} else {
					if (matrix[i][j] == '0') {
						count[i][j] = 0;
					} else {
						if ((matrix[i][j - 1] == '0' || matrix[i - 1][j] == '0' || matrix[i - 1][j - 1] == '0')
								&& matrix[i][j] == '1') {
							count[i][j] = 1;
						} else if ((count[i][j - 1] == count[i - 1][j - 1] && count[i - 1][j - 1] == count[i - 1][j])
								&& matrix[i][j] == '1') {

							count[i][j] = count[i - 1][j - 1] + 1;
						}
						// guys around me not the same, I can only be the right-bottom guy of a least
						// square
						else {
							count[i][j] = Math.min(Math.min(count[i - 1][j - 1], count[i - 1][j]), count[i][j - 1]) + 1;
						}
					}

				}

				result = Math.max(result, count[i][j]);

			}
		}

		return result * result;

	}
}
