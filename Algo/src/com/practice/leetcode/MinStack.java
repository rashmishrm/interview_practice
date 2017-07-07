package com.practice.leetcode;

class Node {
	int value;

	Node next;

	public Node(int value) {
		this.value = value;
	}
}

class Stack {

	Node top = null;

	public void push(int elemnt) {
		Node node = new Node(elemnt);
		node.next = top;
		top = node;

	}

	public int pop() {
		int data = 0;
		if (top != null) {

			data = top.value;
			Node temp = top.next;
			top = temp;
		}

		return data;

	}

	public int peek() {

		if (top != null) {
			int data = top.value;
			return data;
		}
		return 0;
	}

}

public class MinStack {

	Stack minStack = new Stack();

	Node top = null;

	public MinStack() {

	}

	public void push(int x) {
		if (x <= getMin()) {
			minStack.push(x);
		}
		Node node = new Node(x);
		node.next = top;
		top = node;
	}

	public void pop() {
		if (top != null) {

			if (top.value == getMin()) {
				minStack.pop();
			}

			Node temp = top.next;
			top = temp;

		}
	}

	public int top() {
		if (top != null) {
			int data = top.value;
			return data;
		}
		return 0;

	}

	public int getMin() {
		if (top == null) {
			return Integer.MAX_VALUE;
		} else {

			return minStack.peek();

		}

	}

	
}