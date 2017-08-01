package com.practice.ccinterview.dynamicandrecursion;

public class Q3_Magic_Index {

	public static boolean checkMagic(int n[]) {
		if (n == null || n.length == 0) {
			return false;
		}
		int size= n.length;
		System.out.println(size);
		return checkMagic(n, 0, size);

	}

	public static boolean checkMagic(int n[], int start, int end) {

		if (start < 0 || end < 0 || end > n.length) {
			return false;
		}

		int mid = start + (end - start) / 2;
		if (n[mid] == mid) {
			return true;
		}

		else if (n[mid] < mid) {
			return checkMagic(n, mid + 1, n.length);
		} else {
			return checkMagic(n, 0, mid - 1);
		}

	}
	
	
	public static void main(String[] args) {
		System.out.println(checkMagic(new int[]{-40,-20,-1,1,2,3,5,7,8,12,13}));
	}

}
