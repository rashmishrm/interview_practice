package com.practice.karumanchi.chapter3_LinkedLists;

public class Q11_Find_Cycle_Node {
	public static Node detectCycle(Node head) {

		if (head == null || head.next == null) {
			return null;
		}
		Node slow = head;
		Node fast = head;

		while (slow != null && fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (fast.equals(slow)) {
				break;
			}

		}

		System.out.println(slow.data);
		slow = head;
		while (!slow.equals(fast) && fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
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
		node5.next = node3;

		System.out.println(detectCycle(node).data);

	}
}
