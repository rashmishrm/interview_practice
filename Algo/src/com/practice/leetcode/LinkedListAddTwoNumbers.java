package com.practice.leetcode;

import java.util.Stack;



public class LinkedListAddTwoNumbers {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
		  Stack<Integer> one=new Stack<Integer>();
		  Stack<Integer> two=new Stack<Integer>();
		  
		  while(l1!=null){
			  one.push(l1.val);
			  l1=l1.next;
		  }
		  while(l2!=null){
			  two.push(l2.val);
			  l2=l2.next;
		  }
		  int size=one.size()>two.size()?one.size():two.size();
		  	  Stack<Integer> output=new Stack<Integer>();
		  int carryover=0;
		  int i=0;
		  while(size>0){
		      int two_1=0;
		      int one_1=0;
		      if(!one.isEmpty()){
			   one_1=one.pop();
		      }
			  if(!two.isEmpty()){
			   two_1=two.pop();
			  }
			  int sum=one_1+two_1+carryover;
			  System.out.println(sum);
			  carryover=sum/10;
			  sum=sum%10;
			  System.out.println(carryover);
			  
			  System.out.println("one"+one_1+"two"+two_1+"sum"+sum+carryover);
			  output.push(sum);
			  size--;
		  }
		  if(carryover!=0){
			  output.push(carryover);
		  }
		  
		  ListNode node= new ListNode(output.pop());
		  node.next=null;
		  ListNode temp=node;
		  while(!output.isEmpty()){
			  ListNode temp1=new ListNode(output.pop());
			  temp.next= temp1;
			  temp=temp1;
			  
			  
		  }
		  
		  
		  return node;
	    
	}

	public static void main(String[] args) {

		ListNode node = new ListNode(7);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);

		node.next = node1;
		node1.next = node2;
		node2.next = node3;

		ListNode node11 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node33 = new ListNode(4);

		node11.next = node22;
		node22.next = node33;

		ListNode output = addTwoNumbers(node, node11);
		while (output != null) {
			System.out.println(output.val + "->");
			output=output.next;
		}

	}
}
