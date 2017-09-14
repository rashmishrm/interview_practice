package com.practice.leetcode;

public class NumDecodings {

	public static int numDecodings(String s) {
		if(s.startsWith("0") || s.equals("")){
			return 0;
		}
        
		return numdecoder(s, s.length() - 1, "")+1;
	}

	public static int numdecoder(String s, int n, String end) {

		int current = 1;
		
		if(n<0){
			return 0;
		}
		
		int c = Integer.parseInt(s.substring(n, n + 1));

		if (c <= 26 && c >= 1) {
			current = 1;
			
		}
		if (!end.equals("")) {
			int endl = Integer.parseInt(end.substring(0, 1));

			int num = Integer.parseInt(c + endl + "");
			if (num <= 26 && num >= 1) {
				current += 1;
			}
		}

		end = s.substring(n, s.length());
		return numdecoder(s, n - 1, end)*current;

	}
	
	 public static int numDecodings1(String s) {
	        if(s == null || s.length() == 0) {
	            return 0;
	        }
	        int n = s.length();
	        int[] dp = new int[n+1];
	        dp[0] = 1;
	        dp[1] = s.charAt(0) != '0' ? 1 : 0;
	        for(int i = 2; i <= n; i++) {
	            int first = Integer.valueOf(s.substring(i-1, i));
	            int second = Integer.valueOf(s.substring(i-2, i));
	            if(first >= 1 && first <= 9) {
	               dp[i] += dp[i-1];  
	            }
	            if(second >= 10 && second <= 26) {
	                dp[i] += dp[i-2];
	            }
	        }
	        
	        for(int k=0;k<n+1;k++){
		        System.out.print(dp[k]+",");

	        }
	        return dp[n];
	    }
	
	public static void main(String[] args) {
		System.out.println(numDecodings1("2310"));
	}

}
