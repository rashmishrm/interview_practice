package com.practice.ccinterview.c1.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringQuestions {

	public static boolean isUnique(String str) {
		char[] c = str.toCharArray();
		Arrays.sort(c);
		boolean unique = false;

		char previous = 0;
		for (int i = 0; i < c.length; i++) {

			if (c[i] == previous) {
				unique = true;
				break;
			}
			previous = c[i];

		}

		return unique;

	}

	public static boolean checkPermutation(String one, String two) {
		boolean permutation = true;

		Map<String, Integer> countOne = new HashMap<String, Integer>();
		Map<String, Integer> countTwo = new HashMap<String, Integer>();

		for (int i = 0; i < one.length(); i++) {
			String s = one.charAt(i) + "";

			if (countOne.get(s) == null) {
				countOne.put(s, 1);
			} else {
				int count = countOne.get(s) + 1;
				countOne.put(s, count);
			}
		}

		for (int i = 0; i < two.length(); i++) {
			String s = two.charAt(i) + "";

			if (countTwo.get(s) == null) {
				countTwo.put(s, 1);
			} else {
				int count = countTwo.get(s) + 1;
				countTwo.put(s, count);
			}
		}

		for (String key : countOne.keySet()) {
			if (countTwo.get(key) == null || !countOne.get(key).equals(countTwo.get(key))) {
				permutation = false;
			}
		}

		return permutation;

	}

	public static boolean checkPermutationIsPalin(String input) {
		boolean p = false;
		Map<String, Integer> countOne = new HashMap<String, Integer>();
		for (int i = 0; i < input.length(); i++) {
			String s = input.charAt(i) + "";

			if (countOne.get(s) == null) {
				countOne.put(s, 1);
			} else {
				int count = countOne.get(s) + 1;
				countOne.put(s, count);
			}
		}
		boolean foundOdd = false;

		int eventCount = 0;
		int oddCount = 0;
		for (String key : countOne.keySet()) {
			if (countOne.get(key) % 2 != 0) {

				oddCount++;

				if (oddCount > 1) {
					break;
				}
			} else {
				eventCount++;
			}

		}
		System.out.println(eventCount);
		System.out.println(oddCount);
		if (2 * eventCount == input.length() - 1 && oddCount == 1) {
			p = true;
		}

		return p;

	}

	public static boolean oneEdit(String input1, String input2) {
		boolean oneDit = true;
		int oneLen = input1.length();
		int twolen = input2.length();

		
		
		if (Math.abs(oneLen - twolen) > 1) {
			oneDit = false;
			return false;
		}

		Map<String, Integer> countOne = new HashMap<String, Integer>();
		Map<String, Integer> countTwo = new HashMap<String, Integer>();

		for (int i = 0; i < input1.length(); i++) {
			String s = input1.charAt(i) + "";

			if (countOne.get(s) == null) {
				countOne.put(s, 1);
			} else {
				int count = countOne.get(s) + 1;
				countOne.put(s, count);
			}
		}

		for (int i = 0; i < input2.length(); i++) {
			String s = input2.charAt(i) + "";

			if (countTwo.get(s) == null) {
				countTwo.put(s, 1);
			} else {
				int count = countTwo.get(s) + 1;
				countTwo.put(s, count);
			}
		}

		int notFoundCount=0;
		for (String key : countOne.keySet()) {

			if(countTwo.get(key)==null){
				notFoundCount++;
				
				if(notFoundCount>1){
					oneDit=false;	
				}
			}
			if (countTwo.get(key) == null && countOne.get(key) > 1) {
				oneDit = false;
			} else if (countTwo.get(key) != null && Math.abs(countOne.get(key) - countTwo.get(key)) > 1) {

				oneDit = false;

			}

		}

		return oneDit;

	}

	public static void main(String[] args) {

		System.out.println(isUnique("ba"));

		System.out.println(checkPermutation("abc", "cbac"));

		System.out.println(checkPermutationIsPalin("abcba"));
		
		System.out.println(oneEdit("fakeriam","fakelia"));

	}

}
