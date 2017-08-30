package com.practice.leetcode.dynamic;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationMasking {

	public static String maskEmail(String email) {
		StringBuilder maskedEmail = new StringBuilder("");
		int index = email.indexOf('@');
		int lastIndex = email.lastIndexOf('@');

		String username = email.substring(0, index);
		String end = email.substring(index, email.length());

		char start = email.charAt(0);
		char uend = email.charAt(index - 1);

		if ((index == lastIndex) && (start != '.' && uend != '.') && !username.contains("..") && isValid(username)) {

			maskedEmail = maskedEmail.append(start + "*****" + uend + end);

		}

		return maskedEmail.toString();
	}

	public static boolean isValid(String email) {
		String right = "[\\w!#$%&'*+/=?^_`{|}~-]+";

		Pattern pattern = Pattern.compile(right, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		boolean isMatched = matcher.matches();

		return isMatched;

	}

	private static String maskPhoneNumber(String phn) {
		phn = phn.replaceAll("\\(", "");
		phn = phn.replaceAll("\\)", "");
		phn = phn.replaceAll("-", "");
		phn = phn.replaceAll(" ", "");
		String last4 = phn.substring(phn.length() - 4, phn.length());
		// System.out.println(last4);
		// String countryCode = "";
		String finalMasked = "";
		if (phn.startsWith("+")) {
			String countryCode = phn.substring(0, phn.length() - 10);
			// System.out.println("CountryCode = "+countryCode);
			countryCode = countryCode.replaceAll("\\d", "*");
			finalMasked = countryCode + "-" + finalMasked;
		}
		finalMasked = finalMasked + "***-***-" + last4;
		// System.out.println(finalMasked);
		return finalMasked;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// String phn = "4158705686";
		// maskPhoneNumber2(phn);
		// maskPhoneNumber2("+914158705686");
		// maskPhoneNumber2("+911 415 870 5686");
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			String input = in.nextLine();

			if (input.startsWith("E:")) {
				// call email method
				System.out.println("E:" + maskEmail(input.substring(2).trim()));
			} else if (input.startsWith("P:")) {
				// call phonenumber method
				System.out.println("P:" + maskPhoneNumber(input.substring(2).trim()));
			}
		}

	}

}
