package com.practice.leetcode.facebook;
//Given an array of strings, group anagrams together.
//
//For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
//Return:
//
//[
//  ["ate", "eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> table= new HashMap<>();
        List<List<String>> output= new ArrayList<>();
        
        
        if(strs==null || strs.length==0){
            return null;
        }
        
        for(int i=0;i<strs.length;i++){
            char[] array=strs[i].toCharArray();
            
            Arrays.sort(array);
            String sorted=new String(array);
            List<String> anagrams=new ArrayList<String>();
            if(table.containsKey(sorted)){
               anagrams=table.get(sorted); 
            }
            anagrams.add(strs[i]);
            table.put(sorted,anagrams);

        }
        
        for(String eachKey: table.keySet()){
           output.add(table.get(eachKey)) ;
            
        }
        
        return output;
        
        
    }
}
