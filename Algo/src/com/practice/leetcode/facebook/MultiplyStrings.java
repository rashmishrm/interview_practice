package com.practice.leetcode.facebook;

public class MultiplyStrings {
    
	public String multiply(String num1, String num2) {
	int m = num1.length();
	int n = num2.length();
	StringBuilder result = new StringBuilder();
	int array[] = new int[m + n];
	

	for (int i = m - 1; i >= 0; i--) {
		int carry = 0;
		for (int j = n - 1; j >= 0; j--) {

			int num = Character.getNumericValue(num1.charAt(i)) * Character.getNumericValue(num2.charAt(j))
					+ carry + array[i + j + 1];
			int dig = num % 10;
			carry = num / 10;
			array[i + j + 1] = dig;

		}
		if (carry != 0) {
			array[i] = array[i] + carry;
		}
	}

		for (int r : array) {
			result = result.append(r);

	}

    while (result.length() != 0 && result.charAt(0) == '0') result.deleteCharAt(0);

	
	return result.toString().length()==0?"0":result.toString();

}

	public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("123", "456"));
	}
}
