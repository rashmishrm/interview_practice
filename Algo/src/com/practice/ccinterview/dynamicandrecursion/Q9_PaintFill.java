package com.practice.ccinterview.dynamicandrecursion;

public class Q9_PaintFill {

	public static int[][]  paint(int[][] mat, int x, int y, int color) {

		int maxY = mat.length-1;
		int maxX = mat[0].length-1;

		if (x > maxX || x < 0 || y > maxY || y < 0) {
			return mat;
		}

		if (mat[y][x] != color) {
			mat[y][x] = color;

			paint(mat, x - 1, y, color);
			paint(mat, x + 1, y, color);
			paint(mat, x, y + 1, color);
			paint(mat, x, y - 1, color);
		}

		return mat;

	}
	
	public static void main(String[] args) {
		
		int [][] m= {{1,1,1},{1,1,1}};
		m= paint(m,1,1,2);
		
		System.out.println(paint(m,1,1,2));
	}

}
