package com.practice.leetcode.facebook;

public class ReverseWords {
	public static void main(String[] args) {
		char a[] = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
		StringBuilder builder = new StringBuilder();
		int index = 0;
		for (int i = a.length-1; i >= 0 ; i-- ) {
			if (a[i] != ' ') {
				builder.insert(index, a[i]);
			} else {
				builder.append(" ");
				index = builder.length();
			}
		}
		System.out.println(builder.toString());
	}
}