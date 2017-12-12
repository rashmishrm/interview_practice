package com.practice.leetcode.facebook;


//The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//1 is read off as "one 1" or 11.
//11 is read off as "two 1s" or 21.
//21 is read off as "one 2, then one 1" or 1211.
//Given an integer n, generate the nth term of the count-and-say sequence.
//
//Note: Each term of the sequence of integers will be represented as a string.
//
//Example 1:
//
//Input: 1
//Output: "1"
//Example 2:
//
//Input: 4
//Output: "1211"


public class CountAndSay {
	public String countAndSay(int n) {

		String previous = "11";
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";

		for (int i = 3; i <= n; i++) {
			char prevdigit = previous.charAt(0);
			int count = 1;
			String newCurr = "";
			for (int j = 1; j < previous.length(); j++) {
				if (previous.charAt(j) == prevdigit) {
					count++;
				} else {
					newCurr = newCurr + count + previous.charAt(j - 1);
					count = 1;
				}
				prevdigit = previous.charAt(j);
			}
			if (count > 0) {
				newCurr = newCurr + count + previous.charAt(previous.length() - 1);
			}

			previous = newCurr;

		}

		return previous;

	}

}
