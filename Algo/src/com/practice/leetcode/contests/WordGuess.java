package com.practice.leetcode.contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordGuess {
boolean found = false;
    
    public void findSecretWord(String[] wordlist, Master master) {
        
        Map<String, Map<Integer, List<String>>> map= new HashMap<>();
        
        
        for(String word:wordlist){
            for(String eWord:wordlist){
                if(!word.equals(eWord)){
                int c= count(word,eWord);
                
                Map<Integer, List<String>> lmap=map.getOrDefault(word, new HashMap<Integer,List<String>>());
                List<String> list=lmap.getOrDefault(c, new ArrayList<String>());
                list.add(eWord);
                    
                }
            }
        }
        
       
        find(map, wordlist[0],new HashSet<String>(), master);
        
    }
    
    public void find(Map<String, Map<Integer, List<String>>> map, String word,Set<String> visited,Master master){
           if(visited.contains(word)){
               return;
           }
            int len=master.guess(word);
            
            if(len==6){
                
                found= true;
                return;
                
            }
            
            else{
            List<String> list=  map.get(word).get(len)  ;
            for(String s:list){
               visited.add(word); 
               find(map,s,visited, master);
            }
                
                
                
            }
        
        
        
            
    }
    
    
    
    
    
    
    public int count(String str1, String str2) {
    int result = 0;
    if (str1.length() == 0 || str2.length() == 0)
        return result;
    if (str1.length() > str2.length()) {
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) == str1.charAt(i))
                result++;
        }
    }
    else {
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(i))
                result++;
        }
    }
    return result;
}
}
