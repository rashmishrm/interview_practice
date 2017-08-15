package com.practice.karumanchi.chapter18_Divide_And_Conquer;

import java.util.Arrays;

public class Q18_Stocks_Pricing {

	public static int stock_price(int n[], int left, int right) {
		int profit = 0;
		
		if (left  >=right) {
			return 0;
		}
		else{
		int mid = left + (right - left) / 2;
		int profit_left = stock_price(n, left, mid);
		int profit_right = stock_price(n, mid + 1, right);

		int min_left = min(n, left, mid);
		int max_right = max(n, mid + 1, right);

		profit = max_right - min_left;
		profit = profit_left > profit ? (profit_left > profit_right ? profit_left : profit_right)
				: (profit > profit_right ? profit : profit_right);
		}
		return profit;

	}

	public static int min(int n[], int low, int high) {
		if(low==high){
			return  n[low];
		}
		int x[] = Arrays.copyOfRange(n, low, high);
		Arrays.sort(x);
		return x[0];

	}

	public static int max(int n[], int low, int high) {
		if(low==high){
			return  n[low];
		}
		int x[] = Arrays.copyOfRange(n, low, high);
		Arrays.sort(x);
		return x[x.length - 1];

	}
	
	public static void main(String[] args) {
		System.out.println(stock_price(new int[]{1,8,10,2,5,4},0,5));
	}

}
