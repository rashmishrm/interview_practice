package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> list= new ArrayList<>();
        
        partitionrec(list, new ArrayList<String>(),s,0);
        
        return list;
        
        
    }
    
     public void partitionrec(List<List<String>> list, List<String> output, String str, int index) { 
         if(index==str.length()){
             list.add(new ArrayList<String>(output));
             return;
         }
         
         for(int i=index;i<str.length();i++){
                             System.out.println(str.substring(index, i+1));


             if(isPalindrome(str,index,i)){
                 output.add(str.substring(index,i+1));
                 partitionrec(list,output,str,i+1);
                                              System.out.println("rem");


                output.remove(output.size()-1);  
             }
                      
         }
         
     }
    
        
    public boolean isPalindrome(String s, int low, int high){
  
      while(low < high)
      if(s.charAt(low++) != s.charAt(high--)) return false;
      return true;
    } 
    
}
