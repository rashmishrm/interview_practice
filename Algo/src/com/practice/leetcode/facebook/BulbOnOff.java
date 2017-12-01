package com.practice.leetcode.facebook;

import java.util.ArrayList;

public class BulbOnOff {
	public int bulbs(ArrayList<Integer> a) {
		if (a == null || a.size() == 0) {
			return 0;
		}
		int result = 0;
		boolean flipped = false;

		for (int i = 0; i < a.size(); i++) {
			int curr = a.get(i);

			if ((curr == 0 && !flipped) || (flipped && curr == 1)) {
				result++;

				flipped = !flipped;
			}

		}
		return result;

	}
}
