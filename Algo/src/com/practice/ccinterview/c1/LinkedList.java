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
	private Node<V> tail;

	public void pushToBack(V value) {
		if (start == null) {
			Node<V> node = new Node<V>(value);
			start.next = node;
			tail.next = node;

		} else {
			Node<V> node = new Node<V>(value);
			Node tNode = tail.next;
			tNode.next = node;
			tail.next = node;

		}

	}
	public void pushAtStart(V value) {
		if (start == null) {
			Node<V> node = new Node<V>(value);
			start= new Node<V>(null);
			tail = new Node<V>(null);
			start.next = node;
			tail.next = node;

		} else {
			Node<V> node = new Node<V>(value);
			Node sNode = start.next;
			node.next=sNode;
			start.next = node;

		}

	}
	
	public void popFromStart() {
		if (start == null) {


		} else {
			Node sNode = start.next;
			start.next=sNode.next;
		

		}

	}
	
	

	public void delete(int index) {

		Node<V> temp = start;
		int i = 0;
		Node<V> previous = null;
		while (temp.next != null) {
			if (index == i) {
				previous.next = temp.next;
			}
			previous = temp;
			temp = temp.next;

			i++;
		}

	}

	@Override
	public String toString() {
		String str = "";
		Node<V> temp = start.next;

		while (temp != null) {
			str = str + temp.value + ",";
			temp = temp.next;

		}
		return str;
	}

	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<>();
		l.pushAtStart(1);
		l.pushAtStart(2);
		l.pushAtStart(3);

		l.pushToBack(4);
		System.out.println(l);
	}

}
