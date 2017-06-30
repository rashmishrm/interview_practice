package com.practice.hackerrank;

import java.util.Scanner;

public class CartesianCountry {
	static long getMaxBridges1(long x1, long y1, long x2, long y2, long xC, long yC) {
		long count = 0;
		long xReach = Math.abs(x2-xC)> Math.abs(xC-x1)? Math.abs(x2-xC):Math.abs(xC-x1);
		long yReach = Math.abs(y2-yC)> Math.abs(yC-y1)? Math.abs(y2-yC):Math.abs(yC-y1) ;		
		long numReach = xReach> yReach? xReach:yReach ;
		for (long num = 1; num <= numReach; num++) {
			if ((xC + num) <= x2 && (xC - num) >= x1) {
				count++;
			}
			if ((yC + num) <= y2 && (yC - num) >= y1) {
				count++;
			}
			if ((yC - num) >= x1 && (xC - num) >= x1 && ((xC + num) <= x2) && (yC + num) <= y2) {
				count = count + 2;
			}
			for (long num2 = 1; num2 <= numReach; num2++) {
				if(num!=num2){
			
				if ((yC - num2) >= x1 && (xC - num) >= x1 && ((xC + num) <= x2) && (yC + num2) <= y2) {
					count = count + 2;
				}
				}
			
			}

		}

		return count;
	}
	
	
	static long getMaxBridges(long x1, long y1, long x2, long y2, long xC, long yC) {
		long count = 0;
		long xReach = Math.abs(x2-xC)< Math.abs(xC-x1)? Math.abs(x2-xC):Math.abs(xC-x1);
		long yReach = Math.abs(y2-yC)< Math.abs(yC-y1)? Math.abs(y2-yC):Math.abs(yC-y1) ;		
		
		 count= xReach+yReach + (xReach*yReach)*2;
		
		

		return count;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		// Return the maximum number of bridges the Rulers will commission.
		long x1 = in.nextLong();
		long y1 = in.nextLong();
		long x2 = in.nextLong();
		long y2 = in.nextLong();
		long xC = in.nextLong();
		long yC = in.nextLong();
		long result = getMaxBridges(x1, y1, x2, y2, xC, yC);
		System.out.println(result);
	}
}
