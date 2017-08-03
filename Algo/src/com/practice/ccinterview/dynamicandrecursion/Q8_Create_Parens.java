package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q8_Create_Parens {

	public static List<String> parens(int n) {
		List<String> result = new ArrayList<String>();
		if (n > 0) {
			result.add("()");
		}
		for (int i = 2; i <= n; i++) {
			Set<String> nresult = new HashSet<String>();

			for (String r : result) {
				nresult.add("()" + r);
				nresult.add(r + "()");
				nresult.add("(" + r + ")");

			}

			result=new ArrayList(nresult);
		}

		return result;
	}

	
	public static void main(String[] args) {
		System.out.println(parens(3));
	}
}
