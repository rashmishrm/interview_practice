package com.practice.leetcode.dynamic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public int removeObstacles(int numRows, int numColumns, List<List<Integer>> lot) {

		if (lot == null) {
			return -1;
		}

		boolean visited[][] = new boolean[numRows][numColumns];
		// Using Queue for Breadth First Search to find Shortest path
		Queue<Position> queue = new LinkedList<Position>();

		queue.offer(new Position(0, 0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {

			Position current = queue.poll();

			// If we have found the obstacle
			if (lot.get(current.row).get(current.column) == 9) {
				return current.distance;
			}

			// add upward position to queue
			if (isValid(current.row-1,current.column,numRows, numColumns, lot, visited)) {
				queue.offer(new Position(current.row - 1, current.column, current.distance + 1));
				visited[current.row - 1][current.column] = true;
			}

			// add downward position to queue	
			if (isValid(current.row+1,current.column,numRows, numColumns, lot, visited)) {
				queue.offer(new Position(current.row + 1, current.column, current.distance + 1));
				visited[current.row + 1][current.column] = true;
			}

			// add left position to queue
			if (isValid(current.row,current.column-1,numRows, numColumns, lot, visited)) {
				queue.offer(new Position(current.row, current.column - 1, current.distance + 1));
				visited[current.row][current.column - 1] = true;
			}
			// add right position to queue
			if (isValid(current.row,current.column+1,numRows, numColumns, lot, visited)) {
				queue.offer(new Position(current.row, current.column + 1, current.distance + 1));
				visited[current.row][current.column + 1] = true;
			}

		}
		return -1;

	}
	
	public boolean isValid( int row, int column,int maxrows,int maxCol, List<List<Integer>> lot, boolean visited[][]) {
		if(row<0 || column <0 || row >= maxrows || column >= maxCol || visited[row][column]==true || lot.get(row).get(column)==0) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> list=  new ArrayList<>();
		List<Integer> f=  new ArrayList<>();
		f.add(1);
		f.add(1);
		f.add(1);
		
		
		List<Integer> s=  new ArrayList<>();
		s.add(1);
		s.add(0);
		s.add(0);
		
		List<Integer> t=  new ArrayList<>();
		t.add(1);
		t.add(9);
		t.add(1);
		
		list.add(f);
		list.add(s);
		list.add(t);
		
		System.out.println( new Solution().removeObstacles(3,3,list));
		
	}

}

class Position {
	int row;
	int column;
	int distance;

	public Position(int row, int column, int distance) {
		super();
		this.row = row;
		this.column = column;
		this.distance = distance;
	}

}
