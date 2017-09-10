package com.practice.leetcode.tree;

//  Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class KSmallest {
	static int value=0;
	   static int level=0;
		public int kthSmallest(TreeNode root, int k) {
			level=k;
	        inorder(root, k);
			 return value;
		}


		public void inorder(TreeNode root, int k) {
			if (root != null) {
	            
				if(root.left!=null)
				inorder(root.left, k);

	            level--;


				if ( level==0) {
					value=root.val;
					return ;
				}


	            
				if(root.right!=null)
				inorder(root.right, k);
				
			}

		}
		
		
	
}
