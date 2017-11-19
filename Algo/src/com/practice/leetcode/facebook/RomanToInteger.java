package com.practice.leetcode.facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
public int romanToInt(String s) {
        
        Map<String, Integer> map= new HashMap<String,Integer>();
        map.put("M",1000);
        map.put("D",500);
        map.put("C",100);
        map.put("L",50);
        map.put("X",10);
        map.put("V",5);
        map.put("I",1);
        
        int lastval=0;
        int current=0;
        int result=0;
        for(int i=0;i<s.length()-1;i++ ){
            int last= map.get(s.charAt(i)+"");
            int now= map.get(s.charAt(i+1)+"");
            
            if(now>last){
                result =result - last;
            }
            else {
                 result = result+ last;
            }
            
        }
        
        return result+map.get(s.charAt(s.length()-1)+"");
        
        
    }
	 
	 public static void main(String[] args) {
		new RomanToInteger().romanToInt("DCXXI");
	}
}
