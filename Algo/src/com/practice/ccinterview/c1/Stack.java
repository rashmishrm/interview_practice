package com.practice.ccinterview.c1;

public class Stack<V> {

	Node<V> top = null;

	public void push(V elemnt) {
		Node<V> node = new Node<V>(elemnt);
		node.next = top;
		top = node;

	}

	public V pop() throws Exception {
		if (top == null) {
			throw new Exception();
		}

		V data = top.value;
		Node<V> temp = top.next;
		top = temp;

		return data;

	}

	public V peek() throws Exception {
		
		if (top == null) {
			throw new Exception();
		}
		V data=top.value;
		return data;

	}

}
