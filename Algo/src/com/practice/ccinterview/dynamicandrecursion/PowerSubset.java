package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;

public class PowerSubset {

	public static ArrayList<ArrayList<Integer>> findSubSets(int[] set) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<Integer>());

		for (int i = 0; i < set.length; i++) {

			ArrayList<ArrayList<Integer>> newsubsets = new ArrayList<>();
			for (ArrayList<Integer> list : subsets) {
				int current = set[i];

				ArrayList<Integer> newList = new ArrayList<Integer>(list);
				newList.add(current);
				newsubsets.add(newList);
			}
			subsets.addAll(newsubsets);
		}

		return subsets;

	}
	
	public static void main(String[] args) {
		System.out.println(findSubSets(new int[]{1,2,3,4}));
	}

}
