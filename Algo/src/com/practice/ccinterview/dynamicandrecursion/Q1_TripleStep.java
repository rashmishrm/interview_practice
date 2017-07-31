package com.practice.ccinterview.dynamicandrecursion;

import java.util.HashMap;

public class Q1_TripleStep {

	public static int countStepsC(int n) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		return countSteps(n, map);
	}

	public static int countSteps(int n, HashMap<Integer, Integer> map) {

		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		if (map.get(n) != null) {
			return map.get(n);
		}
		int ways = countSteps(n - 1, map) + countSteps(n - 2, map) + countSteps(n - 3, map);
		map.put(n, ways);

		return ways;

	}

	public static void main(String[] args) {
		System.out.println(countStepsC(3));
	}

}
