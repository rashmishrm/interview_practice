package com.practice.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

class Trie {

    Node root=null;
    
    /** Initialize your data structure here. */
    public Trie() {
        root= new Node(); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        word=word+"*";
         char ch[]=word.toCharArray();
        Node checker= root;
           boolean found=true;
        for(char c: ch){
               if(checker.hasChildNode(c+"")){
              checker= checker.get(c+"");
                
            } 
            else{
                found=false;
                break;
            }
           }
            
         

        
        return found;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
         char ch[]=prefix.toCharArray();
        Node checker= root;
           boolean found=true;
        for(char c: ch){
               if(checker.hasChildNode(c+"")){
              checker= checker.get(c+"");
                
            } 
            else{
                found=false;
                break;
            }
           }
        
        
        
        return found;
    }
}

class Node{
    
    Map<String,Node> nodeChildren= new HashMap<>();    
    
    public void addChild(String key){
        nodeChildren.put(key,new Node());
        
    }
    
    public Node get(String key){
        return nodeChildren.get(key);
        
    }
    
    public boolean hasChildNode(String key){
        return nodeChildren.get(key)==null?false:true;
    }
    
  
    
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */