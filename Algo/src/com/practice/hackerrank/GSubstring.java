package com.practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//abccdefgh
public class GSubstring {

	public static int maxSubstring(String s) {
		int i = 0;
		Set<Character> set = new HashSet<Character>();
		List<Integer> lengths=new ArrayList<Integer>();
		int count=0;
		for (int x = 0; x < s.length(); x++){
			System.out.println(set);
			Character character=s.charAt(x);
			if (set.contains(character)){
				set = new HashSet<Character>();
				set.add(character);
				lengths.add(count);
				count=1;
			}
			else{
				set.add(character);
				count++;
			}
			
		}
		
		lengths.add(count);
		System.out.println(lengths);
		Collections.sort(lengths);
			
			return lengths.get(lengths.size()-1);

	}

	public static void main(String[] args) {
		System.out.println(maxSubstring("abccdefgh"));
		System.out.println(maxSubstring("abcadbef"));

		System.out.println(maxSubstring("abac"));

		System.out.println(maxSubstring("aaaaa"));

	}

}
