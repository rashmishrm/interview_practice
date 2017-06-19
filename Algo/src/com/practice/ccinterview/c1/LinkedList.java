package com.practice.ccinterview.c1;

class Node<V> {
	V value;

	Node<V> next;

	public Node(V value) {
		this.value = value;
	}
}

public class LinkedList<V> {

	private Node<V> start;

	public void add(V value) {
		if (start == null) {
			start = new Node<V>(value);
			start.next = null;

		} else {

			Node<V> temp = start;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node<V>(value);
		}

	}
	
	public void delete(int index){
		
		
		Node<V> temp = start;
		int i=0;
		Node<V> previous=null;
		while (temp.next != null  ) {
			if(index==i){
				previous.next=temp.next;
			}
			previous = temp;
			temp = temp.next;
			
			i++;
		}
		

		
	}
	
	@Override
	public String toString() {
		String str="";
		Node<V> temp = start;
		
		while (temp!=null ) {
			str=str+temp.value+",";
			temp = temp.next;
			
		}
		return str;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> l= new LinkedList<>();
		l.add(8);
		l.add(4);
		l.add(5);
		l.add(2);
		l.add(1);
		l.delete(2);
		System.out.println(l);
	}

}

