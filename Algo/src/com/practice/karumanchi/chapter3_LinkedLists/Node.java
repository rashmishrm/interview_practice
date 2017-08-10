package com.practice.karumanchi.chapter3_LinkedLists;


public class Node {
	int data;
	Node next = null;

	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	@Override
	public String toString() {
		String str = "" + data + ",";
		Node temp = next;

		while (temp != null) {
			str = str + temp.data + ",";
			temp = temp.next;

		}
		return str;
	}
}
