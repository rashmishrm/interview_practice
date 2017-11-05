package com.practice.leetcode.facebook;

import java.util.Stack;

public class ValidateBinaryTree {
	   public boolean isValidBST(TreeNode root) {
	          return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	    }
	    
	     public boolean isValidBST(TreeNode node,int lowerbound, int upperbound) {
	        
	         if(node==null){
	             return true;
	             
	         }
	         
	         if(node.val<=lowerbound || node.val>=upperbound){
	             return false;
	         }
	         
	         return isValidBST(node.left,lowerbound, node.val) && isValidBST(node.right,node.val,upperbound);
	         
	         
	         
	    }
	     
	     
	     public boolean isValidBSTI(TreeNode root) {
	        
	    	 
	    	 
	    	 Stack<TreeNode> stack = new Stack<TreeNode>();
	    	 TreeNode prev=null;
	    	 while(root!=null || !stack.isEmpty()) {
	    		 
	    		 while(root!=null) {
	    			 stack.push(root);
	    			 root=root.left;
	    			 
	    		 }
	    		 root=stack.pop();
	    		 if(prev!=null && prev.val>=root.val) {
	    			 return false;
	    		 }
	    		 
	    		 prev=root;
	    		 root=root.right;
	    		 
	    		 
	    	 }
	    	 
	    	 return true;
	    	 
	    	 
	    }     
	     
	     
}
