package com.practice.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TopInterview_SymmetricQuestions {
	public boolean isSymmetric(TreeNode root) {
         
	        if(root==null){
	            return true;
	        }
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        
	    queue.add(root);
	        
	        int i=1;
	      
	        
	        while(!queue.isEmpty()){
             StringBuilder forward= new StringBuilder();
              StringBuilder backward= new StringBuilder();


	          Queue<TreeNode> temp = new LinkedList<TreeNode>();

	            while(!queue.isEmpty()){
	                
	            TreeNode node= queue.remove();   
	          
             if(node==null)
             {
           forward.append("null");
            backward.insert(0, "null");   
             } 
                 else{
                       temp.add(node.left);
	            temp.add(node.right);
                    forward.append(node.val+"");
            backward.insert(0, node.val);      
                 }
	           
	             
	            }
	           // System.out.println(forward);
              //System.out.println(backward);
	            if(!forward.toString().equals(backward.toString())){
              return false;   
             }
	          
	            queue= temp;
	            i++;

	        }
	        
	        return true;
	        
	        
	}    
}
