package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.List;

class Q_282Operators {
	
	
	 public List<String> addOperators1(String num, int target) {
	        List<String> rst = new ArrayList<String>();
	        if(num == null || num.length() == 0) return rst;
	        helper(rst, "", num, target, 0, 0, 0);
	        return rst;
	    }
	    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
	        if(pos == num.length()){
	            if(target == eval)
	                rst.add(path);
	            return;
	        }
	        for(int i = pos; i < num.length(); i++){
	            if(i != pos && num.charAt(pos) == '0') break;
	            long cur = Long.parseLong(num.substring(pos, i + 1));
	            if(pos == 0){
	                helper(rst, path + cur, num, target, i + 1, cur, cur);
	            }
	            else{
	                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
	                
	                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
	                
	                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
	            }
	        }
	    }

	public static List<String> addOperators(String num, int target) {
		char[] array = num.toCharArray();
		List<StringBuilder> list = new ArrayList<>();
		int i=0;
		int begin=1;
		int end=0;
		for (char ch : array) {
			if(i!=0) {
				begin=0;
			}
			if(i==array.length-1) {
				end=1;
			}
			list= helper(ch,begin,end,list);
			
			i++;
		}
		
		System.out.println(list);
		
		return null;
	}

	public static List<StringBuilder>  helper(char number, int begin, int end,List<StringBuilder> list,List<Integer> output) {
		String array[] = { "+", "-", "*" };
		List<StringBuilder> temp = new ArrayList<>();
		List<Integer> out = new ArrayList<>();
		if (begin==1) {

			for (String e : array) {

				temp.add(new StringBuilder(number + e));
				out.add(Character.getNumericValue(number);

			}

		} else  {
			
			for (StringBuilder str : list) {
				if(end!=1) {
				for (String e : array) {
					StringBuilder news= new StringBuilder(str);
					news.append(number);
					news.append(e);
					
					temp.add(news);

				}
				}
				else {
					str.append(number);	
					temp.add(str);
				}
			}

		}
		return temp;
	}

	
	public static void main(String[] args) {
		addOperators("123",6);
		
	}
}
