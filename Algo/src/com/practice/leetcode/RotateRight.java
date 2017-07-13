package com.practice.leetcode;



public class RotateRight {

	public static Result getTailAndSize(ListNode node) {
		if (node == null) {
			return null;
		}
		int size = 1;
		while (node.next != null) {

			size++;
			node = node.next;
		}
		return new Result(node, size);

	}

	public static ListNode rotateRight(ListNode head, int k) {

		if (head == null)
			return null;

		Result l = getTailAndSize(head);
		if (l.size == 1) {
			return head;
		}
		k = k > l.size ? k % l.size : k;
		int diff = Math.abs(l.size - k);
		if (diff > 0 && k != 0) {
			ListNode kth = head;
			ListNode prev = null;
			while (diff > 0 && kth != null) {

				prev = kth;
				kth = kth.next;
				diff--;
			}

			prev.next = null;

			if (kth != null) {

				l.tail.next = head;

				// kth=head;
			}
			return kth;
		}

		else {
			return head;
		}

	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);

		l.next = l1;
		l1.next = l2;
		l2.next = l3;

		l = rotateRight(l, 2);

		String str = "";
		ListNode temp = l;

		while (temp != null) {
			str = str + temp.val + ",";
			temp = temp.next;

		}
		System.out.println(str);

	}

}
