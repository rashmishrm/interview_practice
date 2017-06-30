package com.practice.hackerrank;

public class LongestPalindromicSubsequence {

	public static int calculateLPS(String input) {
		int mat[][]= new int[input.length()][input.length()];
	
		for(int i=1;i<=input.length();i++){
			
			for(int j=0;j<=input.length()-i;j++){
				int r= j;
				int c =j+i-1;
				String s= input.substring(j, j+i);
				if(s.length()>1){
				
				if(s.substring(0,1).equals(s.substring(s.length()-1,s.length()))){
					mat[r][c]=2+mat[r+1][c-1];
				}
				else{
					if(j>0)
					mat[r][c] = mat[r][c-1]>mat[r+1][c]?mat[r][c-1]:mat[r+1][c];
					else
						mat[r][c] = 1;
				}
				}else{
					mat[r][c] =1;
				}
				
			}
			
			
			
		}
		
		

		return mat[0][input.length()-1];
	}
	
	public static void main(String[] args) {
		System.out.println(calculateLPS("145931"));
	}

}
