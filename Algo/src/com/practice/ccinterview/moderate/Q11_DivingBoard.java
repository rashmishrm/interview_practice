package com.practice.ccinterview.moderate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q11_DivingBoard {

	public static Set<Integer> lengths(int k, int shorter, int longer) {

		Set<Integer> set = new HashSet<>();
		Set<String> map = new HashSet<>();
		lengthsrec(k, 0, shorter, longer, set, map);

		return set;

	}

	public static void lengthsrec(int k, int total, int shorter, int longer, Set<Integer> set, Set<String> visited) {

		if (k == 0) {
			set.add(total);
			return;
		}
		String key = (total) + "" + (k);

		if (!visited.contains(key)) {

			lengthsrec(k - 1, total + shorter, shorter, longer, set, visited);

			lengthsrec(k - 1, total + longer, shorter, longer, set, visited);
			visited.add(key);

		}
	}

	public static void main(String[] args) {
		System.out.println(lengths(3, 2, 5));
	}

}
