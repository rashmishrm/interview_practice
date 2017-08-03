package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q7_Perm_Non_dup {
	public static ArrayList<String> permutations(String str) {
		ArrayList<String> perms = new ArrayList<String>();
		perms.add(str.charAt(0) + "");
		for (int i = 1; i < str.length(); i++) {
			String curr = str.charAt(i) + "";
			Set<String> nperms = new HashSet<String>();
			for (String each : perms) {
				nperms.add(curr + each);
				for (int j = 0; j < each.length(); j++) {
					String news = each.substring(0, j + 1) + "" + curr + each.substring(j + 1, each.length());
					nperms.add(news);

				}

			}
			perms = new ArrayList<String>(nperms);

		}

		return perms;

	}

	static void  printPerms(Map<Character, Integer> map, String prefix, int remaining, ArrayList<String> result) {
		/* Base case. Permutation has been completed. */
		System.out.println("Called : "+ map+ "prefix: "+prefix +"   : remaining: "+remaining+" result:"+result);

		if (remaining == 0) {
			result.add(prefix);
			return;
		}

		for (Character c : map.keySet()) {

			int count = map.get(c);

			if (count > 0) {
				System.out.println("In for loop  : "+ map+ "prefix: "+prefix +"  :: remaining: "+remaining+" result:"+result);

				map.put(c, count - 1);

				printPerms(map, prefix + c, remaining - 1, result);

				map.put(c, count);
			}
		}
	}

	public static ArrayList<String> permutations_faster(String str) {
		ArrayList<String> perms = new ArrayList<String>();
		perms.add(str.charAt(0) + "");
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			Character key = str.charAt(i);
			if (!map.containsKey(key)) {
				map.put(key, 1);
			} else {
				map.put(key, map.get(key) + 1);
			}
		}
		ArrayList<String> result = new ArrayList<String>(); 
		printPerms(map, "", str.length(), result);
		return result;
	

	}

	public static void main(String[] args) {
		System.out.println(permutations_faster("aabc"));
	}
}
