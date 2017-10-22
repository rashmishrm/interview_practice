package com.practice.karumanchi.chapter17;

import java.util.PriorityQueue;

public class Q1_Merge_Files {

	public static int merge_files(int[] n) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n.length; i++) {
			pq.add(n[i]);
		}
		System.out.println(pq);
		System.out.println(pq);

		int mergeCost = 0;

		while (pq.size() != 1) {

			int one = pq.poll();
			int two = pq.poll();

			mergeCost = mergeCost + one + two;
			pq.add(one + two);

		}

		return mergeCost;

	}

	public static void main(String[] args) {
		System.out.println(merge_files(new int[] { 10, 5, 100, 50, 20, 15 }));
	}
}
