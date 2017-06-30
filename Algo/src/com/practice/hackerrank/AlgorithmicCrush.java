package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlgorithmicCrush {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		// array1[]= new long[N+1];
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		long s[] = new long[N + 1];
		for (int a0 = 0; a0 < M; a0++) {
			int a = in.nextInt();
			int b = in.nextInt();
			long num = in.nextLong();

			s[a] = s[a] + num;
			if (b + 1 <= N)
				s[b + 1] = s[b + 1] - num;

		}
		long value = 0;
		long result = 0;
		for (int i = 0; i <= N; i++) {
			value += s[i];
			if (value > result) {
				result = value;
			}

		}

		System.out.println(result);
	}
}