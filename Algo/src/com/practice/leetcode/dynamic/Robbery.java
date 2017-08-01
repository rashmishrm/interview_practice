package com.practice.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Robbery {

	class House implements Comparable<House> {
		int cash;
		int pos;

		House(int cash, int pos) {
			this.cash = cash;
			this.pos = pos;
		}

		@Override
		public int compareTo(House o) {
			if (this.cash > o.cash) {
				return -1;
			} else if (this.cash < o.cash) {
				return +1;
			}
			return 0;
		}
	}

	public  int rob(int[] nums) {
		int sum = 0;
		if (nums == null || nums.length == 0) {
			return 0;
		}
		List<House> s = new ArrayList<House>();
		int j = 0;
		for (int num : nums) {
			s.add(new House(num, j));
			j++;
		}

		Collections.sort(s);

		sum = s.get(0).cash;
		int prevpos = s.get(0).pos;
		for (int i = 1; i < s.size(); i++) {
			if (!(s.get(i).pos == prevpos + 1 || s.get(i).pos == prevpos - 1)) {
				sum = sum + s.get(i).cash;
				prevpos= s.get(i).pos;
			}

		}
		return sum;

	}
	
	public static void main(String[] args) {
		System.out.println(new Robbery().rob(new int [] {1000,2000,5000,8000,7000}));
	}
}