package com.practice.leetcode;

public class RegularExpression {
	   public boolean isMatch(String s, String p) {
	        
		      boolean firstMatch=false;
		       if(p.isEmpty() && s.isEmpty())
		           return true;
		          
		        if(!s.isEmpty() &&!p.isEmpty() && (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.')){
		            firstMatch= true;  
		        }
		        if(p.length() >=2 && p.charAt(1)=='*'){
		            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1),p));
		        }
		         else if(firstMatch){
		             return isMatch(s.substring(1), p.substring(1));
		         }
		              return false;
		    }
}
