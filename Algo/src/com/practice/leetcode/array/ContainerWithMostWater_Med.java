package com.practice.leetcode.array;

//
//Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container and n is at least 2.

public class ContainerWithMostWater_Med {
	public int maxArea_wrong(int[] height) {

		int marea = 0;
		for (int i = 0; i < height.length; i++) {
			int area = (i + 1) * height[i];
			if (marea < area) {
				marea = area;
			}
		}

		return marea;

	}

	public int maxArea(int[] height) {

		int start = 0, end = height.length - 1;
		int marea = 0;
		while (start < end) {
			int area = Math.min(height[start], height[end]) * (end - start);
			if (marea < area) {
				marea = area;
			}

			if (height[start] < height[end]) {
				start++;

			} else {
				end--;
			}

		}

		return marea;

	}
}
