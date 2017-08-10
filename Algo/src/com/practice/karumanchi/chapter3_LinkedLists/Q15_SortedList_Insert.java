package com.practice.karumanchi.chapter3_LinkedLists;

public class Q15_SortedList_Insert {

	public  static void  insertInSortedList(Node head, int x) {

		Node ptr = head;
		Node pos = null;
		Node prev = head;
		while (ptr != null) {
			if (ptr.data >= x) {
				pos = ptr;
				break;
			}
			prev = ptr;
			ptr = ptr.next;
		}
		Node node = new Node(x, null);
		prev.next = node;
		node.next = ptr;

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


		insertInSortedList(node,8);
		System.out.println(node);
	}
}
