package com.practice.leetcode.facebook;

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
