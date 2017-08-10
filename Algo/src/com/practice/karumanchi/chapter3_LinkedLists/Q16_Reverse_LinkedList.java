package com.practice.karumanchi.chapter3_LinkedLists;

public class Q16_Reverse_LinkedList {
	public static Node reverse(Node head) {
		if (head == null) {
			return null;
		}
		Node t = null;
		return reverse_1(head, t);
	}

	public static Node reverse_1(Node head, Node t) {

		Node node = head;
		if (node.next == null) {
			return node;
		}

		Node n = reverse_1(node.next, t);
		if (t == null) {
			t = n;
			
		}
		t.next = node;

		return t;

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

		reverse(node);
		System.out.println(node);
	}
}
