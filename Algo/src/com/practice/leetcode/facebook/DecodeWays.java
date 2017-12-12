package com.practice.leetcode.facebook;

//A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
//Given an encoded message containing digits, determine the total number of ways to decode it.
//
//For example,
//Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
//
//The number of ways decoding "12" is 2.
//




public class DecodeWays {
	public int numDecodings(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
     
        
       int n= s.length();
        int dp[]= new int[n+1];   
        
        //since we have to maintain last count for 2 combo and 1 combo 
        
        dp[0]=1;
        dp[1]=Character.getNumericValue (s.charAt(0))==0?0:1;
        
        for(int i=2;i<=s.length();i++){
            
            int first=Character.getNumericValue (s.charAt(i-1));
            int twonum = Integer.parseInt(s.substring(i-2,i));
            if(first>0 && first<=9){
                dp[i]+=dp[i-1];
            }
            if(twonum >=10 && twonum<27){
               dp[i]+=dp[i-2];  
            }
            
        }
        
        return dp[n];
        
            
        }

	public static void main(String[] args) {
		System.out.println(new DecodeWays().numDecodings("10"));
	}
}
