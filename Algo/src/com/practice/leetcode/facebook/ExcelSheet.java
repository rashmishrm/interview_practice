package com.practice.leetcode.facebook;

public class ExcelSheet {
	public int titleToNumber(String s) {
        String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        char [] c= s.toCharArray();
        int sum=0;
        for(int i=0;i<c.length;i++){  
    
        int alphaCode=alphabets.indexOf(c[i])+1; 
            
            sum=sum * 26;                 
           sum=sum+ alphaCode  ;
            
        }
        
        return sum;
        
        
        
    }
	
	public String convertToTitle(int n) {
        String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

         StringBuilder str= new StringBuilder();
        
        while(n>0){
            n--;
       
        str.insert(0,(char) ('A' + n % 26));
        n=n/26;
            
        }
        
        return str.toString();
    }
  
}
