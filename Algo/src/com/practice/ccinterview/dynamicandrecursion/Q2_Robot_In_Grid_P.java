package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;
import java.util.List;

public class Q2_Robot_In_Grid_P {

	public List<SPoint> path(int[][] grid) {

		List<SPoint> path = new ArrayList<>();
		
		

		return null;

	}

	public boolean isPath(int[][] grid, List<SPoint> path, int r, int c) {

		if (r < 0 || c < 0 || grid[r][c] == -1)
			return false;

		SPoint p = new SPoint(r, c);
		path.add(p);
		if (r == 0 && c == 0) {
			return true;
		}

		return isPath(grid, path, r - 1, c) || isPath(grid, path, r, c - 1);

	}

}

class SPoint implements Comparable<SPoint> {
	int r;
	int c;

	public SPoint(int r, int c) {
		this.r = r;
		this.c = c;
	}

	@Override
	public int compareTo(SPoint o) {
		if (o.r - this.r == 0) {
			return o.c - this.c;
		}
		return o.c - this.c;

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return r * 31;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		SPoint s = (SPoint) obj;

		return this.r == s.r && this.c == s.c;
	}

}