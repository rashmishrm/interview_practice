package com.practice.leetcode;

class Result {
	public ListNode tail;
	public int size = 0;

	public Result(ListNode tail, int size) {
		this.tail = tail;
		this.size = size;
	}

}

public class LinkedListIntersect {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		
		if(headA == null || headB==null){
			return null;
		}
		Result r1 = getTailAndSize(headA);
		Result r2 = getTailAndSize(headB);
		if ( !r1.tail.equals(r2.tail)) {
			return null;
		}

		int diff = Math.abs(r1.size - r2.size);
		ListNode shorter = r1.size > r2.size ? headB : headA;
		ListNode longer = r1.size > r2.size ? headA : headB;

		while (diff > 0 && longer!=null) {
			longer = longer.next;
			diff--;
		}

		while (!longer.equals(shorter)) {

			longer = longer.next;
			shorter = shorter.next;

		}

		return longer;

	}

	public Result getTailAndSize(ListNode node) {
		if(node==null){
			return null;
		}
		int size = 1;
		while (node.next != null) {

			size++;
			node = node.next;
		}
		return new Result(node, size);

	}
}
