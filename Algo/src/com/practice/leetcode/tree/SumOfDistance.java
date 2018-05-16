package com.practice.leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfDistance {

	public static int[] sumOfDistancesInTree(int N, int[][] edges) {

		Map<Integer, Set<Integer>> map = new HashMap<>();

		for (int i = 0; i < N - 1; i++) {
			Set<Integer> set = new HashSet<>();
			if (map.containsKey(edges[i][0])) {
				set = map.get(edges[i][0]);
			}
			set.add(edges[i][1]);
			map.put(edges[i][0], set);

			Set<Integer> set1 = new HashSet<>();
			if (map.containsKey(edges[i][1])) {
				set1 = map.get(edges[i][1]);
			}
			set1.add(edges[i][0]);
			map.put(edges[i][1], set1);

		}
		Map<String, Integer> distanceCache = new HashMap<>();
	
		int[] suma = new int[N];

		for (int j = 0; j < N; j++) {
			int sum = 0;
			Set<Integer> traversed = new HashSet<>();
			sum = rec(distanceCache, map, j, sum, traversed, 0);
			suma[j] = sum;

		}

		return suma;

	}

	public static int rec(Map<String, Integer> distanceCache, Map<Integer, Set<Integer>> map, int ind, int sum,
			Set<Integer> traversed, int level) {

		Set<Integer> s = map.get(ind);

	//	sum = sum + s.size();
		level = level + 1;
		traversed.add(ind);
		for (Integer seti : s) {
			if (!traversed.contains(seti)) {
				int dist=0;
				if (distanceCache.get(ind + "->" + seti) == null) {
					 dist = rec(distanceCache, map, seti, sum, traversed, level);
					;
					
					distanceCache.put(ind + "->" + seti, dist);
				}
				dist=distanceCache.get(ind + "->" + seti);
				sum = sum  + dist;
			sum=sum+1;

			}
		}

		return sum;
	}

	public static void main(String[] args) {

		int arr[][] = { { 0, 1 }, { 0, 2 }, { 2, 3 }, { 2, 4 }, { 2, 5 } };
		int a[] =sumOfDistancesInTree(6, arr);
		
		for(int aa:a) {
			System.out.println(aa);
		}
	}

}
