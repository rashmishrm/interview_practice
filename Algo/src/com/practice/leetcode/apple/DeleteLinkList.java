package com.practice.leetcode.apple;

import com.practice.leetcode.ListNode;

public class DeleteLinkList {
	   public void deleteNode(ListNode node) {
	        
	        if(node==null || node.next==null)
	            return;
	        
	        node.val=node.next.val;
	        node.next=node.next.next;
	        
	    }
}
