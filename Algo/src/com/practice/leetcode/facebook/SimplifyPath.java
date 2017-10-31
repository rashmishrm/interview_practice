package com.practice.leetcode.facebook;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {

		if (path == null || "".equals(path.trim())) {
			return null;

		}

		StringBuilder result = new StringBuilder();

		Stack<String> stack = new Stack<String>();

		// TODO think an alternative of split
		String[] array = path.split("/");

		for (int i = 0; i < array.length; i++) {

			if (array[i].equals(".") || array[i].equals("")) {
				// do nothing
			} else if (array[i].equals("..")) {
				if (!stack.isEmpty())
					stack.pop();
			} else {
				stack.push(array[i]);
			}

		}

		while (!stack.isEmpty()) {

			String b = stack.pop();
			result.insert(0, "/" + b);

		}

		return result.toString().equals("") ? "/" : result.toString();

	}
}
