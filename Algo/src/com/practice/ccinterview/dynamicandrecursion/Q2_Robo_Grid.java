package com.practice.ccinterview.dynamicandrecursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Point {
	int r = 0;
	int c = 0;

	public Point(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Q2_Robo_Grid {

	public static List<Point> findPath(boolean maze[][]) {
		List<Point> paths = new ArrayList<Point>();
		Set<Point> failed = new HashSet<Point>();

		if (maze == null && maze.length != 0 && maze[0].length != 0) {
			return null;
		}
		int r = maze.length;
		int c = maze[0].length;

		if (r > 0 && c > 0) {
			pathExists(maze, r, c, paths,failed);
		}
		return paths;

	}

	public static boolean pathExists(boolean maze[][], int r, int c, List<Point> path, Set<Point> failed) {

		if (r < 0 || c < 0 || !maze[r][c]) {
			return false;
		}
		Point p = new Point(r, c);
		if (failed.contains(p)) {
			return false;
		}

		if ((r == 0 && c == 0) || pathExists(maze, r - 1, c, path, failed)
				|| pathExists(maze, r, c - 1, path, failed)) {
			path.add(p);
			return true;
		} else {
			failed.add(p);
		}

		return false;

	}

}
