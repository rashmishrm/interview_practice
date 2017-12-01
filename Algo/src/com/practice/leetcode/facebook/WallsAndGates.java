package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
	public void wallsAndGates(int[][] rooms) {

		if (rooms == null || rooms.length == 0) {
			return;
		}



		for (int i = 0; i < rooms.length; i++) {

			for (int j = 0; j < rooms[0].length; j++) {

				if (rooms[i][j] == 0) {
					mark(i, j, rooms.length, rooms[0].length, 0, rooms);
				}

			}

		}

	}

	public void mark(int i, int j, int m, int n, int level, int[][] rooms) {
		if (i < 0 || i >= m || j < 0 || j >= n || rooms[i][j] < level)
			return;
		rooms[i][j] = level;

		mark(i, j + 1, m, n, level + 1, rooms);
		mark(i - 1, j, m, n, level + 1, rooms);
		mark(i + 1, j, m, n, level + 1, rooms);
		mark(i, j - 1, m, n, level + 1, rooms);

	}

	public static void main(String[] args) {
		int[][] mn = { { Integer.MAX_VALUE, -1, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1 },
				{ Integer.MAX_VALUE, -1, Integer.MAX_VALUE, -1 }, { 0, -1, Integer.MAX_VALUE, Integer.MAX_VALUE } };

		new WallsAndGates().wallsAndGates(mn);
		
		System.out.println(mn);

	}
}
