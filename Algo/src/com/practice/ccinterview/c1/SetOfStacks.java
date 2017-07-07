package com.practice.ccinterview.c1;

import java.util.List;
import java.util.ArrayList;

public class SetOfStacks {

	List<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();
	int capacity = 0;

	int totalLength = 0;

	public SetOfStacks(int capacity) {
		this.capacity = capacity;
		Stack<Integer> st = new Stack<Integer>();
		stacks.add(st);
	}

	public void pop() {
		Stack<Integer> st = stacks.get(stacks.size() - 1);
		try {
			st.pop();
			
			totalLength--;
		} catch (Exception e) {

		}

	}

	public void push(int value) {

		int size = stacks.size() * capacity;

		boolean createNewStack = totalLength + 1 > size ? true : false;

		if (createNewStack) {
			Stack<Integer> st = new Stack<Integer>();
			st.push(value);
			stacks.add(st);
		} else {
			Stack<Integer> st = stacks.get(stacks.size() - 1);
			st.push(value);

		}
		totalLength++;

	}

	public void popAt(int i) {
		try {
			stacks.get(i).pop();
		} catch (Exception e) {

		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
