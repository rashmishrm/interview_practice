package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeamForm {

	public static int minTeam(List<Integer> inputs, int nc) {
		int minSize = -1;

		if (nc == 0) {
			minSize = 0;
			return minSize;
		}

		Collections.sort(inputs);

		int size = 1;
		int previous = inputs.get(0);
		
		for (int i = 1; i < inputs.size(); i++) {
			int current = inputs.get(i);
			if (current - previous > 1 ) {
				if (minSize > size || minSize == -1) {
					minSize = size;
				}
				size = 1;			} 
			else if (current - previous == 1) {
				size++;
			}
			else if (current - previous == 0) {

			}
			previous = current;
		}
		if(minSize==-1 ){
			minSize=size;
		}
		
		
		return minSize;

	}

	public static void main(String[] args) {

		// System.out.println(minTeam(Arrays.asList(new Integer[] { 7, 1, -2,
		// -3, -4, 2, 0, -1 })));
		// System.out.println(minTeam(Arrays.asList(new Integer[] { 4, 3, 2, 3,
		// 1 })));
		Scanner sc = new Scanner(System.in);

		int num = Integer.parseInt(sc.nextLine().trim());
		List<List<Integer>> inputs = new ArrayList<List<Integer>>();
		while (num > 0) {
			String secondLine = sc.nextLine();
			String costArray[] = secondLine.split("\\s");
			int nc = Integer.parseInt(costArray[0]);
			List<Integer> intCostArray = new ArrayList<Integer>();
			for (int i = 1; i < costArray.length; i++) {
				intCostArray.add(Integer.parseInt(costArray[i]));
			}
			inputs.add(intCostArray);
			num--;
		}

		for (List<Integer> eachList : inputs) {
			System.out.println(minTeam(eachList, eachList.size()));

		}

	}

}
