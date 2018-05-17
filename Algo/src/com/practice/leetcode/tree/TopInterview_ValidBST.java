package com.practice.leetcode.tree;

public class TopInterview_ValidBST {
	 public boolean isValidBST(TreeNode root) {

	        if(root==null){
	            return true;
	        }
	       return  isValidBST_f(root, Long.MIN_VALUE, Long.MAX_VALUE);
	        
	    }
	    
	    public boolean isValidBST_f(TreeNode root, long low, long high) {
	        
	        if(root==null){
	            return true;
	        }
	    
	       return (root.val>low && root.val<high) && isValidBST_f(root.left,low ,root.val) && isValidBST_f(root.right, root.val, high);
	        
	    }
}
