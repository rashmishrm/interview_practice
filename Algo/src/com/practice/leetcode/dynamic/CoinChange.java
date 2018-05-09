package com.practice.leetcode.dynamic;

public class CoinChange {
	  public static int coinChange(int[] coins, int amount) {
	        
	        int matrix[][] = new int[coins.length+1][amount+1];
	        
	        
	        
	        
	        for(int i=1;i<coins.length+1;i++){
	            for(int j=0; j< amount+1;j++){
	                
	                if(coins[i-1]<= j){
	                    matrix[i][j]=matrix[i][j-coins[i-1]]+1;
	                    
	                }
	                else{
	                    matrix[i][j]=matrix[i-1][j]; 
	                }
	            }
	        }
	        
	        return matrix[coins.length][amount]<=0?-1:matrix[coins.length][amount];
	        
	    }
	 
	 public static void main(String[] args) {
		
		 int coins[]= {2};
		 System.out.println(coinChange(coins, 3));
		 
		 
		 
	}
}
