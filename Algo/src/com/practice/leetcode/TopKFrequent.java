package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

	class Elements implements Comparable<Elements> {

		int n;
		int freq;

		public Elements(int n, int freq) {
			super();
			this.n = n;
			this.freq = freq;
		}

		@Override
		public int compareTo(Elements o) {
			// TODO Auto-generated method stub
			return  o.freq -this.freq ;
		}

	}

	public List<Integer> topKFrequent(int[] nums, int k) {

		HashMap<Integer, Integer> counterMap = new HashMap<Integer, Integer>();

		for (int n : nums) {

			if (counterMap.get(n) != null) {
				counterMap.put(n, counterMap.get(n) + 1);
			} else {
				counterMap.put(n, 1);

			}
		}
		PriorityQueue<Elements> heap = new PriorityQueue<>();
		for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
			Elements el = new Elements(entry.getKey(), entry.getValue());
			heap.add(el);
		}

		List<Integer> list = new ArrayList<>(k + 1);

		while (k > 0) {
			list.add(heap.poll().n);

			k--;
		}

		return list;

	}

}
