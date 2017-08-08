package com.practice.ccinterview.sortandsearch;

public class MergeSortedArrays {
	public void merge(int[] nums1, int m, int[] nums2, int n) {

		int helper[] = new int[m + n];
		for (int i = 0; i < m; i++) {
			helper[i] = nums1[i];
		}

		for (int j = 0; j < n; j++) {
			helper[j + m] = nums2[j];
			nums1[j + m] = nums2[j];
		}

		int hleft = 0;
		int hright = m;
		int current = 0;

		while (hleft <= m - 1 && hright <= (m + n) - 1) {

			if (helper[hleft] < helper[hright]) {
				nums1[current] = helper[hleft];
				hleft++;
			} else if (helper[hleft] >= helper[hright]) {
				nums1[current] = helper[hright];
				hright++;
			}
			current++;

		}

		int remaining = (m - 1) - hleft;
		for (int i = 0; i <= remaining; i++) {
			nums1[current + i] = helper[hleft + i];
		}

	}

	public void mergefaster(int[] nums1, int m, int[] nums2, int n) {

		int i1 = m - 1;
		int i2 = n - 1;
		int merged = m + n - 1;

		while ( i2 >= 0) {
			if (i1>=0 && nums1[i1] > nums2[i2]) {
				nums1[merged] = nums1[i1];
				i1--;
			} else {
				nums1[merged] = nums2[i2];
				i2--;
			}

			merged--;

		}

	}

	public static void main(String[] args) {
		int n[] = new int[] { 1, 2, 3, 0, 0, 0 };
		int n1[] = new int[] { 2, 5, 6 };

		new MergeSortedArrays().mergefaster(n, 3, n1, 3);

		printArray(n);
	}

	public static void printArray(int n[]) {
		for (int x : n) {
			System.out.print(x + " , ");
		}
		System.out.println("");
	}
}
