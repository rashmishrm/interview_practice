package com.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderIterative {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (root != null && !stack.isEmpty()) {

			if (root.left != null) {
				stack.push(root.left);
				root = root.left;
			}
			TreeNode node = stack.pop();
			list.add(node.val);
			
			if(root.right!=null){
				stack.push(root.right);
				root=root.right;
			}
		}

		return list;
	}
}
