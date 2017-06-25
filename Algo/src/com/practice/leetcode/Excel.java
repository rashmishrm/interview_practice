package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Excel {

	int[][] matrix = null;

	Map<String, String> functionMap = new HashMap<String, String>();

	public Excel(int H, char W) {
		int width = (((int) W) - 65) + 1;
		System.out.println(width);
		matrix = new int[H][width];

	}

	public void set(int r, char c, int v) {
		int width = ((int) c - 65) + 1;
		matrix[r - 1][width - 1] = v;
		System.out.println(width);
		System.out.println(matrix[r - 1][width - 1]);
		calculate(r, c);

	}

	public int get(int r, char c) {
		int width = ((int) c - 65) + 1;
		return matrix[r - 1][width - 1];

	}

	public void calculate(int r, int c) {
		int width = ((int) c - 65) + 1;

		for (Entry<String, String> entry : functionMap.entrySet()) {
			String value = entry.getValue();
			String abc = entry.getKey();
			if(entry.getKey().contains(":")){
		
			String[] sumC = abc.split(",");
System.out.println(abc);
			int cc = Integer.parseInt(sumC[1]);
			int rr = Integer.parseInt(sumC[0]);

			String array[] = value.split(":");
			int leftCol = ((int) array[0].charAt(0)) - 65 + 1;
			int leftRow = Integer.parseInt(array[0].substring(1, 2));

			int rightCol = ((int) array[1].charAt(0)) - 65 + 1;
			int rightRow = Integer.parseInt(array[1].substring(1, 2));

			if (leftCol <= width && rightCol >= width && leftRow <= r && rightRow >= r) {
				int sum = matrix[rr - 1][cc - 1];
				for (int i = leftRow; i < rightRow; i++) {
					for (int j = leftCol; j < rightCol; j++) {

						sum = sum + matrix[i][j];

					}
				}
				matrix[rr - 1][cc - 1] = sum;
			}
		}
		else{
			int col = (((int) value.charAt(0))) - 65 + 1;

		
			int row = Integer.parseInt(value.substring(1, 2));
			
			int kcol = Integer.parseInt(abc.substring(2, 3));

			
			int krow = Integer.parseInt(abc.substring(0, 1));
			System.out.println(col+"fgfdgdfg"+row);
			System.out.println(kcol+"fgfdgdfg"+krow);
			if(r-1==row-1 && col-1==width-1){
				System.out.println("he");
				matrix[krow-1][kcol-1]=matrix[r - 1][col - 1];
				
				System.out.println(matrix[krow-1][kcol-1]);
			}
			
			
			
			
		}
		}

	}

	public int sum(int r, char c, String[] strs) {
		int sum = 0;
		int w = ((int) c - 65) + 1;
		for (String str : strs) {
			if (str.contains(":")) {
				String array[] = str.split(":");

				int leftCol = ((int) array[0].charAt(0)) - 65 + 1;
				int leftRow = Integer.parseInt(array[0].substring(1, 2));

				int rightCol = ((int) array[1].charAt(0)) - 65 + 1;
				int rightRow = Integer.parseInt(array[1].substring(1, 2));
				functionMap.put("" + (r) + "," + (w), str);

				for (int i = leftRow; i < rightRow; i++) {
					for (int j = leftCol; j < rightCol; j++) {

						sum = sum + matrix[i][j];

					}
				}

			} else {
				int col = (((int) str.charAt(0))) - 65 + 1;

				System.out.println((int) str.charAt(0));
				int row = Integer.parseInt(str.substring(1, 2));
				System.out.println(row);
				sum = sum + matrix[row-1][col-1];
				functionMap.put("" + (r) + "," + (w), str);
			}
		}
		int width = ((int) c - 65) + 1;
		matrix[r - 1][width - 1] = sum;
		return sum;

	}

	public static void main(String[] args) {
		
		
		Excel obj = new Excel(3, 'C');
		

		int param_3 = obj.sum(1, 'A', new String[] { "A2" });
		System.out.println(param_3);

		obj.set(2, 'A', 1);
		
		System.out.println(obj.get(1,'A'));
	}
}