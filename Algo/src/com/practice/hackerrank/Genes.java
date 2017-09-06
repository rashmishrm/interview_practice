package com.practice.hackerrank;

import java.awt.image.ImageProducer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Genes {

	public static boolean oneEdit(String input1, String input2) {

		int counter = 0;

		for (int i = 0; i < input1.length(); i++) {
			char c1 = input1.charAt(i);
			char c2 = input2.charAt(i);

			if (c1 != c2) {
				counter++;
			}
			if (counter > 1) {
				return false;
			}

		}

		return counter == 1;

	}

	static int findMutationDistance(String start, String end, String[] bank) {

		Map<Integer, List<Integer>> adjancylist = new HashMap<Integer, List<Integer>>();
		int startPos = -1;
		int endPos = -1;
		int distance = 0;
		if (start.length() != end.length() || start.length() != 8)
			return -1;

		for (int i = 0; i < bank.length; i++) {

			if (bank[i].equals(start)) {
				startPos = i;
			} else if (startPos == -1 && oneEdit(start, bank[i])) {
				startPos = i;
				distance = 1;
			}

			if (bank[i].equals(end)) {
				endPos = i;
			}
		}

		for (int i = 0; i < bank.length; i++) {

			for (int j = i + 1; j < bank.length; j++) {

				if (oneEdit(bank[i], bank[j])) {
					if (adjancylist.containsKey(i)) {
						adjancylist.get(i).add(j);
					} else {
						List<Integer> list = new ArrayList<Integer>();

						list.add(j);
						adjancylist.put(i, list);

					}
				}

			}

			if (adjancylist.get(i) == null) {
				adjancylist.put(i, new ArrayList<>());
			}

		}

		if (endPos == -1) {
			return -1;
		}

		return shortestDistance(startPos, endPos, adjancylist) + distance;

	}

	public static int shortestDistance(int start, int end, Map<Integer, List<Integer>> adjancylist) {

		Set<Integer> vertices = adjancylist.keySet();
		Set<Integer> visited = new HashSet<Integer>();
		int[] distance = new int[vertices.size() + 1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited.add(start);
		distance[start] = 0;
		a: while (!queue.isEmpty()) {

			int v = queue.poll();

			List<Integer> connected = adjancylist.get(v);
			if (connected != null) {
				for (Integer w : connected) {

					if (!visited.contains(w)) {
						visited.add(w);
						queue.add(w);
						distance[w] = distance[v] + 1;
						if (w == end) {
							break a;
						}
					}

				}
			}

		}

		return distance[end];

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = "output1";
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;
		String _start;
		try {
			_start = in.nextLine();
		} catch (Exception e) {
			_start = null;
		}

		String _end;
		try {
			_end = in.nextLine();
		} catch (Exception e) {
			_end = null;
		}

		int _bank_size = 0;
		_bank_size = Integer.parseInt(in.nextLine().trim());
		String[] _bank = new String[_bank_size];
		String _bank_item;
		for (int _bank_i = 0; _bank_i < _bank_size; _bank_i++) {
			try {
				_bank_item = in.nextLine();
			} catch (Exception e) {
				_bank_item = null;
			}
			_bank[_bank_i] = _bank_item;
		}

		res = findMutationDistance(_start, _end, _bank);
		bw.write(String.valueOf(res));

		System.out.println(res);
		bw.newLine();

		bw.close();
	}
}
