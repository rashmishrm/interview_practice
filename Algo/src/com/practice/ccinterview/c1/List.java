package com.practice.ccinterview.c1;

import java.util.Arrays;

public class List<V> {

	Object array[] = null;
	int size = 0;

	public List() {
		array = new Object[2];
	}

	public void add(V value) {
		
		if (size +1> array.length) {
			Object[] oldData = array;
			
			array=Arrays.copyOf(oldData, size*2);

		} 
			array[size] = value;
			size= size+1;

		

	}

	public void remove(int i) {
		for(int j=i;j<size;j++){
			array[j]=array[j+1];
		}
		size=size-1;
	}
	
	@Override
	public String toString() {
		String str="";
		
		
		for (int i=0;i<size;i++) {
			str=str+array[i]+",";
			
			
		}
		
		return str;
	}
	
	public int size(){
		return size;
	}
	
	public static void main(String[] args) {
		List<Integer> l = new List();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.remove(3);

		System.out.println(l);
		
	}

}
