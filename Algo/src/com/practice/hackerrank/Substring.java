package com.practice.hackerrank;

public class Substring {

	
	
	
	public static int findLongestCommonSubstring(String str1, String str2){
	int output=0;
		char [] array1= str1.toCharArray();
		char [] array2= str2.toCharArray();
		
		int []  []  finalDim= new int [array1.length][array2.length];
		
	
		for(int i=1;i<array1.length;i++){
			for(int j=1;j<array2.length;j++){
				if(array1[i]==array2[j]){
					finalDim[i][j]=finalDim[i-1][j-1]+1;
				}
				else{			
					finalDim[i][j]=Math.max(finalDim[i-1][j], finalDim[i][j-1]);

				}
			}
		}
		
		return finalDim[array1.length-1][array2.length-1];

		
	}
	
	
	public static void main(String[] args) {
		System.out.println(findLongestCommonSubstring("fish", "kishhish"));
	}
	
	
	
}
