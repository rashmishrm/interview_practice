package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKLists {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists != null && lists.length < 0) {
			return null;
		}
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(5, new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				if (o1.val > o2.val) {
					return 1;
				} else if (o1.val < o2.val) {
					return -1;
				}
				return 0;
			}
		});

		ListNode dummy = new ListNode(0);
		dummy.next = null;
		ListNode i = dummy;

		for (ListNode node : lists) {
			if (node != null) {
				queue.add(node);

			}

		}
		System.out.println(queue.size());
		while (!queue.isEmpty()) {

			ListNode node = queue.remove();
			i.next = node;
			i = i.next;
			if(node.next!=null)
			queue.add(node.next);
		}

		return dummy.next;

	}

	public static void main(String[] args) {
		
		ListNode node = new ListNode(1);
		ListNode[] list ={node};
		
		new MergeKLists().mergeKLists(list);
		
		

	}
}
