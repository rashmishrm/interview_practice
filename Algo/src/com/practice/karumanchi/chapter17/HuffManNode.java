package com.practice.karumanchi.chapter17;

public class HuffManNode implements Comparable<HuffManNode> {
	int frequency;
	char character = '\0';

	HuffManNode left;
	HuffManNode right;
	HuffManNode parent;

	public HuffManNode(int frequency, char character, HuffManNode left, HuffManNode right, HuffManNode parent) {
		super();
		this.frequency = frequency;
		this.character = character;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	@Override
	public int compareTo(HuffManNode o) {
		if (o.frequency > frequency) {
			return -1;
		} else if (o.frequency < frequency) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return character + ":::" + frequency;
	}

}
