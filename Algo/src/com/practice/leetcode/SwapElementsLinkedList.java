package com.practice.leetcode;

public class SwapElementsLinkedList {
	public static ListNode swapPairs(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode slowPtr = head;
		ListNode fastPtr = head.next;
		
		if(head.next==null){
			return head;
		}

		ListNode prev = null;
		
		head=fastPtr;

		while (fastPtr != null) {

			ListNode temp1 = slowPtr;
			ListNode temp2 = fastPtr;
			ListNode temp = temp1;

			if (fastPtr != null && fastPtr.next != null && fastPtr.next.next != null) {
				slowPtr = slowPtr.next.next;
				fastPtr = fastPtr.next.next;
			}
			else{
				fastPtr=null;
			}

			temp.next = temp2.next;
			temp2.next = temp1;

			if (prev != null) {
				prev.next = temp2;
			}
			prev = temp1;
		}

		return head;

	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(4);

		l.next = l1;
		l1.next = l2;
		l2.next = l3;

		l = swapPairs(l);

		String str = "";
		ListNode temp = l;

		while (temp != null) {
			str = str + temp.val + ",";
			temp = temp.next;

		}
		System.out.println(str);

	}
}
