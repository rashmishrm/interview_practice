package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//You are given a m x n 2D grid initialized with these three possible values.
//-1 - A wall or an obstacle.
//0 - A gate.
//INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than2147483647.
//Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.
//For example, given the 2D grid:
//INF  -1  0  INF
//INF INF INF  -1
//INF  -1 INF  -1
//  0  -1 INF INF
//After running your function, the 2D grid should be:
//  3  -1   0   1
//  2   2   1  -1
//  1  -1   2  -1
//  0  -1   3   4
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
		for (int i = 0; i < mn.length; i++) {

			for (int j = 0; j < mn[0].length; j++) {

				System.out.print(mn[i][j]+" ");
			}
			System.out.println("");


		}

	}
	
	
	public class Solution {
	    public void wallsAndGates(int[][] rooms) {
	        if (rooms == null || rooms.length == 0) {
	            return;
	        }
	         
	        int m = rooms.length;
	        int n = rooms[0].length;
	         
	        boolean[][] visited = new boolean[m][n];
	         
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (rooms[i][j] == 0) {
	                    wallsAndGatesHelper(i, j, 0, visited, rooms);
	                }
	            }
	        }
	    }
	     
	    private void wallsAndGatesHelper(int row, int col, int distance, boolean[][] visited, int[][] rooms) {
	        int rows = rooms.length;
	        int cols = rooms[0].length;
	         
	        if (row < 0 || row >= rows || col < 0 || col >= cols) {
	            return;
	        }
	         
	        // visited
	        if (visited[row][col]) {
	            return;
	        }
	         
	        // Is wall?
	        if (rooms[row][col] == -1) {
	            return;
	        }
	         
	        // Distance greater than current
	        if (distance > rooms[row][col]) {
	            return;
	        }
	         
	         
	        // Mark as visited
	        visited[row][col] = true;
	         
	        if (distance < rooms[row][col]) {
	            rooms[row][col] = distance;
	        }
	         
	        // go up, down, left and right
	        wallsAndGatesHelper(row - 1, col, distance + 1, visited, rooms);
	        wallsAndGatesHelper(row + 1, col, distance + 1, visited, rooms);
	        wallsAndGatesHelper(row, col - 1, distance + 1, visited, rooms);
	        wallsAndGatesHelper(row, col + 1, distance + 1, visited, rooms);
	         
	        // Mark as unvisited
	        visited[row][col] = false;
	    }
	}
	
	public class Solution1 {
	    public void wallsAndGates(int[][] rooms) {
	        if (rooms == null || rooms.length == 0) {
	            return;
	        }
	         
	        int m = rooms.length;
	        int n = rooms[0].length;
	         
	        Queue<Integer> queue = new LinkedList<>();
	        for (int i = 0; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (rooms[i][j] == 0) {
	                    wallsAndGatesHelper(i, j, 0, rooms, queue);
	                }
	            }
	        }
	    }
	     
	    private void wallsAndGatesHelper(int row, int col, int distance, int[][] rooms, Queue<Integer> queue) {
	        fill(row, col, distance, rooms, queue);
	         
	        int m = rooms.length;
	        int n = rooms[0].length;
	         
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            for (int i = 0; i < size; i++) {
	                int cord = queue.poll();
	                int x = cord / n;
	                int y = cord % n;
	             
	                fill(x - 1, y, distance + 1, rooms, queue);
	                fill(x + 1, y, distance + 1, rooms, queue);
	                fill(x, y - 1, distance + 1, rooms, queue);
	                fill(x, y + 1, distance + 1, rooms, queue);
	             
	            }
	            distance++;
	        }
	    }
	     
	    private void fill (int row, int col, int distance, int[][] rooms, Queue<Integer> queue) {
	        int m = rooms.length;
	        int n = rooms[0].length;
	         
	        if (row < 0 || row >= m || col < 0 || col >= n) {
	            return;
	        }
	         
	        if (rooms[row][col] == -1) {
	            return;
	        }
	         
	        if (distance > rooms[row][col]) {
	            return;
	        }
	         
	        if (distance < rooms[row][col]) {
	            rooms[row][col] = distance;
	        }
	         
	        int cord = row * n + col;
	        queue.offer(cord);
	    }
	}
}
