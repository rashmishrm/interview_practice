package com.practice.leetcode.google;

import java.util.PriorityQueue;

public class Q23_MergeSortedLists {

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode head = null;
		ListNode node = null;
		PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null)
				queue.add(lists[i]);
		}

		while (!queue.isEmpty()) {

			ListNode smallest = queue.poll();
			if (smallest.next != null) {
				queue.add(smallest.next);
			}
			if (node == null) {
				node = smallest;
				head = node;
			} else {
				node.next = smallest;
				node = node.next;
			}

		}

		return head;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
