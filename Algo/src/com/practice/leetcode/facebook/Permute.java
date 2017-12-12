package com.practice.leetcode.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permute {
	public static List<List<Integer>> permute(int[] nums) {
		   List<List<Integer>> list = new ArrayList<>();
		   // Arrays.sort(nums); // not necessary
		   backtrack(list, new ArrayList<>(), nums);
		   return list;
		}

		private  static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
		   if(tempList.size() == nums.length){
		      list.add(new ArrayList<>(tempList));
		   } else{
		      for(int i = 0; i < nums.length; i++){ 
		         if(tempList.contains(nums[i])) continue; // element already exists, skip
		         tempList.add(nums[i]);
		         backtrack(list, tempList, nums);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		} 
		
		public static List<List<Integer>> permuteL(int[] num) {
		    LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
		    res.add(new ArrayList<Integer>());
		    for (int n : num) {
		        int size = res.size();
		        for (; size > 0; size--) {
		            List<Integer> r = res.pollFirst();
		            for (int i = 0; i <= r.size(); i++) {
		                List<Integer> t = new ArrayList<Integer>(r);
		                t.add(i, n);
		                res.add(t);
		            }
		        }
		    }
		    return res;
		}
		
//		ArrayList<String> printPerms(String s) {
//			2 ArrayList<String> result = new ArrayList<String>();
//			3 HashMap<Character, Integer> map = buildFreqTable(s);
//			4 printPerms(map, un, s.length(), result);
//			5 return result;
//			6 }
//			7
//			8 HashMap<Character, Integer> buildFreqTable(String s) {
//			9 HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//			16 for (char c : s.toCharArray(» {
//			11 if (!map.containsKey(c» {
//			12 map.put(c, 6) ;
//			13 }
//			14 map.put(c, map.get(c) + 1);
//			15 }
//			16 return map;
//			17 }
//			18
//			19 void printPerms(HashMap<Character, Integer> map, String prefix, int remaining,
//			26 ArrayList <String> result) {
//			21 /* Base case. Permutation has been completed. */
//			22 if (remaining == 0) {
//			23 result.add(prefix);
//			24 return;
//			25 }
//			26
//			27 /* Try remaining letters for next char, and generate remaining permutations. */
//			358 Cracking the Coding Interview, 6th Edition
//			Solutions to Chapter 8 I Recursion and Dynamic Programming
//			28 for (Character c : map.keySet(» {
//			29 int count = map.get(c);
//			30 if (count> 0) {
//			31 map.put(c, count - 1);
//			32 printPerms(map, prefix + c, remaining - 1, result);
//			33 map.put(c, count ) ;
//			34 }
//			35 }
//			36 }
//			
//			
//			
//			
//			
//			without dups
//			
//			ArrayList <String> getPerms(String str) {
//				2 if ( str == nUll) return null ;
//				3
//				4 Array List<String> permutations new ArrayList<String>();
//				5 i f (st r . length() == 6) { II base case
//				6 pe rmutations . add("" );
//				CrackingTheCodinglnterview.com 16th Edition 355
//				Solutions to Chapter 8 I Recursion and Dynamic Programming
//				7 return permutationsj
//				8 }
//				9
//				10 char first = str.charAt(0)j II get the first char
//				11 String remainder = str.substring(l)j II remove the first char
//				12 ArrayList<String> words = getPerms(remainder)j
//				13 for (String word : words) {
//				14 for (int j = 0j j <= word.length()j j++) {
//				15 String s = insertCharAt(word, first, j);
//				16 permutations.add(s)j
//				17 }
//				18 }
//				19 return permutationsj
//				20 }
//				21
//				22 1* Insert char c at index i in word. *1
//				23 String insertCharAt(String word, char c, int i) {
//				24 String start = word.substring(0, i)j
//				25 String end = word.substring(i)j
//				26 return start + C + endj
//				27 }
		
		public static void main(String[] args) {
			permuteL(new int[] {2,1,3});
		}
}
