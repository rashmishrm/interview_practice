package com.practice.leetcode;

public class UniquePaths {

	    
	    public static int uniquePaths(int m, int n) {
	        int[][] mat= new int[m][n];
	        return paths(m-1,n-1,mat);
	    }
	    
	    
	    public static int paths(int i , int j, int[][] mat){
	        if(i<=0 || j<=0){
	            return 1;
	        }
	        else{
	            if(mat[i][j]!=0){
	              return mat[i][j];  
	            }
	            else{
	            mat[i][j]= paths(i-1,j,mat) +paths(i,j-1,mat);
	            
	                return mat[i][j];
	            }
	        }
	        
	    }
	
	    public static void main(String[] args) {
			System.out.println(uniquePaths(1, 2) );
		}
}
