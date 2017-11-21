package com.practice.leetcode.facebook;

public class MergeSortedArrays {
	public void merge(int[] a, int m, int b[], int n) {

		int acounter = m - 1;
		int bcounter = n - 1;

		int merged = m + n - 1;

		while (bcounter >= 0) {

			if (acounter >= 0 && a[acounter] > b[bcounter]) {
				a[merged] = a[acounter];
				acounter--;
			} else {
				a[merged] = b[bcounter];
				bcounter--;
			}
			merged--;

		}

	}

	public void mergefaster(int[] nums1, int m, int[] nums2, int n) {

		int i1 = m - 1;
		int i2 = n - 1;
		int merged = m + n - 1;

		while (i2 >= 0) {
			if (i1 >= 0 && nums1[i1] > nums2[i2]) {
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
		int a[] = { 3, 6, 14, 22, 27, 0, 0, 0, 0, 0 };
		int b[] = { 2, 4, 5, 6, 19 };
		// new MergeSortedArrays().mergefaster(a, 5, b, 5);
		new MergeSortedArrays().merge(a, 5, b, 5);

		for (int l : a) {
			System.out.println(l);
		}
	}
}
