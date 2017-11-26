package com.practice.leetcode;

public class Aesteroid {
	public int[] asteroidCollision(int[] asteroids) {
		if (asteroids == null || asteroids.length == 0) {
			return null;
		}

		java.util.Stack<Integer> stack = new java.util.Stack<>();

		stack.push(asteroids[0]);

		for (int i = 1; i < asteroids.length; i++) {
			int current = asteroids[i];

			add(current, stack);
		}

		Integer array[] = new Integer[stack.size()];
		int array1[] = new int[stack.size()];

		stack.toArray(array);

		for (int l = 0; l < array.length; l++) {
			array1[l] = array[l];
		}

		return array1;

	}

	public void add(int current, java.util.Stack<Integer> stack) {

		if (stack.size() == 0) {
			stack.push(current);
		} else {
			int peek = stack.peek();

			if ((peek < 0 && current < 0) || (peek >= 0 && current >= 0)) {
				stack.push(current);
			} else {

				if (current < 0 && peek >= 0) {
					stack.push(current);

				} else {
					if (Math.abs(peek) < Math.abs(current)) {
						stack.pop();
						add(current, stack);

						// stack.push(current);

					} else if (Math.abs(peek) > Math.abs(current)) {

					} else {
						stack.pop();

					}
				}
			}
		}
	}

	public static void main(String[] args) {

		// int[] a = { 10, -5, 5, 10 };
		int[] a = { 10, 2, -5 };

		System.err.println(new Aesteroid().asteroidCollision(a));
	}
}
