package com.practice.ccinterview.c1.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class TreeQuestions {

	public boolean isBalanced(TreeNode root) {

		return height(root) == -1 ? false : true;

	}

	public int height(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int lDepth = height(root.left);
		if (lDepth == -1)
			return -1;

		int rDepth = height(root.right);

		if (rDepth == -1)
			return -1;

		if (Math.abs(lDepth - rDepth) > 1) {
			return -1;
		}

		return 1 + Math.max(lDepth, rDepth);

	}

	public List<List<Integer>> listOfLevels(TreeNode node) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (node == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		queue.add(node);

		while (!queue.isEmpty()) {

			List<Integer> eachLevel = new ArrayList<Integer>();
			Queue<TreeNode> temp = new LinkedList<TreeNode>();

			while (!queue.isEmpty()) {
				TreeNode value = queue.poll();
				eachLevel.add(value.val);
				temp.add(value);
			}

			list.add(eachLevel);

			while (!temp.isEmpty()) {
				TreeNode value = temp.poll();
				if (value != null && value.left != null) {
					queue.add(value.left);
				}
				if (value != null && value.right != null) {
					queue.add(value.right);
				}

			}

		}

		return list;

	}
	
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	List<List<Integer>> list = new ArrayList<List<Integer>>();

	if (root == null) {
		return list;
	}

	Queue<TreeNode> queue = new LinkedList<TreeNode>();

	queue.add(root);
int i=0;
	while (!queue.isEmpty()) {

		List<Integer> eachLevel = new ArrayList<Integer>();
		Queue<TreeNode> temp = new LinkedList<TreeNode>();
		Stack<Integer> stack = new Stack<Integer>();
		while (!queue.isEmpty()) {
			TreeNode value = queue.poll();
			if(i%2==0){
				eachLevel.add(value.val);
			}
			else{
				stack.add(value.val);
			}
			
			temp.add(value);
		}
		
		if(i%2!=0){
			while(!stack.isEmpty()){
				eachLevel.add(stack.pop());
			}
		}

		list.add(eachLevel);

		while (!temp.isEmpty()) {
			TreeNode value = temp.poll();
		
			if (value != null && value.left != null) {
				queue.add(value.left);
			}
			if (value != null && value.right != null) {
				queue.add(value.right);
			}
			

		}
		
		i++;

	}

	return list;
    }

}
