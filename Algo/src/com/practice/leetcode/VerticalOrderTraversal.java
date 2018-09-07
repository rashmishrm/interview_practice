package com.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> list= new ArrayList<>();
              if(root==null){
               return list;
           }
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer> columns = new LinkedList<Integer>();
        
        nodes.offer(root);
        columns.offer(0);
        
        while(!nodes.isEmpty()){
            
            List<TreeNode> temp= new ArrayList<>();
            List<Integer> tempcols= new ArrayList<>();
            
            while(!nodes.isEmpty()){
               TreeNode node = nodes.poll();
               int col= columns.poll();  
               List<Integer> l = map.getOrDefault(col, new ArrayList<Integer>());
               l.add(node.val);
               map.put(col,l);
               if(node.left!=null){
               temp.add(node.left);
               tempcols.add(col-1);
               }
             if(node.right!=null){
               temp.add(node.right);
               tempcols.add(col+1); 
             }
            }
            nodes.addAll(temp);
            columns.addAll(tempcols);
            
        }
        
       for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()){
           list.add(entry.getValue());
       }
        
     return list;
        
    }
}
