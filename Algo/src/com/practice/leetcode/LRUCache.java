package com.practice.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	 Map<Integer,Element > store= new HashMap<>();
     Deque<Element> queue = new LinkedList<>();
    int capacity =0;
    
    public LRUCache(int capacity) {
        this.capacity=capacity;        
    }
    
    public int get(int key) {
         Element val=store.getOrDefault(key, null);
         if(val!=null){
          Element el= store.get(key);
          //el.value=value;           
          queue.remove(el);
          queue.add(el);
             return val.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
          Element val=store.getOrDefault(key, null);


        if(val==null){
            if(store.size()==capacity){
            Element remove= queue.poll();
            store.remove(remove.key);
        }
            Element e = new Element(key, value);
            store.put(key, e);
            queue.add(e);
        }
        else{
          Element el= store.get(key);
          el.value=value;
          store.put(key,el);  
          queue.remove(el);
          queue.add(el);  
        }
    }
}

class Element {
    int key=0;
    int value=0;
    public Element(int key, int value){
        this.key=key;
        this.value=value;
    }

}



