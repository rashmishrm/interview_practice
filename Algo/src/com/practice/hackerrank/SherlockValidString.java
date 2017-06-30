package com.practice.hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockValidString {

	static String isValid(String s) {
		int totalCount = s.length();
		
		Map<String, Integer> countOne = new HashMap<String, Integer>();
		for (int i = 0; i < s.length(); i++) {
			String s1 = s.charAt(i) + "";

			if (countOne.get(s1) == null) {
				countOne.put(s1, 1);
			} else {
				int count = countOne.get(s1) + 1;
				countOne.put(s1, count);

			}
		}
		
		int count=0;
		int diffCount=0;
		Set<Integer> counts= new HashSet<Integer>();
		counts.addAll(countOne.values());
		
System.out.println(countOne);
		if (counts.size()!=1 && totalCount%countOne.size() > 1 && !counts.contains(1) || countOne.size()%counts.size()>1 ) {
			return "NO";
		}
		
		
		return "YES";

		// Complete this function
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = isValid(s);
		System.out.println(result);
	}
}