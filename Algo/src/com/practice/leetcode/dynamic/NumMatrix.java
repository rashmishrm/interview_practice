package com.practice.leetcode.dynamic;

public class NumMatrix {
	int[][] matrix;
	int[][] matrixmem;

	public NumMatrix(int[][] matrix) {
		this.matrix = matrix;
		this.matrixmem = new int[matrix.length][matrix[0].length];
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrixmem.length; j++) {
				sum += matrix[i][j];
				matrixmem[i][j] = sum;
			}
		}

	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if(row1==0 && col1==0){
			return matrixmem[row2][col2];
		}
		else{
			int res=0;
			if(col1==0){
			res=	matrixmem[row2][col2]-matrixmem[row1-1][matrixmem[0].length-1];
			}
			else{
				res=	matrixmem[row2][col2]-matrixmem[row1][col1-1];
	
			}
			
			return res;
			
		}
		
		
		

	}
}