package com.practice.leetcode;

public class WildCardMatch {
	 public boolean isMatch(String s, String p) {
	        

	        if(s==null || p==null){
	            return false;
	        }
	        
	        boolean[][] memo = new boolean[s.length()+1][p.length()+1];
	        memo[0][0]=true;
	        
	        for(int pt=0;pt<p.length();pt++){
	            if(p.charAt(pt)=='*'){
	                memo[0][pt+1]=true;
	            }
	            else{
	                break;
	            }
	        }
	            
	        for(int i=0;i<s.length();i++){
	            for(int j=0;j<p.length();j++){
	                
	               if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
	                    memo[i+1][j+1] = memo[i][j];
	               } 
	               else if(p.charAt(j)=='*'){
	                   memo[i+1][j+1] = memo[i][j+1]||memo[i+1][j];
	               } 
	             
	            }
	        }
	        
	        
	        return memo[s.length()][p.length()];
	        
    }
}
