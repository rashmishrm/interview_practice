
package com.practice.coursera;

import java.util.*;
import java.io.*;

public class is_bst {
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

		long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}

	public class IsBST {
		class Node {
			long key;
			int left;
			int right;

			Node(long key, int left, int right) {
				this.left = left;
				this.right = right;
				this.key = key;
			}
		}

		int nodes;
		Node[] tree;
		Map<Integer, Integer> parentChild = new HashMap<Integer, Integer>();

		void read() throws IOException {
			FastScanner in = new FastScanner();
			nodes = in.nextInt();
			tree = new Node[nodes];
			for (int i = 0; i < nodes; i++) {
				tree[i] = new Node(in.nextLong(), in.nextInt(), in.nextInt());

			}
		}

		public boolean inOrder(int n, List<Node> list) {

			if (n != -1) {

				inOrder(tree[n].left, list);

				if (list.size() > 0) {
					Node prev = list.get(list.size() - 1);
					if (prev.key > tree[n].key) {
						return false;
					} else if (prev.key == tree[n].key) {
						if (!((tree[n].left != -1 && tree[tree[n].left].key < tree[n].key)
								&& (tree[n].right != -1 && tree[tree[n].right].key >= tree[n].key))) {
							return false;
						}
					}

				}
				list.add(tree[n]);

				inOrder(tree[n].right, list);
			}

			return true;

		}

		boolean isBinarySearchTree() {
			if (tree.length == 0) {
				return true;
			}
			ArrayList<Node> list = new ArrayList<Node>();

			return inOrder(0, list);
		}
	}

	static public void main(String[] args) throws IOException {
		new Thread(null, new Runnable() {
			public void run() {
				try {
					new is_bst().run();
				} catch (IOException e) {
				}
			}
		}, "1", 1 << 35).start();
	}

	public void run() throws IOException {
		IsBST tree = new IsBST();
		tree.read();
		if (tree.isBinarySearchTree()) {
			System.out.println("CORRECT");
		} else {
			System.out.println("INCORRECT");
		}
	}
}
