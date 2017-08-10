package com.practice.karumanchi.chapter17;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Greedy_Huffman_Encoding {

	public static PriorityQueue<HuffManNode> createHuffMan(HashMap<Character, Integer> codes) {

		PriorityQueue<HuffManNode> pq = new PriorityQueue<>();

		for (Map.Entry<Character, Integer> ch : codes.entrySet()) {
			HuffManNode node = new HuffManNode(ch.getValue(), ch.getKey(), null, null, null);
			pq.add(node);
		}

		for (int i = 1; i < codes.size(); i++) {

			HuffManNode node = new HuffManNode(0, '\0', null, null, null);

			node.left = pq.poll();
			node.right = pq.poll();

			if (node.left != null && node.right != null) {
				node.frequency = node.left.frequency + node.right.frequency;
				node.character = '\0';
			}
			pq.add(node);

		}
		return pq;

	}

	public static String findCode(HuffManNode root, char ch, String code) {
		HuffManNode node = root;
		if (node == null) {
			return code;
		}

		if (node.character == ch) {
			return code;
		}

		return code = findCode(root.left, ch, "0" + code) != null ? code : findCode(root.right, ch, "1" + code);

	}

	public static void main(String[] args) {
		HashMap<Character, Integer> codes = new HashMap<>();
		codes.put('A', 12);
		codes.put('B', 24);
		codes.put('C', 3);
		codes.put('D', 5);
		PriorityQueue<HuffManNode> pq = createHuffMan(codes);
		System.out.println(pq);

		System.out.println(findCode(pq.poll(), 'C', ""));

	}

}
