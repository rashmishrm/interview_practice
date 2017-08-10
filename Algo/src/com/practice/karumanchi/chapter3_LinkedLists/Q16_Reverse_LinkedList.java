package com.practice.karumanchi.chapter3_LinkedLists;

public class Q16_Reverse_LinkedList {

	public static Node reverse_iterative(Node head) {

		Node node = head;
		Node revh = head;
		Node revt = head;
		while (node != null) {

			node = node.next;
			Node temp = revh;

			revh = node;
			revh.next = temp;
			// revh=revh.next;

		}
		return revt;
	}

	public static void main(String[] args) {
		Node node = new Node(1, null);
		Node node1 = new Node(2, null);
		Node node2 = new Node(3, null);
		Node node3 = new Node(4, null);
		Node node4 = new Node(5, null);
		Node node5 = new Node(6, null);

		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		reverse_iterative(node);
		System.out.println(node);
	}
}
