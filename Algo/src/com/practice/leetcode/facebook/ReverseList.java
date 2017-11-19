package com.practice.leetcode.facebook;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseList {
	public ListNode reverseList(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode newHead = null;

		while (head.next != null) {
			ListNode next = head.next;
			newHead = next;
			newHead.next = head;
			head = head.next.next;

		}
		return newHead;

	}
	
	public static void main(String[] args) {
		ListNode node1= new ListNode(5);
		ListNode node2= new ListNode(4);
		ListNode node3= new ListNode(3);
		ListNode node4= new ListNode(2);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		

		
		
		new ReverseList().reverseList(node1);
	}
}
