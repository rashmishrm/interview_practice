package com.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DynamicLongestPalindromicSubsequence {

	public static int calculateLPS(List<Integer> input, Map<Integer, Set<Integer>> txfrmtaions) {
		int mat[][] = new int[input.size()][input.size()];

		for (int i = 1; i <= input.size(); i++) {

			for (int j = 0; j <= input.size() - i; j++) {
				int r = j;
				int c = j + i - 1;
				List<Integer> s = input.subList(j, j + i);

				if (s.size() > 1) {
					int first = s.get(0);
					int last = s.get(s.size() - 1);
					System.out.println(first+":::"+last);
					Set<Integer> firstSet = txfrmtaions.get(first);
					System.out.println(firstSet);
					Set<Integer> secondSet = txfrmtaions.get(last);
				
					System.out.println(secondSet);
					Set<Integer> newSet= new HashSet<Integer>();
					newSet.addAll(firstSet);
					
					
					newSet.retainAll(secondSet);
					
					System.out.println(newSet);
					if (s.get(0).equals(s.get(s.size() - 1)) || newSet.size() > 0) {
						mat[r][c] = 2 + mat[r + 1][c - 1];
					} else {
						if (j > 0) {

							mat[r][c] = mat[r][c - 1] > mat[r + 1][c] ? mat[r][c - 1] : mat[r + 1][c];
						} else {
							mat[r][c] = 1;
						}
					}
				} else {
					mat[r][c] = 1;
				}
				System.out.println("List::::"+s);
				System.out.println("matrix: "+"r: "+r+"c: "+c+":: :: "+mat[r][c]);

			}

		}

		return mat[0][input.size() - 1];
	}

	public static Map<Integer, Set<Integer>> tranform(Map<Integer, Integer> map) {
		Map<Integer, Set<Integer>> txfrmtaions = new HashMap<Integer, Set<Integer>>();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (txfrmtaions.get(entry.getKey()) != null) {
				Set<Integer> set = txfrmtaions.get(entry.getKey());
				set.add(entry.getValue());
			} else {
				Set<Integer> set = new HashSet<Integer>();

				set.add(entry.getValue());
				txfrmtaions.put(entry.getKey(), set);

			}

			if (txfrmtaions.get(entry.getValue()) != null) {
				Set<Integer> set = txfrmtaions.get(entry.getValue());
				set.add(entry.getKey());
			} else {
				Set<Integer> set = new HashSet<Integer>();

				set.add(entry.getKey());
				txfrmtaions.put(entry.getValue(), set);

			}

		}
		
		for(Map.Entry<Integer, Set<Integer>> entry : txfrmtaions.entrySet()){
			Set<Integer> set= new HashSet<Integer>();
			entry.getValue().stream().forEach(v->{
				
				set.addAll(txfrmtaions.get(v));
				
			});
			
			entry.getValue().addAll(set);
		}

		return txfrmtaions;
	}

	public static void main(String[] args) {
		Map<Integer, Integer> map= new HashMap<>();
		   Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        int k = in.nextInt();
	        int m = in.nextInt();
	        for(int a0 = 0; a0 < k; a0++){
	            int x = in.nextInt();
	            int y = in.nextInt();
	            map.put(x, y);
	        }
	        
	        Map<Integer, Set<Integer>> txfrmations= tranform(map);
	       System.out.println(txfrmations);
	        int[] a = new int[m];
	        List<Integer> list= new ArrayList<Integer>();
	        for(int a_i=0; a_i < m; a_i++){
	            a[a_i] = in.nextInt();
	            list.add(a[a_i]);
	        }
	        
	        System.out.println(calculateLPS(list,txfrmations));
	        
	}

}
