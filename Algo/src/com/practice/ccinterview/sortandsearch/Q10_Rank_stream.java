package com.practice.ccinterview.sortandsearch;

import java.util.ArrayList;
import java.util.List;

public class Q10_Rank_stream {
	
	public static void main(String[] args) {
		Stream s = new Stream();
		int arr[]= {5,1,4,4,5,9,7,13,3};
		for(int x:arr){
			s.add(x);;
		}
		
		System.out.println(s.getRankOfNumber(5));
		System.out.println(s.getRankOfNumber(1));
		System.out.println(s.getRankOfNumber(3));
		System.out.println(s.getRankOfNumber(4));

	
	}

}

class StreamNode {

	int data;
	int duplicacyCount = 0;
	StreamNode left;
	StreamNode right;

	public StreamNode(int data, int duplicacyCount, StreamNode left, StreamNode right) {
		super();
		this.data = data;
		this.duplicacyCount = duplicacyCount;
		this.left = left;
		this.right = right;
	}

	public void setDuplicacyCount(int duplicacyCount) {
		this.duplicacyCount = duplicacyCount;
	}

	public void setLeft(StreamNode left) {
		this.left = left;
	}

	public void setRight(StreamNode right) {
		this.right = right;
	}

}

class Stream {

	StreamNode root;

	public void add(int x) {

		if (root == null) {
			root = new StreamNode(x, 0, null, null);

		} else {
			StreamNode node = find(root, x);
			if (node.data == x) {
				node.duplicacyCount = node.duplicacyCount + 1;
			} else {
				if (node.data < x) {
					node.left = new StreamNode(x, 0, null, null);
				} else {
					node.right = new StreamNode(x, 0, null, null);
				}
			}

		}

	}

	public StreamNode find(StreamNode node, int x) {
		if (node == null) {
			return null;
		}

		if (node.data == x) {
			return node;
		}

		if (node.data > x) {
			if (node.right == null) {
				return node;
			}

			return find(node.right, x);
		}

		else if (node.data < x) {
			if (node.left == null) {
				return node;
			}
			return find(node.left, x);
		}

		return null;

	}

	public int getRankOfNumber(int x) {
		List<Integer> list = new ArrayList<>();
		rankOfNumber(root, x, list);
		return list.size();

	}

	public void rankOfNumber(StreamNode node, int x, List<Integer> list) {
		if (node == null) {
			return;
		}

		rankOfNumber(node.left, x, list);

		if (node.data < x) {
			list.add(x);
		}
		if (node.data == x) {
			for (int i = 0; i < node.duplicacyCount; i++) {
				list.add(x);
			}

		}

		rankOfNumber(node.right, x, list);

	}

}