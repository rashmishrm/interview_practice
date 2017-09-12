package com.practice.leetcode;

public class Islands {
	public static int numIslands(char[][] grid) {
		char hor = '0';
		char ver = '0';

		int islands = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				
				
				
				
				if (j == 0) {
					hor = '0';
				} else {
					hor = grid[i][j - 1];
				}
				if (i == 0) {
					ver = '0';
				} else {
					ver = grid[i - 1][j];
				}
				
				char h, v='0';
				if (j == grid[0].length-1) {
					h = '0';
				} else {
					h = grid[i][j +1];
				}
				if (i == grid.length-1) {
					v = '0';
				} else {
					v = grid[i +1][j];
				}
				
				
				
				if (grid[i][j] == '1' && hor == '0' && ver == '0' && h!='L' &&  v!='L' ) {
					if (i == grid.length-1) 
					grid[i+1][j]='L';
					grid[i][j]='L';
					if (j == grid[0].length-1) 
					grid[i][j+1]='L';
					
					islands++;

				}

			}
		}
		return islands;
	}

	public static void main(String[] args) {
		char[][] grid= new char[][] {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		System.out.println(numIslands(grid));
	}
}
