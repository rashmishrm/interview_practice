package com.practice.ccinterview.moderate;

import java.util.Arrays;

public class Q6_SmallestDifference {

	public static int smallestDifference(int[] array1, int[] array2) {

		Arrays.sort(array1);
		Arrays.sort(array2);

		int difference = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;

		while (i < array1.length && j < array2.length) {
			int diff = Math.abs(array1[i] - array2[j]);

			if (array1[i] < array2[j]) {
				i++;
			} else if (array1[i] > array2[j]) {
				j++;
			} else {
				return 0;
			}

			difference = Math.min(difference, diff);

		}

		return difference;

	}
	
	public static void main(String[] args) {
		int[] array1 = new int[] {1,3,15,11,2};
		int[] array2 = new int[] {23,127,235,19,8};
		System.out.println(smallestDifference(array1, array2));
		
		int[] array11 = new int[] {1,2,11,15};
		int[] array22 = new int[] {23,12,21,19,14};
		System.out.println(smallestDifference(array11, array22));
		
	}
}
