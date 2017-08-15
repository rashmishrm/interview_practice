package com.practice.karumanchi.chapter18_Divide_And_Conquer;

public class Q15MedianFaster {
	public static int median(int a[], int b[], int h1, int l1, int h2, int l2) {		int median = 0;
		;
		int median1 = 0;
		int median2 = 0;

		if (h1 - l1 == 1) {
			median = (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2;
			return median;
		}

		if (((h1 - l1)+1) % 2 == 0) {
			median1 = (a[l1 + (h1 - l1) / 2] + a[(l1 + (h1 - l1) / 2) + 1]) / 2;

		} else {
			median1 = (a[l1 + (h1 - l1) / 2]);

		}
		if (((h2 - l2)+1) % 2 == 0) {
			median2 = (b[l2 + (h2 - l2) / 2] + b[(l2 + (h2 - l2) / 2) + 1]) / 2;

		} else {
			median2 = (b[l2 + (h1 - l2) / 2]);

		}

		if (median1 == median2) {
			return median1;
		} else if (median1 > median2) {
			return median(a, b, (l1 + (h1 - l1) / 2) + 1, l1, h2, (l2 + (h2 - l2) / 2) + 1);
		} else {
			return median(a, b, h1, (l1 + (h1 - l1) / 2) + 1, (l2 + (h2 - l2) / 2) + 1, l2);

		}

		
	}

	public static void main(String[] args) {
		System.out.println(median(new int[] { 1, 5, 8, 10, 13 }, new int[] { 3, 4, 7, 9, 14 }, 4, 0,4,0));
	}
}
