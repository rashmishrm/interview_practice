package com.practice.leetcode.facebook;

public class Palindrome {

	public boolean isPalindrome(String s) {
		int n = s.length();
		int l = 0;
		int h = n - 1;

		while (l < h) {
			if (!Character.isLetterOrDigit(s.charAt(l)) || !Character.isLetterOrDigit(s.charAt(h))) {
				if (!Character.isLetterOrDigit(s.charAt(l))) {
					l++;

				}
				if (!Character.isLetterOrDigit(s.charAt(h))) {
					h--;

				}

			} else {
				char lo=Character.toLowerCase(s.charAt(l));
				char hi=Character.toLowerCase(s.charAt(h));
				
				if (lo == hi) {
					l++;
					h--;

				} else {
					return false;
				}
			}
		}

		// Character.isLetterOrDigit(string.charAt(index))
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Palindrome().isPalindrome("A man, a plan, a canal: Panama"));
	}
}
