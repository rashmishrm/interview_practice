package com.practice.ccinterview.c1;

public class List<V> {

	Object array[] = null;
	int size = 0;

	public List() {
		array = new Object[10];
	}

	public void add(V value) {
		size = size + 1;
		if (size > array.length) {
			Object[] oldData = array;

		} else {
			array[size - 1] = value;
		}

	}

	public void remove(int i) {

	}

}
