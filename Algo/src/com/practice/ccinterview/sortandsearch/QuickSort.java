package com.practice.ccinterview.sortandsearch;

public class QuickSort {

	public static int[] qSort(int[] arr, int left, int right) {
		if (right > left) {
			System.out.println("initial");
			printArray(arr);

			int index = partition(arr, left, right);
			System.out.println("pivot at"+index);
			printArray(arr);
			if (left < index - 1) {
				qSort(arr, left, index - 1);
			}
			if (index < right) {
				qSort(arr, index, right);
			}
		}
		return arr;

	}

	public static int partition(int n[], int start, int end) {
		int pivot = n[(start+end) / 2];

		while (start <= end) {
			while (pivot > n[start])
				start++;
			while (pivot < n[end])
				end--;

			if (start <= end) {
				swap(n, start, end);
				start++;
				end--;
			}

		}

		return start;

	}


public static void printArray(int n[]){
	for (int x : n) {
		System.out.print(x+" , ");
	}
	System.out.println("");
}
	
	
	public static void swap(int[] n, int from, int to) {

		int temp = n[from];
		n[from] = n[to];
		n[to] = temp;
	}

	public static void main(String[] args) {
		//System.out.println(qSort(new int[] { 4, 8, 2, 3, 10, 5, 13, 7 }, 0, 7));

		int n[] = qSort(new int[] { 1,8,9,3,5,4,11,13 }, 0, 7);
		for (int x : n) {
			System.out.print(x);
		}
		System.out.println("");

	}

}
