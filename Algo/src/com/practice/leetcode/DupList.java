package com.practice.leetcode;

public class DupList {

	public static ListNode deleteDuplicates(ListNode head) {

		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return head;
		}
		ListNode prev = null;
		int lastRemoved = 0;

		ListNode fast = head.next;
		ListNode slow = head;
		prev = null;
		while (fast != null) {
			ListNode temp1 = fast;
			ListNode temp2 = slow;
			fast = fast.next;
			slow = slow.next;

			if ((lastRemoved == temp1.val) || temp1.val == temp2.val) {
				lastRemoved = temp1.val;
				if (prev != null) {
					prev.next = temp1.next;
					// reached end
					if (prev.next == null) {
						break;
					}

				} else {
					head = temp1.next;
					if(temp1.val==temp1.next.val){
						head=null;
					}
					if (head != null && head.next == null) {
						break;
					}
				}
				
				slow= temp1.next;
				if(slow!=null)
				fast=slow.next;
				

			} else {
				prev = temp2;
			}

		}

		return head;

	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);

		l.next = l1;
		l1.next = l2;
		l2.next = l3;

		l = deleteDuplicates(l);

		String str = "";
		ListNode temp = l;

		while (temp != null) {
			str = str + temp.val + ",";
			temp = temp.next;

		}
		System.out.println(str);

	}
}
