package com.practice.leetcode;

public class LinkedListReverse {

	public ListNode reverseBetween(ListNode head, int m, int n) {

		// reach m first
		ListNode saveHead = head;

		ListNode prev = null;

		while (m >= 0) {

			prev = head;
			head = head.next;

			m--;

		}

		ListNode ptr = head;
		ListNode ptr2 = ptr.next;

		while (n >= 0) {

			ListNode temp = ptr2;

			prev.next = temp;
			temp.next = ptr;

			ptr2 = ptr2.next;
			ptr = ptr.next;
			n--;

		}

		return saveHead;

	}
}
