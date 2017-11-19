package com.practice.leetcode.facebook;

/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

//Complete the function below
//Node is as follows:
class BNode {
	int data;
	BNode left, right;

	BNode(int d) {
		data = d;
		left = right = null;
	}
}

class InOrderSuccsessor {
	public BNode inorderSuccessor(BNode root, BNode k) {
		
		if(root==null || k==null) {
			return null;
		}

		if(k.right!=null) {
			BNode n= k.right;
			if(k.right.left!=null) {
				k=k.right.left;
				while(k.left!=null) {
					k=k.left;
				}
				return k;
			}
			else {
				return k.right;
			}
			
			
		}
		else {
			BNode node= root;
			BNode prev=null;
			while(node!=null) {
			if(node.data>k.data) {
				prev=node;
				node=node.left;
				
				
			}
			else if(node.data<k.data) {
				prev=node;
				node=node.right;
			}
			else {
			break;
			}
			}
			
			
		}
		
		return null;
		
	}
}