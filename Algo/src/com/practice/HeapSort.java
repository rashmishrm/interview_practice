package com.practice;

/**
 * This program creates Heapsort
 * 
 * @author rashmisharma
 *
 */
public class HeapSort {

	public int[] max_heapyfy(int[] array, int i) {

		int greater = 0;
		int greaterIndex = 0;
		if (((2 * i) + 1) > array.length) {
			greater = array[2 * i];
			greaterIndex = (2 * i);
		}
		else if (array[2 * i] >= array[(2 * i) + 1]) {
			greater = array[2 * i];
			greaterIndex = (2 * i);
		} else {
			greater = array[(2 * i) + 1];
			greaterIndex = (2 * i) + 1;
		}

		if (array[i] < greater) {
			int swap = array[i];
			array[i] = greater;
			array[greaterIndex] = swap;
		}
		return array;

	}

	public int[] create_max_heap(int[] array) {

		for (int i = (array.length-1) / 2; i >= 0; i--) {
			max_heapyfy(array, i);

		}

		return array;

	}

	public static void main(String[] args) {
		int[] array = { 16, 14, 22, 6, 7, 9, 3, 2, 4, 1 };
		
		int[] max_heap= new HeapSort().create_max_heap(array);
		for(int i:max_heap){
			System.out.println(i);
		}
		//System.out.println(new HeapSort().create_max_heap(array));
	}

}
