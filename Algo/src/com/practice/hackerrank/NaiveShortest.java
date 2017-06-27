package com.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class NaiveShortest {

	class CustomNode<T> {
		public CustomNode<T> next;
		public CustomNode<T> previous;

		private T value;

		public CustomNode(T value) {
			super();
			this.value = value;
		}

	}

	class CustomLinkedList<T> {
		private CustomNode<T> start;
		private CustomNode<T> end;

		public CustomLinkedList(CustomNode<T> start) {
			this.start = start;
			this.end = start;
		}

		public void add(T element) {
			CustomNode<T> newElement = new CustomNode<T>(element);

			if (start == null) {
				this.start = newElement;
				this.end = newElement;
			}

			else {
				CustomNode<T> temp = this.end;
				newElement.next = null;
				newElement.previous = temp;
				temp.next = newElement;
				this.end = newElement;
			}
		}

		public void removeFirst() {
			CustomNode<T> temp = this.start;
			this.start = temp.next;
			temp.previous = null;
		}

	}

	class CustomQueue<T> {

		private CustomLinkedList<T> list;

		public CustomQueue() {
			// TODO Auto-generated constructor stub
		}

		public CustomQueue(List<T> values) {
			list = new CustomLinkedList<>(null);

		}

		public void enqueue(T value) {
			list.add(value);
		}

		public void enqueueAll(List<T> values) {
			for (T eachValue : values) {
				list.add(eachValue);
			}
		}

		public void dequeue() {
			list.removeFirst();
		}

	}

	static int paths = 0;
	static Stack<String> traversed = new Stack<String>();
	

	public static int path(Queue<String> queue, String end, Map<String, List<String>> map) {

		String value = queue.poll();
		if (!traversed.contains(value)) {
			traversed.push(value);

			if (end.equals(value)) {
			 return 1;
			} else {
				paths++;

				queue.addAll(map.get(value));
			}
		}
		
		return path(queue, end, map);

	}

	public static int shortestPath(Map<String, List<String>> map, String end, String start) {
		int path = 0;
		// CopyOnWriteArrayList<String> queue = new
		// CopyOnWriteArrayList<String>(map.get(start));

		Queue<String> queue = new LinkedList<String>();
		queue.addAll(map.get(start));

		Iterator<String> iter = (Iterator<String>) queue.iterator();
		traversed.push(start);

		System.out.println(path(queue, end, map));
String t= end;
System.out.println(traversed);
		while(!traversed.isEmpty()){
String curr=traversed.pop();
if(map.get(curr).contains(t)){
	System.out.print(""+curr+",");
	t=curr;

}
if(start.equals(t)){
	break;
}
		
		}
		
		return path;

	}

	public static void main(String[] args) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		map.put("1", Arrays.asList(new String[] { "2", "5" }));
		map.put("2", Arrays.asList(new String[] { "1", "3" }));
		map.put("3", Arrays.asList(new String[] { "6", "7", "4" }));
		map.put("4", Arrays.asList(new String[] { "3" }));
		map.put("5", Arrays.asList(new String[] { "6", "7" }));
		map.put("6", Arrays.asList(new String[] { "5", "3" }));
		map.put("7", Arrays.asList(new String[] { "5", "3" }));

		System.out.println(shortestPath(map, "4", "1"));

	}

}

class Node {
	private String name;

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Edge {
	private Node start;
	private Node end;

	public Edge(Node start, Node end) {
		this.start = start;
		this.end = end;
	}

	public Node getEnd() {
		return end;
	}

	public void setEnd(Node end) {
		this.end = end;
	}

	public Node getStart() {
		return start;
	}

	public void setStart(Node start) {
		this.start = start;
	}
}

class Graph {
	List<Edge> edges;

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}