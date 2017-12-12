package com.practice.leetcode.facebook;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;


//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

public class ValidParenthesis {
	 public boolean isValid(String s) {
	        Set<Character> set= new HashSet<Character>();
	        Stack<Character> stack = new Stack<Character>();
	        
	        int count=0;
	        set.add('(');
	         set.add('[');
	         set.add('{');
	   
	        
	        for(int i=0;i<s.length();i++){
	            
	           if(set.contains(s.charAt(i))){
	             stack.push(s.charAt(i));
	               
	           }
	        else if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='(')
	            stack.pop();
	        else if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek()=='{')
	            stack.pop();
	            
	        else if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek()=='[')
	            stack.pop();
	         else 
	             return false;
	            
	            
	            
	              }
	        return stack.size()==0?true:false;
	    }
}
