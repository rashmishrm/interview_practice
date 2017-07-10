package com.practice.ccinterview.c1;

import java.util.Stack;

public class SortedStack {

	public void sortedStack(Stack<Integer> stack) {

		Stack<Integer> newStack = new Stack<Integer>();

		while (!stack.isEmpty()) {
			int temp = stack.pop();

			while (!newStack.isEmpty() && newStack.peek() < temp) {
				stack.push(newStack.pop());
			}
			newStack.push(temp);

		}

	}

}
