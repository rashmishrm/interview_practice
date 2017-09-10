package com.practice.leetcode.tree;



//  Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class KSmallest {

	
	
	public int kthSmallest(TreeNode root, int k) {

		
		
	}
	
	public int inorder(TreeNode root, int k, int level){
		if(root!=null){
			inorder(root.left, k,level);
			
			if(k==level){
				return root.val;
			}
			level++;
			inorder(root.right,k,level);
			
		}
		return 0;
		
	}
}
