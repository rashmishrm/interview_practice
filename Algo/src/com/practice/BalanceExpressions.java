package com.practice;

import java.util.Stack;

public class BalanceExpressions {

	static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
		int[] results = new int[expressions.length];
		int i = 0;
		for (String ch : expressions) {

			Stack<String> expr = new Stack<String>();
			if(!ch.equals("")){
			Character[] charObjectArray = ch.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
			for (Character chtr : charObjectArray) {
				
				if (chtr.toString().equals("<")) {
					expr.push("<");
				} else if (chtr.toString().equals(">")) {
					if(!expr.isEmpty()){
					expr.pop();
					}
					else{
						expr.push(">");	
					}
				}
			}
			int count=0;
			for(String str: expr){
				
				if(str.equals(">")){
					count++;
				}
				
			}
			
			//System.out.println(expr.size());

			if ((expr.size() == 0) || (count == maxReplacements[i])) {
				results[i] = 1;
			} else {
				results[i] = 0;
			}
			System.out.println(results[i]);

			i++;
			}
		}

		return results;

	}

	
	public static void main(String[] args) {
		
		String[] abc= {""};
		
		int[] replacemnts ={2};
		
		System.out.println(balancedOrNot(abc,replacemnts));
	}
}
