package com.practice.leetcode.dynamic;

public class Decryptor {

	public static String decrypt(String message) {

		String result = "";
		int key[] = { 8, 2, 5, 1, 2, 2, 0 };
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		int j = 0;
		for (int i = 0; i < message.length(); i++) {
			char ch = message.charAt(i);
			int ascii = (int) ch;
			if (Character.isLetter(ch)) {
				ch=Character.toLowerCase(ch);
				int aIndex = alphabets.indexOf(ch);
				System.out.println(aIndex);
				result = result + alphabets.charAt((aIndex % 26 )+key[j]);
				;
				j++;

			} else {
				result = result + ch;
			}

		}
		return result;

	}

	public static void main(String[] args) {
		System.out.println(decrypt("Bjj rwkcs dwpyp fwz ovors wxjs vje tcez fqg"));
	}

}
