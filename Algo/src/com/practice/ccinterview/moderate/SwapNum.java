package com.practice.ccinterview.moderate;

public class SwapNum {
	public static void in_placeSwap(int i, int j) {
		i = (i - j) ;
		j = i+j;
		i= j-i;
		System.out.println(i);
		System.out.println(j);
	}
	
	public static void main(String[] args) {
	in_placeSwap(4, 5);
	}
}
