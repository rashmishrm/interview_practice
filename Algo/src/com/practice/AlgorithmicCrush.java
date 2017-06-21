package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AlgorithmicCrush {

	public static long crush(long n, long m, long array[][]) {
		long value = 0;
		Map<Long, List<Long>> more = new HashMap<Long, List<Long>>();
		Map<Long, List<Long>> less = new HashMap<Long, List<Long>>();

		// Set<Integer> indicesSet= new HashSet<Integer>();
		for (int i = 0; i < m; i++) {

	
				if (more.get(array[i][0]) != null) {
					List<Long> list = more.get(array[i][0]);
					list.add(array[i][2]);

				} else {
					List<Long> list = new ArrayList<Long>();
					list.add(array[i][2]);
					more.put(array[i][0], list);
				}
				
				if (less.get(array[i][1]) != null) {
					List<Long> list = less.get(array[i][1]);
					list.add(array[i][2]);

				} else {
					List<Long> list = new ArrayList<Long>();
					list.add(array[i][2]);
					less.put(array[i][1], list);
				}

			

		}
		
		System.out.println(more);	
System.out.println(less);
long moreKey=0;
		for (Long key : more.keySet()) {
			long val = 0;
			for (Long op : more.get(key)) {
				val = val+op;
			}
			//System.out.println("val:"+val+"value:"+value);
			if (val > value) {
				value = val;
				moreKey=key;
			}

		}
System.out.println(moreKey);

long lKey=0;
long value2=0;
for (Long key : less.keySet()) {
	long val = 0;
	for (Long op : less.get(key)) {
		val = val+op;
	}
	//System.out.println("val:"+val+"value:"+value);
	if (val > value2) {
		value2 = val;
		lKey=key;
	}

}
System.out.println(value2);
System.out.println(lKey);

		return value;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();
		long[][] array = new long[M][3];
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		for (int a0 = 0; a0 < M; a0++) {

			for (int a = 0; a < 3; a++) {
				int num = in.nextInt();
				array[a0][a] = num;

			}

		}
		
		System.out.println(crush(N,M,array));
	}

}
