package com.practice.coursera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class tree_orders {
	class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}

		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	class Node {
		int val;
		int left;
		int right;

		Node(int x, Node left, Node right) {
			val = x;
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;

		void read() throws IOException {
			List<Node> nodes = new ArrayList<Node>();
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) {
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();

			}
		}

		public void inOrder(int n, int size, List<Integer> list) {
			if (n != -1) {

				inOrder(left[n], size, list);

				list.add(key[n]);

				inOrder(right[n], size, list);
			}

		}
		
		public void preOrder(int n, int size, List<Integer> list) {
			if (n != -1) {


				list.add(key[n]);

				preOrder(left[n], size, list);

				preOrder(right[n], size, list);
			}

		}
		public void postOrder(int n, int size, List<Integer> list) {
			if (n != -1) {



				postOrder(left[n], size, list);

				postOrder(right[n], size, list);
				list.add(key[n]);

			}

		}
		

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that

			inOrder(0, n, result);
			return result;
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that
			preOrder(0, n, result);
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
			// Finish the implementation
			// You may need to add a new recursive method to do that
			postOrder(0, n, result);
			return result;
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new tree_orders().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
