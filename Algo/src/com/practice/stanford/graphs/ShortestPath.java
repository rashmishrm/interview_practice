package com.practice.stanford.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class ShortestPath {
	public static int shortestDistance(int start,int end, Map<Integer, List<Integer>> adjancylist) {

		Set<Integer> vertices = adjancylist.keySet();
		Set<Integer> visited = new HashSet<Integer>();
		int[] distance = new int[vertices.size()+1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited.add(start);
		distance[start]=0;
		int i = 0;
		a:
		while (!queue.isEmpty()) {

			int v = queue.poll();

			List<Integer> connected = adjancylist.get(v);
			for (Integer w : connected) {

				if (!visited.contains(w)) {
					visited.add(w);
					queue.add(w);
					distance[w]=distance[v]+1;
					if(w==end){
						break a;
					}
				}

			}
			i++;

		}
		
		return distance[end];

	}
	
	
	public static String shortestDistancePath(int start,int end, Map<Integer, List<Integer>> adjancylist) {

		Set<Integer> vertices = adjancylist.keySet();
		Set<Integer> visited = new HashSet<Integer>();
		int[] distance = new int[vertices.size()+1];
		String[] path= new String[vertices.size()+1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited.add(start);
		distance[start]=0;
		path[start]=start+"";
		int i = 0;
		a:
		while (!queue.isEmpty()) {

			int v = queue.poll();

			List<Integer> connected = adjancylist.get(v);
			for (Integer w : connected) {

				if (!visited.contains(w)) {
					visited.add(w);
					queue.add(w);
					distance[w]=distance[v]+1;
					path[w]=path[v]+","+w;
					if(w==end){
						break a;
					}
				}

			}
			i++;

		}
		
		return path[end];

	}

	public static void main(String[] args) {
		
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		
		map.put(1, Arrays.asList(new Integer[]{2,3}));
		map.put(2, Arrays.asList(new Integer[]{4,5}));
		map.put(4, Arrays.asList(new Integer[]{1,3}));
		map.put(3, Arrays.asList(new Integer[]{2}));
		map.put(5, Arrays.asList(new Integer[]{3,4}));

		System.out.println(shortestDistance(1,5,map));
		
		System.out.println(shortestDistancePath(1,5,map));


	}
}
