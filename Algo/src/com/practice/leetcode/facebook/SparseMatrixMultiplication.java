package com.practice.leetcode.facebook;

public class SparseMatrixMultiplication {

	public int[][] multiply(int[][] mat1, int[][] mat2) {

		int rows1 = mat1.length;
		int cols1 = mat1[0].length;

		int rows2 = mat2.length;
		int cols2 = mat2[0].length;

		if (cols1 != rows2) {
			return null;

		}

		int[][] result = new int[rows1][cols2];

		for (int i = 0; i < rows1; i++) {

			for (int j = 0; j < cols2; j++) {

				result[i][j] = 0;

				for (int k = 0; k < rows2; k++) {
					result[i][j] += mat1[i][k] * mat2[k][j];

				}

			}

		}
		return result;
	}
	
	
	
	public int[][] multiply1(int[][] A, int[][] B) {
        int m = A.length, n = A[0].length, nB = B[0].length;
        int[][] C = new int[m][nB];

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0){
                    for (int j = 0; j < nB; j++) {
                        if (B[k][j] != 0) C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;   
    }
	
	
	public static void main(String[] args) {
		
		int mat1[][]= { {1,2,3},{4,5,6}};
		int mat2[][]= {{1,2},{3,4},{4,5}};
		
		
		
		int mat[][]=new SparseMatrixMultiplication().multiply1(mat1, mat2);
		
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[i].length;j++) {
				System.out.print(mat[i][j]+"  ");
			}
			System.out.println();
		}
	}

}
