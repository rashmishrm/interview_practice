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

class BTNodeWithP{
	int data;
	BTNodeWithP left, right, parent;
	
	BTNodeWithP(int d){
		data = d;
		left = right = null;
	}
	
}

class InOrderSuccsessor {
	public BNode inorderSuccessor(BNode root, BNode k) {

		if (root == null || k == null) {
			return null;
		}

		if (k.right != null) {
			BNode n = k.right;
			if (k.right.left != null) {
				k = k.right.left;
				while (k.left != null) {
					k = k.left;
				}
				return k;
			} else {
				return k.right;
			}

		} else {
			BNode node = root;
			BNode prev = null;
			while (node != null) {
				if (node.data > k.data) {
					prev = node;
					node = node.left;

				} else if (node.data < k.data) {
					node = node.right;
				} else {
					break;
				}
			}

		}

		return null;

	}

	BNode outp;

	public BNode inorderSuccessor1(BNode root, BNode k) {
		// add code here.
		outp = null;
		foo(root, k.data);
		return outp;
	}

	public void foo(BNode root, int b) {
		if (root == null)
			return;
		if (root.data > b) {
			outp = root;
			foo(root.left, b);
		} else {
			foo(root.right, b);
		}
	}
	
	public BTNodeWithP next( BTNodeWithP node) {
		if(node.right!=null) {
			
				node=node.right;
				while(node.left!=null) {
					node=node.left;
				}
				return node;
			
		}
		
		else {
			BTNodeWithP tnode = node;
			BTNodeWithP parent = node.parent;
			
			while(parent!=null && tnode.data!=parent.left.data) {
				tnode=parent;
				parent= parent.parent;
			}
			
			return parent;
		}
		
	}
	
	
	
	
	
	
	struct node * inOrderSuccessor(struct node *root, struct node *n)
	{
	    // step 1 of the above algorithm
	    if( n->right != NULL )
	        return minValue(n->right);
	 
	    struct node *succ = NULL;
	 
	    // Start from root and search for successor down the tree
	    while (root != NULL)
	    {
	        if (n->data < root->data)
	        {
	            succ = root;
	            root = root->left;
	        }
	        else if (n->data > root->data)
	            root = root->right;
	        else
	           break;
	    }
	 
	    return succ;
	}
	
	   Node minValue(Node node) {
	        Node current = node;
	 
	        /* loop down to find the leftmost leaf */
	        while (current.left != null) {
	            current = current.left;
	        }
	        return current;
	    }
}











