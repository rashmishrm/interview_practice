package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LarryArray {

	public static String[] sort(List<List<Integer>> input) {
		String[] output = new String[input.size()];
		int j = 0;
		for (List<Integer> eachList : input) {
			int count = 0;
			for (int i = 0; i < eachList.size(); i++) {
				count=count+Math.abs(eachList.get(i) - (i + 1));
				

			}

			if ((count) % 2 == 0) {
				output[j] = "NO";
			} else {
				output[j] = "YES";
			}
			System.out.println(output[j]);
			j++;

		}

		return output;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int[] arr = new int[N];
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		for (int a0 = 0; a0 < N; a0++) {
			int num = in.nextInt();
			List<Integer> array = new ArrayList<Integer>();
			for (int a = 0; a < num; a++) {

				array.add(in.nextInt());

			}

			input.add(array);

		}
		sort(input);
	}

}