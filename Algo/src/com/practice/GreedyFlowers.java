package com.practice;

import java.io.*;
import java.util.*;

public class GreedyFlowers {

	public static int calculate(Integer[] costArray, int flowers, int people) {

		int diff = flowers - people;
		Arrays.sort(costArray, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		int price = 0;

		int k = 1;
		int rem = diff % people;
		int j = 0;
		for (j = 0; j < (costArray.length - rem); j = j + people) {

			for (int z = 0; z < people; z++) {
				price = price + ((k) * costArray[j + z]);

			}
			k++;

		}
		j = costArray.length - rem;
		if (rem > 0) {
			for (int z = 0; z < rem; z++) {
				price = price + ((k) * costArray[j + z]);
			}

		}

		return price;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String firstLine = sc.nextLine();
		String array[] = firstLine.split("\\s");
		int flowers = Integer.parseInt(array[0]);
		int people = Integer.parseInt(array[1]);
		String secondLine = sc.nextLine();
		String costArray[] = secondLine.split("\\s");
		Integer intCostArray[] = new Integer[costArray.length];
		for (int i = 0; i < costArray.length; i++) {
			intCostArray[i] = Integer.parseInt(costArray[i]);
		}
		System.out.println(calculate(intCostArray, flowers, people));

		sc.close();
	}
}