package com.practice.leetcode.dynamic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static boolean wordBreak(String s, List<String> wordDict) {
		boolean canbe = false;
		Set<String> set = new HashSet<>(wordDict);
		if(s.length()==1 && set.contains(s)){
			return true;
		}
		boolean f[]=new boolean[s.length()];
		f[0]=true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String s1 = s.substring(i, j);
				if (f[i]&& set.contains(s1)) {
					f[j]=true;
					break;
				}
			}
		}

		return f[s.length()-1];

	}
	
	public static void main(String[] args) {
		List<String> l= new ArrayList<>();
		l.add("leet");
		l.add("code");
		System.out.println(wordBreak("leetcode",l));
	}
}
