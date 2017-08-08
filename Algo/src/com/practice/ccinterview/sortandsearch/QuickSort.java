package com.practice.ccinterview.sortandsearch;

public class QuickSort {

	public static int[] qSort(int[] n, int start, int end) {
		
		if(start>end){
			return n;
		}
		
		int pivot = n[start];

		int st = start + 1;
		;

		for (int i = st + 1; i < end; i++) {
			if (n[pivot] > n[i]) {
				int temp = n[st];
				n[st] = n[i];
				n[i] = temp;
				st++;
			}

		}
		int temp = n[pivot];
		n[pivot] = n[st - 1];
		n[st - 1] = temp;
		n= qSort(n, 0, st - 1);
	   // qSort(n, st, end);

		return n;

	}

	public static void main(String[] args) {
		System.out.println(qSort(new int[] { 4, 8, 2, 3, 10, 5, 13, 7 }, 0, 7));

		int n[] = qSort(new int[] { 4, 8, 2, 3, 10, 5, 13, 7 }, 0, 7);
		for (int x : n) {
			System.out.println(x);
		}
	}

}
