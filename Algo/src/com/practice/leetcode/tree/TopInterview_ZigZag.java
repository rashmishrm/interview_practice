package com.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopInterview_ZigZag {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        
        
	       List<List<Integer>> list = new ArrayList<>(); 
	        if(root==null){
	            return list;
	        }
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        
	    queue.add(root);
	        
	        int i=1;
	      
	        
	        while(!queue.isEmpty()){
	              List<Integer> l= new ArrayList<>();
	          Queue<TreeNode> temp = new LinkedList<TreeNode>();

	            while(!queue.isEmpty()){
	                
	            TreeNode node= queue.remove();   
	            if(node.left!=null)
	            temp.add(node.left);
	             if(node.right!=null)
	            temp.add(node.right);
	                
	           l.add(node.val);     
	            }
	            
	            if(i%2==0){
	                Collections.reverse(l);
	            }
	            list.add(l);
	            queue= temp;
	            i++;

	        }
	        
	        return list;
	        
	        
	        
	        
	      
	        
	}
}
