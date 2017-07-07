package com.practice.leetcode;

public class LinkedListCycleDetection {

	public boolean hasCycle(ListNode head) {
		if(head==null){
			return true;
		}

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr.equals(fastPtr)) {
				break;
			}

		}

		if (fastPtr == null || fastPtr.next == null) {
			return false;
		} else {
			return true;
		}

	}

	public ListNode detectCycle(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if (slowPtr.equals(fastPtr)) {
				break;
			}

		}

		if (fastPtr == null || fastPtr.next == null) {
			return null;
		}
		slowPtr = head;

		while (!slowPtr.equals(fastPtr)) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		
		return slowPtr;

	}

}
