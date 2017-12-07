package com.practice.leetcode;

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return null;
		}

		int array[] = new int[temperatures.length];

		for (int i = 0; i < temperatures.length; i++) {
			int curr = temperatures[i];

			for (int j = i + 1; j < temperatures.length; j++) {

				int next = temperatures[j];
				if (curr < next) {
					array[i] = j - i;
					break;
				}

			}
		}
		return array;

	}
	
	public int[] dailyTemperaturesBetter(int[] temperatures) {
		if (temperatures == null || temperatures.length == 0) {
			return null;
		}
		java.util.Stack<Integer> stack = new  Stack<>();
		

		int array[] = new int[temperatures.length];
		array[temperatures.length-1]=0;
		stack.push(temperatures[temperatures.length-1]);
		int count=0;

		for (int i = temperatures.length-2; i >= 0; i--) {
			
			int current= temperatures[i];
			
			if(current>stack.peek()) {
				int c=0;
				while(!stack.isEmpty() && stack.peek()<current) {
					stack.pop();
					c++;
				}
				if(!stack.isEmpty() ) {
				count = c;
				}
			}
			else {
				count=1;
			}
			stack.push(current);
			array[i]=count;
			
		}
		return array;

	}
	
	public static void main(String[] args) {
		int[] arr= {73, 74, 75, 71, 69, 72, 76, 73};
		
		System.out.println(new DailyTemperatures().dailyTemperaturesBetter(arr));
	}
}
