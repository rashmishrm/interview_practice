package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

		int result = 0;
		Set<String> wordSet = new HashSet<String>(wordList);
		Set<String> visited = new HashSet<>();

		boolean found = false;

		Queue<String> queue = new LinkedList<String>();
		queue.add(beginWord);
		int i = 0;
		while (!queue.isEmpty()) {
			Set<String> temp = new HashSet<String>();
			//System.out.println(queue);
			//System.out.println("****************");

			while (!queue.isEmpty()) {
				String word = queue.poll();
				if (!visited.contains(word)) {
					if (word.equals(endWord)) {
						found = true;
						
						return i+1;
					}
					visited.add(word);
					List<String> list = oneEdit(word, wordSet, false, visited);
					list.removeAll(queue);
					//System.out.println("list for " + word + ":::" + list);
					temp.addAll(list);
				}
			}

			queue.addAll(temp);

			i = i + 1;
		}
		if (found)
			result = i + 1;

		return result;

	}

	public static List<String> oneEdit(String word, Set<String> wordSet, boolean firstMatch, Set<String> visited) {
		String str = "abcdefghijklmnopqrstuvwxyz";
		List<String> list = new ArrayList<String>();

		char[] chs = word.toCharArray();

		for (int j = 0; j < chs.length; j++) {
			for (int i = 0; i < 26; i++) {
				char temp = chs[j];
				chs[j] = str.charAt(i);

				String newWord = new String(chs);
				chs[j] = temp;
				if (!visited.contains(newWord) && wordSet.contains(newWord)) {
					list.add(newWord);

				}

			}

		}
		return list;

	}

	public static void main(String[] args) {
		String array[] = { "hot", "dot", "dog", "lot", "log", "cog" };

		List<String> list = Arrays.asList(array);

		System.out.println(ladderLength("hit", "cog", list));

		String word = "lot";

		String newWord = word.substring(0, 3 - 1) + "g" + word.substring(3, word.length());
		System.out.println(newWord);

	}

}
