package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
//Given a string, find the length of the longest substring without repeating characters.
//
//Example 1:
//
//Input: "abcabcbb"
//Output: 3 
//Explanation: The answer is "abc", which the length is 3.
//Example 2:
//
//Input: "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
public class LongestSubstringRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		}
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] array = s.toCharArray();
		int max = 0;
		int start = 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				if (map.get(array[i]) >= start) {
					start = map.get(array[i]) + 1;
				}
			}
			count = i - start + 1;
			if (max < count) {
				max = count;
			}
			map.put(array[i], i);

		}
		return max;
	}
}
