package com.practice.leetcode.facebook;

public class OneEdit {

	public boolean oneEdit(String a,String b) {
		
		int m=a.length();
		int n=b.length();
		
		if(m-n>1 ) {
			return false;
		}
		
		
		int count=0;
		int i=0;
		
		if(m==n) {
			//replace
			int same=m;
			 i=0;
			while(a.charAt(i)==b.charAt(i)) same--;
			
			if(same>1) {
				return false;
			}
			
		}
		else {
			//delete /insert
			
			
			
		}
		
		
		
		return false;
	}
	
	
}
