package com.practice.interviewcake;

import java.util.HashSet;
import java.util.Set;

public class PermutationPalindrome {

	public static boolean isPermutePalin(String s) {
		if (s == null || s.length() == 0 || s.trim().equals("")) {
			return false;
		}

		Set<Character> set = new HashSet<>();

		char[] c = s.toCharArray();

		for (char ec : c) {
			if (set.contains(ec)) {
				set.remove(ec);
			} else {
				set.add(ec);
			}

		}

		return set.size() > 1 ? false : true;

	}
	
	public static void main(String[] args) {
		System.out.println(isPermutePalin("mivicc"));
	}

}
