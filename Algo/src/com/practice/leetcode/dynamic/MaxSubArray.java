package com.practice.leetcode.dynamic;

public class MaxSubArray {
   	public static int maxSubArray(int a[]) {
		int sum = 0;
		int m[] = new int[a.length];
        if(a.length==1){
            return a[0];
        }
       
            m[0]=a[0];
        

		for (int i = 1; i < a.length; i++) {
			if (m[i - 1] > 0) {
				m[i] = m[i - 1] + a[i];
			} else {
				m[i] = a[i];
			}
		}

		int msum = Integer.MIN_VALUE;
		for (int i = 0; i < m.length; i++) {
			sum = m[i];

			if (msum < sum) {
				msum = sum;
			}
		}

		return msum;

	}
}
