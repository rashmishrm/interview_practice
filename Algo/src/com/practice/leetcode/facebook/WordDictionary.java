package com.practice.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

class WordDictionary {
    Node root=null;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root= new Node(); 

    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        word=word+"*";
        char ch[]=word.toCharArray();
        Node checker= root;
   
        
        for(char c: ch){
            if(checker.hasChildNode(c+"")){
              checker= checker.get(c+"");
                
            }
            else{
             checker.addChild(c+"")   ;
             checker= checker.get(c+"");   
            }
            
            
            
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
         word=word+"*";
        return search(word.toCharArray(),root,0); 

    }
    
    
        public boolean search(char []  chars, Node node, int index) {
            
            if(index>chars.length-1){
                return true;
            }

            if(chars[index]=='.'){
              Map<String,Node>  nodeChildren= node.nodeChildren;
            for(String key: nodeChildren.keySet()){
                boolean found=search(chars,nodeChildren.get(key),index+1);
                if(found){
                    return true;
                }
            }
                
            return false;
            
            
            }
            else if(node.hasChildNode(chars[index]+"")){
                
                return search(chars,node.get(chars[index]+""),index+1); 
                
            }
            
          return  false;
            
        }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
