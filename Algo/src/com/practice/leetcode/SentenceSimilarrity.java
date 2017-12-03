package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarrity {

 	public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {

	Map<String, List<String>> map = new HashMap<String, List<String>>();

	int m = pairs.length;
	 if((words1==null && words2==null) || (words1.length == 0 || words2.length == 0)){
            return true;
        }
	if (words1 == null || words2 == null || words1.length == 0 || words2.length == 0
			|| words1.length != words2.length) {
		return false;
	}

	for (int i = 0; i < m; i++) {
		List<String> one = new ArrayList<String>();
		if (map.get(pairs[i][0]) != null) {
			one = map.get(pairs[i][0]);
		}
		one.add(pairs[i][1]);
		map.put(pairs[i][0], one);

		List<String> two = new ArrayList<String>();
		if (map.get(pairs[i][1]) != null) {
			two = map.get(pairs[i][1]);
		}
		two.add(pairs[i][0]);
		map.put(pairs[i][1], two);

	}

	for (int j = 0; j < words1.length; j++) {
		Set<String> visited = new HashSet<String>();
		visited.add(words1[j]);
        if(!(words1[j].equals(words2[j]))){
		if (!dfs(map, words1[j], words2[j], visited)) {
			return false;
		}
        }

	}

	return true;

}

public boolean dfs(Map<String, List<String>> map, String node, String end, Set<String> visited) {

	if (node == null || map == null || map.get(node) == null) {
		return false;
	}

	if (node.equals(end)) {
		return true;
	}
	boolean found = false;
	for (String neihbor : map.get(node)) {
		if (!visited.contains(neihbor)) {
			visited.add(neihbor);
			found=dfs(map, neihbor, end, visited);
			if(found) {
				break;
			}
			
		}
	}

	return found;
}

	public static void main(String[] args) {
		// String[] words1 = { "great", "acting", "skills" };
		//
		// String[] words2 = { "fine", "drama", "talent" };
		//
		// String[][] pairs = { { "great", "good" }, { "fine", "good" }, { "drama",
		// "acting" }, { "skills", "talent" } };
		//
		String[] words1 = { "an", "extraordinary", "meal" };
		String[] words2 = { "one", "good", "dinner" };
		String[][] pairs = { { "great", "good" }, { "extraordinary", "good" }, { "well", "good" },
				{ "wonderful", "good" }, { "excellent", "good" }, { "fine", "good" }, { "nice", "good" },
				{ "any", "one" }, { "some", "one" }, { "unique", "one" }, { "the", "one" }, { "an", "one" },
				{ "single", "one" }, { "a", "one" }, { "truck", "car" }, { "wagon", "car" }, { "automobile", "car" },
				{ "auto", "car" }, { "vehicle", "car" }, { "entertain", "have" }, { "drink", "have" },
				{ "eat", "have" }, { "take", "have" }, { "fruits", "meal" }, { "brunch", "meal" },
				{ "breakfast", "meal" }, { "food", "meal" }, { "dinner", "meal" }, { "super", "meal" },
				{ "lunch", "meal" }, { "possess", "own" }, { "keep", "own" }, { "have", "own" },
				{ "extremely", "very" }, { "actually", "very" }, { "really", "very" }, { "super", "very" } };

		new SentenceSimilarrity().areSentencesSimilarTwo(words1, words2, pairs);

	}
}
