package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;

public class Q6_String_Permutations_unique {

	public static ArrayList<String> permutations(String str) {
		ArrayList<String> perms = new ArrayList<String>();
		perms.add(str.charAt(0) + "");
		for (int i = 1; i < str.length(); i++) {
			String curr = str.charAt(i) + "";
			ArrayList<String> nperms = new ArrayList<String>();
			for (String each : perms) {
				nperms.add(curr+each);
				for (int j = 0; j < each.length(); j++) {
					String news = each.substring(0, j+1) + "" + curr + each.substring(j + 1, each.length());
					nperms.add(news);

				}

			}
			perms = nperms;

		}

		return perms;

	}
	
	public static void main(String[] args) {
		System.out.println(permutations("abcdenio"));
	}

}
