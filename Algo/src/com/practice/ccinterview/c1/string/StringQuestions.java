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
		
		for(String key:countOne.keySet()){
			if(countTwo.get(key)==null || !countOne.get(key).equals(countTwo.get(key))){
				permutation=false;
			}
		}

		return permutation;

	}

	public static void main(String[] args) {

		System.out.println(isUnique("ba"));
		
		System.out.println(checkPermutation("abc", "cbac"));

	}

}
