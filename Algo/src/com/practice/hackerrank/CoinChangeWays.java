package com.practice;

import java.util.Scanner;

public class CoinChangeWays {

	public static long minWays(int[] array, int sum) {

		// inititalizations
		long dim[][] = new long[array.length + 1][sum + 1];

		for (int x = 0; x <= array.length; x++)
			dim[x][0] = 0;

		for (int y = 0; y <= sum; y++) {
			dim[0][y] = 0;

			for (int i = 1; i <= array.length; i++) {
				for (int j = 1; j <= sum; j++) {

					if (array[i - 1] > j) {
						dim[i][j] = dim[i - 1][j];
					} else if (array[i - 1] == j) {
						dim[i][j] = dim[i-1][j]+1;
					} else {
						dim[i][j] = dim[i][j - array[i - 1]] + dim[i-1][j];
					}

				}

			}

		}

		return dim[array.length][sum];
	}

	public static void main(String[] args) {
	//	System.out.println(minWays(new int[] { 2,3,5,6 }, 10));
		//System.out.println(minWays(new int[] { 1,2,3}, 4));

		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String array[] = firstLine.split("\\s");
		int sum = Integer.parseInt(array[0]);
		int num = Integer.parseInt(array[1]);
		String secondLine = sc.nextLine();
		String denominations[] = secondLine.split("\\s");
		int denominationsInt[] = new int[denominations.length];
		for (int i = 0; i < denominations.length; i++) {
			denominationsInt[i] = Integer.parseInt(denominations[i]);
		}
		System.out.println(minWays(denominationsInt,sum ));

		sc.close();
		
	}

}
