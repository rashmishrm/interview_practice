package com.practice.ccinterview.sortandsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Q2_String_Anagrams {

	public static void sortStrings(List<String> list) {

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (int i = 0; i < list.size(); i++) {

			String s = list.get(i);
			char[] c = s.toCharArray();
			Arrays.sort(c);

			String sorted = new String(c);

			if (map.get(sorted) == null) {
				List<String> l = new ArrayList<String>();
				map.put(sorted, l);
				l.add(s);
			} else {
				map.get(sorted).add(s);
			}

		}

		Iterator<String> it = map.keySet().iterator();
		list.clear();
		while (it.hasNext()) {
			String s = it.next();
			list.addAll(map.get(s));

		}

	}
	public static void printArray(List<String> n) {
		for (String x : n) {
			System.out.print(x + " , ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		List<String> abc= new ArrayList<>();
		abc.add("def");
		abc.add("jkl");
		abc.add("mno");
		abc.add("lkj");
		
		new Q2_String_Anagrams().sortStrings(abc);
		printArray(abc);
		
	}
	
}
