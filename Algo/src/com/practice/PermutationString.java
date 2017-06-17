package com.practice;

public class PermutationString {

	static void permutation(String str, String prefix) {
		System.out.println("stack ");

		if (str.length() == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < str.length(); i++) {
				String rem = str.substring(0, i) + str.substring(i + 1);
				
				System.out.println("calling perm::::: "+ rem +"::: "+prefix+":   : "+str.charAt(i));

				permutation(rem, prefix + str.charAt(i));
			}
		}
	}
	
	static void permutation(String str) {
	permutation(str, "");
		 }

	public static void main(String[] args) {
	permutation("abc");
	}
}
