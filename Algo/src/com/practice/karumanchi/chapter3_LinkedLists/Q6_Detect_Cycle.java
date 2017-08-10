package com.practice.karumanchi.chapter3_LinkedLists;

public class Q6_Detect_Cycle {

	public static boolean detectCycle(Node head){
		
		Node slow= head;
		Node fast= head.next.next;
		
		while(fast!=null && fast.next!=null){
			if(fast.equals(slow)){
				return true;
			}
			slow=slow.next;
			fast=fast.next.next;
			
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node node= new Node(1,null);
		Node node1= new Node(1,null);
		Node node2= new Node(1,null);
		Node node3= new Node(1,null);
		
		
		node.next=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node2;
		
		System.out.println(detectCycle(node));
		
	}
	
}
