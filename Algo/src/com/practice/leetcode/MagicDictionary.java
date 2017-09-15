package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class MagicDictionary {
Set<String> dictionary;
    /** Initialize your data structure here. */
    public MagicDictionary() {
    	dictionary= new HashSet<>();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
    	dictionary.addAll(Arrays.asList(dict));
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        String str= "abcdefghijklmnopqrstuvwxyz";
       
        
    	for(int i =0;i<word.length();i++){
    		String f= word.substring(i, i+1);
    		for(int j=0;j<26;j++){
    			String s= str.substring(j, j+1);
    			if(!f.equals(s)){
    				String beg= i==0?"":word.substring(0,i);
    				String replaced= beg+s +word.substring(i+1);
    				System.out.println(replaced);
    				if(dictionary.contains(replaced))
    					return true;
    			}
    		}
    	}
    	
    	return false;
    	
    }
    
    public static void main(String[] args) {
    	MagicDictionary obj = new MagicDictionary();
    	  obj.buildDict(new String[]{"hello","leetcode"});
    	  boolean param_2 = obj.search("hello");
    	  System.out.println(param_2);
	}
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */


