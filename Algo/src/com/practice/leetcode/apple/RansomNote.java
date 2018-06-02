package com.practice.leetcode.apple;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
public boolean canConstruct(String ransomNote, String magazine) {
        
        if(ransomNote==null || magazine==null){
            return false;
        }
        
        Map<Character, Integer> map= new HashMap<>();
        
        for(char ch: magazine.toCharArray()){
            int count=0;
            if(map.containsKey(ch)){
             count= map.get(ch);   
            }
            count=count+1;
            map.put(ch,count);
            
        }
        
      for(char e:ransomNote.toCharArray()){
          int count=0;
          if(map.containsKey(e)){
               count= map.get(e);
               count=count-1;
              if(count!=0){
                map.put(e,count);  
              }
               else{
                   map.remove(e);
               }
          }
          else{
              return false;
          }
      }
        
        return true;
        
    }
}
