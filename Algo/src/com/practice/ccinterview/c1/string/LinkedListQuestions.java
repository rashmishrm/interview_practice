package com.practice.ccinterview.c1.string;

import java.rmi.Remote;
import java.util.HashMap;

class Node {
	int data;
	Node next;

	Node(int x) {
		data = x;
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

public class LinkedListQuestions {

	public static void removeDups(Node head) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Node node = head;
		Node prev = node;
		while (node != null) {

			if (map.get(node.data) == null) {
				map.put(node.data, 1);
				prev = node;

			} else {

				prev.next = node.next;

			}
			node = node.next;
		}

	}

	public static Node  kThNodefromLast(Node head, int k) {

		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k; i++) {
			p2 = p2.next;
		}

		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p1;

	}

	public static void main(String[] args) {
		Node n = new Node(1);
		Node n1 = new Node(1);
		Node n2 = new Node(1);
		Node n3 = new Node(1);

		n.next = n1;
		n1.next = n2;
		n2.next = n3;
		removeDups(n);

		System.out.println(n);

	}

}
