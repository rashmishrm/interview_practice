package com.practice.karumanchi.chapter18_Divide_And_Conquer;

public class Q11_Find_Infinite_Series {

	public static int findInfiniteSeries(String[] n) {
		int len = 1;
		while (n[len] != "$") {
			len = len * len;
		}

		return len;

	}
}
