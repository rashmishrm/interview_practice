package com.practice.leetcode.facebook;
/**
 * Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Given the list [1,[4,[6]]],

By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 */

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// This is the interface that allows for creating nested lists. // You should
//not implement it, or speculate about its implementation public interface
class NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
		return false;
	}

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer // Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return 0;
	}

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list // Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return null;
	}
}

public class NestedIterator implements Iterator<Integer> {
	Stack<Integer> stack = new Stack<Integer>();

	public NestedIterator(List<NestedInteger> nestedList) {
		List<NestedInteger> nestedinnerList = nestedList;
		for (int i = nestedinnerList.size() - 1; i >= 0; i--) {
			NestedInteger each = nestedinnerList.get(i);
			addToSatck(each);
		}
	}

	public void addToSatck(NestedInteger nestedInteger) {
		if (nestedInteger != null && nestedInteger.isInteger()) {
			stack.add(nestedInteger.getInteger());
		} else if (nestedInteger != null && !nestedInteger.isInteger()) {
			List<NestedInteger> nestedinnerList = nestedInteger.getList();
			for (int i = nestedinnerList.size() - 1; i >= 0; i--) {
				NestedInteger each = nestedinnerList.get(i);
				addToSatck(each);
			}
		}

	}

	@Override
	public Integer next() {
		return stack.pop();
	}

	@Override
	public boolean hasNext() {
		return stack.size() == 0 ? false : true;
	}
}
