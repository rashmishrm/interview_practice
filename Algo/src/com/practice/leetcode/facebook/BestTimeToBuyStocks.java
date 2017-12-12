package com.practice.leetcode.facebook;
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
//
//Example 1:
//Input: [7, 1, 5, 3, 6, 4]
//Output: 5
//
//max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
//Example 2:
//Input: [7, 6, 4, 3, 1]
//Output: 0
//
//In this case, no transaction is done, i.e. max profit = 0.
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
	
	
	
//	Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
//
//			You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction. You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
//
//			Return the maximum profit you can make.
//
//			Example 1:
//			Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
//			Output: 8
//			Explanation: The maximum profit can be achieved by:
//			Buying at prices[0] = 1
//			Selling at prices[3] = 8
//			Buying at prices[4] = 4
//			Selling at prices[5] = 9
//			The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//			Note:
//
//			0 < prices.length <= 50000.
//			0 < prices[i] < 50000.
//			0 <= fee < 50000.
	
	  public int maxProfit(int[] prices, int fee) {
	        if (prices.length <= 1) return 0;
	        int days = prices.length, buy[] = new int[days], sell[] = new int[days];
	        buy[0]=-prices[0];
	        for (int i = 1; i<days; i++) {
	            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]); // keep the same as day i-1, or buy from sell status at day i-1
	            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee); // keep the same as day i-1, or sell from buy status at day i-1
	        }
	        return sell[days - 1];
	    }
}
