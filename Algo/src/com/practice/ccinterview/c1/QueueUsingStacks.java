package com.practice.ccinterview.c1;

import java.util.Stack;

public class QueueUsingStacks {

	Stack<Integer> newStack = new Stack<Integer>();
	Stack<Integer> oldstack = new Stack<Integer>();

	/** Initialize your data structure here. */
	public QueueUsingStacks() {

	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		newStack.push(x);
	}

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {
		shiftStack();
		return oldstack.pop();
	}

	/** Get the front element. */
	public int peek() {
		shiftStack();
		return oldstack.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		if (newStack.size() + oldstack.size() <= 0) {
			return true;
		}
		return false;
	}

	public void shiftStack() {
		if (oldstack.size() == 0) {
			while (newStack.size() != 0) {
				oldstack.push(newStack.pop());
			}
		}
	}
}
