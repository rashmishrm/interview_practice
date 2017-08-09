package com.practice.ccinterview.sortandsearch;

import java.util.Arrays;

public class Q11_Peaks_And_Valleys {

	public static int[] peaks_and_valleys_with_mem(int[] n) {
		Arrays.sort(n);
		int arr[] = new int[n.length];
		int k = 0;
		for (int i = 0, j = n.length - 1; k < n.length; i++, j--) {
			arr[k] = n[j];
			arr[k + 1] = n[i];
			k = k + 2;
		}
		return arr;

	}

	public static int[] peaks_and_valleys_inplace(int[] n) {
		Arrays.sort(n);
		int k = 0;
		for (int i = 1; i < n.length; i = i + 2) {
			swap(n, i - 1, i);
		}
		return n;

	}

	public static int[] peaks_and_valleys_faster(int[] n) {
		//Arrays.sort(n);
		int k = 0;
		for (int i = 1; i < n.length; i = i + 3) {
			
			int bigIndex= findMaxIndex(n, i-1, i, i+1);
			if(i!=bigIndex)
			swap(n, bigIndex, i);
		}
		return n;

	}

	public static int findMaxIndex(int n[], int i, int j, int k) {

		int maxij = n[i] >= n[j] ? i : j;
		int maxijk = n[maxij] >= n[k] ? maxij : k;
		
		return maxijk;
		

	}

	public static void swap(int[] n, int i, int j) {
		int temp = n[i];
		n[i] = n[j];
		n[j] = temp;
	}

	public static void printArray(int n[]) {
		for (int x : n) {
			System.out.print(x + " , ");
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		int n[] = { 9,1,0,4,8,7 };
		n = peaks_and_valleys_faster(n);
		printArray(n);
	}
}
