package com.practice.hackerrank;

public class CoinChange {

	public static int minWays(int[] array, int sum) {

		// inititalizations
		int dim[][] = new int[array.length + 1][sum + 1];

		for (int x = 0; x <= array.length; x++)
			dim[x][0] = 0;

		for (int y = 0; y <= sum; y++) {
			dim[0][y] = 0;
		}

			for (int i = 1; i <= array.length; i++) {
				for (int j = 1; j <= sum; j++) {

					if (array[i - 1] > j) {
						dim[i][j] = dim[i - 1][j];
					} else if (array[i - 1] == j) {
						dim[i][j] = 1;
					} else {
						dim[i][j] = dim[i][j - array[i - 1]] + 1;
					}

				}

			}

		

		return dim[array.length][sum];
	}

	public static void main(String[] args) {
		System.out.println(minWays(new int[] { 1, 2, 3, 4, 5,10,100,500,1000 }, 9000000));
	}

}
