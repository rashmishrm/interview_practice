package com.practice.hackerrank;

import java.util.ArrayList;

public class Phrase {

	  static int maxLength(int[] set, int length) {
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
		subsets.add(new ArrayList<Integer>());
		a: for (int i = 0; i < set.length; i++) {

			ArrayList<ArrayList<Integer>> newsubsets = new ArrayList<>();
			for (ArrayList<Integer> list : subsets) {
				int current = set[i];

				ArrayList<Integer> newList = new ArrayList<Integer>(list);
				newList.add(current);
				int sum = 0;
				for (int l : newList) {
					sum = sum + l;
				}

				

				newsubsets.add(newList);

			}
			subsets.addAll(newsubsets);
		}
		System.out.println(subsets);

		return subsets.get(subsets.size() - 1).size();

	}
	  
	  
	  

	public static void main(String[] args) {
		System.out.println(maxLength(new int[] { 3,1,2,1 },4));
	}
}
