package com.practice.leetcode;

public class OddEvenLinkedList {

	public static ListNode oddEvenList(ListNode head) {
		ListNode oddHead = null;
		if (head != null) {
			oddHead = head;
			ListNode evenHead = head.next;

			ListNode odd = head;
			ListNode even = head.next;

			while (even != null && odd != null && even.next != null && odd.next != null) {

				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}

			odd.next = evenHead;
		}
		return oddHead;
	}

	public static void main(String[] args) {

		ListNode node = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(6);

		node.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		ListNode node11 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node33 = new ListNode(4);

		node11.next = node22;
		node22.next = node33;

		ListNode output = oddEvenList(node);
		while (output != null) {
			System.out.println(output.val + "->");
			output = output.next;
		}

	}
}
