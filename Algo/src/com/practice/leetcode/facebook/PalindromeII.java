package com.practice.leetcode.facebook;
//Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
public class PalindromeII {

	public boolean validPalindrome(String s) {

		if (s == null || s.length() == 0) {
			return true;
		}

		char[] array = s.toCharArray();

		int l = 0;
		int h = array.length - 1;
		while (l < h) {

			if (array[l] == array[h]) {
				l++;
				h--;
			} else {
				return isPalindrome(l + 1, h, array) || isPalindrome(l, h - 1, array);
			}

		}

		return true;

	}

	public boolean isPalindrome(int l, int h, char[] array) {
		while (l < h) {

			if (array[l] == array[h]) {
				l++;
				h--;
			} else {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {
		System.out.println(new PalindromeII().validPalindrome(
				"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));

	}

}
