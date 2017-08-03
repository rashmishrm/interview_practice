package com.practice.coremen_book.dynamic;

public class RodCut {

	public static int rodcut_naive(int p[], int n) {

		if (n == 0) {
			return 0;
		}

		int q = 0;
		for (int i = 0; i < n; i++) {
			q = Math.max(q, p[i] + rodcut_naive(p, n - i));
		}

		return q;
	}

	public static int rodcut_memoized(int p[], int n) {

		int memo[] = new int[n + 1];
		return rodcut_memoized(p, n, memo);
	}

	public static int rodcut_memoized(int p[], int n, int memo[]) {

		if (n == 0) {
			return 0;
		}
		if (memo[n] != 0) {
			return memo[n];
		}
		int q = 0;
		for (int i = 1; i <= n; i++) {
			q = Math.max(q, p[i - 1] + rodcut_memoized(p, n - i, memo));
		}
		memo[n] = q;
		return q;
	}

	public static int rodcut_bottom_up(int p[], int n) {
		int memo[]= new int [n+1];
		if (n == 0) {
			return 0;
		}
		if (memo[n] != 0) {
			return memo[n];
		}
		int q = 0;
		for(int i=1;i<=n;i++){
			q = 0;
		for (int j = 1; j <=i; j++) {
			q = Math.max(q, p[j - 1] +memo[i-j]);
		}
		memo[i] = q;

		}
	
		return memo[n];
	}
	
	
	

	public static void main(String[] args) {
		System.out.println(rodcut_memoized(new int[] { 1, 5, 3 }, 3));
		System.out.println(rodcut_bottom_up(new int[] { 1, 5, 3 }, 3));

	}

}
