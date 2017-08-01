package com.practice.ccinterview.dynamicandrecursion;

public class Q4_Recursive_Multiply {

	public static int multiply(int a, int b) {
		int smaller = a > b ? b : a;
		int bigger = b > a ? b : a;

		return multiply_nonmem(smaller, bigger);
	}

	public static int multiply_nonmem(int smaller, int bigger) {

		if (smaller == 0) {
			return 0;
		}
		if (smaller == 1) {
			return bigger;
		}

		int s = smaller >> 1;
		int side1 = multiply_nonmem(s, bigger);
		int side2 = side1;
		if (smaller % 2 == 1) {
			side2 = multiply_nonmem(smaller - s, bigger);
		}
		return side1 + side2;

	}

	public static int multiply_memo(int a, int b) {
		int smaller = a > b ? b : a;
		int bigger = b > a ? b : a;
		int memo[] = new int[smaller+1];
		return multiply_memo(smaller, bigger, memo);
	}

	public static int multiply_memo(int smaller, int bigger, int memo[]) {

		if (smaller == 0) {
			return 0;
		}
		if (smaller == 1) {
			return bigger;
		}

		if (memo[smaller] != 0) {
			return memo[smaller];
		}
		int s = smaller >> 1;
		int side1 = multiply_nonmem(s, bigger);
		int side2 = side1;
		if (smaller % 2 == 1) {
			side2 = multiply_nonmem(smaller - s, bigger);
		}

		int output = side1 + side2;
		memo[smaller] = output;

		return output;

	}

	public static void main(String[] args) {
		// System.out.println(8 >> 1);
		System.out.println(multiply_memo(3, 9));
	}

}
