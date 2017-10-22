package com.practice.codefights.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

class NonRepeating {


    static char firstNotRepeatingCharacter(String s) {

        Map<Character, Integer> countMap = new LinkedHashMap<Character, Integer>();
        char ch='_';


        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            Character str = s.charAt(i);
            if (countMap.containsKey(str)) {
                count = countMap.get(str);

            }
            count = count + 1;
            countMap.put(str, count);

        }

        for (Character key : countMap.keySet()) {
            if (countMap.get(key) ==1) {
                ch = key;
                break;
            }
        }

        return ch;

    }

    public static void main(String[] args) {
        char abbbbs = firstNotRepeatingCharacter("abbbbs");


    }

}