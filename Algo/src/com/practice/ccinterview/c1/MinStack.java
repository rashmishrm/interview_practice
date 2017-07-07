package com.practice.ccinterview.c1;

public class MinStack<V extends Comparable<V>> {
	Stack<V> minStack = new Stack<V>();

	Node<V> top = null;

	public void push(V elemnt) throws Exception {
		if (elemnt.compareTo(minStack.peek()) < 0) {
			minStack.push(elemnt);
		}
		Node<V> node = new Node<V>(elemnt);
		node.next = top;
		top = node;

	}

	public V pop() throws Exception {
		if (top == null) {
			throw new Exception();
		}

		if(top.value.equals(minStack.peek())){
			minStack.pop();
		}
		
		V data = top.value;
		Node<V> temp = top.next;
		top = temp;

		return data;

	}

	public V min(){
		if(top==null){
			return null;
		}
		else{
			try {
				return minStack.peek();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
		
	}
	
	public V peek() throws Exception {

		if (top == null) {
			throw new Exception();
		}
		V data = top.value;
		return data;

	}

}
