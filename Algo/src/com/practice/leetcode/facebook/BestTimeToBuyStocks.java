package com.practice.leetcode.facebook;

public class BestTimeToBuyStocks {
	public int maxProfit(int[] prices) {

		int low = Integer.MAX_VALUE;

		int maxp = 0;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < low) {
				low = prices[i];
			}

			int currp = prices[i] - low;

			if (currp > 0 && currp > maxp) {
				maxp = currp;
			}
		}

		return maxp;

	}
}
