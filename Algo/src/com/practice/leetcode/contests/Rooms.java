package com.practice.leetcode.contests;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Rooms {
public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        if(rooms==null)
        return true;
        
        Set<Integer> visited = new HashSet<>();
        
        Set<Integer> set= new HashSet<>();
       
            
        
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        queue.add(0);
        
        while(!queue.isEmpty()){
            
           Integer node= queue.poll();
           
            if(!visited.contains(node)){
               queue.addAll(rooms.get(node));
                visited.add(node); 
            }
            
        }
        
         for(int i=0;i<rooms.size();i++){
           if(!visited.contains(i)){
             return false;  
           }
        }
        
        
        return true;
        
        
    }
}
