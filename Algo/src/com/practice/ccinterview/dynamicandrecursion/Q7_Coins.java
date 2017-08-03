package com.practice.ccinterview.dynamicandrecursion;

public class Q7_Coins {

	public static int coins(int n) {
		int[][] mat = new int[5][n+1];
		int array[] = { 1, 5, 10, 25 };

		
		
		for(int i=1;i<array.length;i++){
			for(int j=1;j<n+1;j++){
	
				if(array[i-1]>j){
					mat[i][j]=mat[i-1][j];
					
				}
				else if(array[i-1]==j){
					mat[i][j]=mat[i-1][j]+1;
				}
				else{
					if(j-array[i-1] != array[i-1])
					mat[i][j] = mat[i][j-array[i-1]] * mat[i][array[i-1]]; 
					else
						mat[i][j]=mat[i][j-1]+1;
				}
				
				System.out.print(mat[i][j]);
			}
		}
		
		
		
	
		return mat[4][n];

	}
	
	
	
	

	public static void main(String[] args) {
		System.out.println(coins(10));
	}

}
