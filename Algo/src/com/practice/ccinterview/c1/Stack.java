package com.practice.ccinterview.c1;
class SNode<V> {
	V value;

	SNode<V> next;

	public SNode(V value) {
		this.value = value;
	}
}

public class Stack<V extends Comparable<V>> {

	SNode<V> top = null;

	public void push(V elemnt) {
		SNode<V> node = new SNode<V>(elemnt);
		node.next = top;
		top = node;

	}

	public V pop() throws Exception {
		if (top == null) {
			throw new Exception();
		}

		V data = top.value;
		SNode<V> temp = top.next;
		top = temp;

		return data;

	}

	public V peek() throws Exception {

		if (top == null) {
			throw new Exception();
		}
		V data = top.value;
		return data;

	}

}
