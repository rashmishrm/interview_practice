package com.practice.karumanchi.chapter19;

public class Q_25_Subset_Sum {
	public static int subsetsum(int sum, int[] array) {

		int matrix[][] = new int[array.length + 1][sum + 1];

		for (int i = 1; i < array.length + 1; i++) {
			for (int j = 1; j <= sum; j++) {
				matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - array[i - 1]]);
			}

		}

		return matrix[array.length + 1][sum];

	}

	public static void main(String[] args) {
		System.out.println(subsetsum(17, new int[] { 3, 2, 4, 19, 3, 7, 13, 10, 6, 11 }));
	}
}
