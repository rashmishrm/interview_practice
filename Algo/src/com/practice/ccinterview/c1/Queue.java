package com.practice.ccinterview.c1;

public class Queue<V> {
	
	Node<V> start=null;
	Node<V> tail=null;
	
	
	public void add(V element){
		Node<V> node= new Node<V>(element);
		if(start==null){
			start=node;
		}
		if(tail==null){
			tail=node;
		}
		else{
			Node temp=tail;
			temp.next=node;
			tail=node;
		}
		
	}
	
	
	public V remove() throws Exception{
		if(start==null){
			throw new Exception();
		}
		V data= start.value;
		
		Node<V> temp=start.next;
		start= temp;
		if(start==null){
			tail=null;
		}
		
		return data;
	}

}
