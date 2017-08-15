package com.practice.karumanchi.chapter18_Divide_And_Conquer;

public class Q13_Median_Two_Lists {

	public static int median(int a[], int b[]) {
		int median=0;;

		int i = 0;
		int j = 0;
		int k = 0;
		while (i != a.length - 1 || j != b.length - 1) {

			if (a[i] <= b[j]) {

				i++;
			} else {
				j++;
			}
			if (k == (a.length - 1)) {
				median = a[i] <= b[j] ? a[i] : b[j];
				break;
			}
			k++;
		}

		return median;
	}
	
	public static void main(String[] args) {
		System.out.println(median(new int[]{1,5,8,10,13}, new int[]{3,4,7,9,14}));
	}
}
