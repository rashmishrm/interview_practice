package com.practice.leetcode;

public class ReverseLinkedList2 {

	public static ListNode reverseBetween(ListNode head, int m, int n) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode(0);
		ListNode node = dummy;
		int diff = n - m;
		if (diff != 0) {
		ListNode tr = head.next;
		ListNode prev = head;

		while ((m-1)> 0) {
			prev = tr;
			tr = tr.next;
			m--;
		}

		ListNode next = null;
		
			while (diff + 1 > 0) {
				ListNode temp = tr;
				next = tr;
				tr = tr.next;
				temp.next = node;
				node = temp;
				diff--;
			}

			ListNode oldPrev = prev.next;

			prev.next = next;
			oldPrev.next = tr;
		}

		return head;

	}

	public static void main(String[] args) {
		ListNode l = new ListNode(3);
		ListNode l1 = new ListNode(4);
		//ListNode l2 = new ListNode(3);
		//ListNode l3 = new ListNode(4);

		l.next = l1;
		//l1.next = l2;
		//l2.next = l3;

		l = reverseBetween(l, 1, 2);

		String str = "";
		ListNode temp = l;

		while (temp != null) {
			str = str + temp.val + ",";
			temp = temp.next;

		}
		System.out.println(str);

	}
}
