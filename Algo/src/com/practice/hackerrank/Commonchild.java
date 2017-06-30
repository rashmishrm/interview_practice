package com.practice.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Common implements Comparable<Common> {

	int index;
	String value;

	@Override
	public int compareTo(Common o) {
		return this.index > o.index ? 1 : -1;
	}

	public Common(int index, String value) {
		this.index = index;
		this.value = value;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return value.equals(((Common)obj).value);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return index+":"+value;
	}

}
public class Commonchild {


	static int commonChild(String s1, String s2) {

		int count = 0;
		int lastPos = 0;

		List<Common> map1 = new ArrayList<Common>();
		List<Common> map2 = new ArrayList<Common>();

		Set<String> added = new HashSet<String>();
		for (int i = 0; i < s1.length(); i++) {

			String s = s1.charAt(i) + "";
			if (s2.indexOf(s) != -1 && !added.contains(s)) {

				map1.add(new Common(i,s));
				map2.add(new Common(s2.indexOf(s), s));
			
				added.add(s);

			}

		}
		
		System.out.println(map1);
		
		Collections.sort(map2);
		System.out.println(map2);
		for(int j=0;j<map1.size();j++){
			if(map1.get(j).equals(map2.get(j))){
				count++;
			}
		}
		

		System.out.println(added);

		return count;

	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		int result = commonChild(s1, s2);
		System.out.println(result);
	}
}
