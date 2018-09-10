package com.practice.leetcode;

public class PalindromeSubstring {
    public int countSubstrings(String s) {
        return backtrack(s);
    }
    
    public int  backtrack(String s){
      int count=0;
       for(int i=0;i<s.length();i++){
           for(int j=i;j<s.length();j++){
               if(isPalindrome(s,i,j)){
                   //System.out.println(s.substring(i,j+1));
                   count++;
               }
           }
       }
        return count;
        
    }
        
   public boolean isPalindrome(String s, int low, int high){
  
      while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
      return true;
  } 
}
