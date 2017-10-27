package com.practice.leetcode.facebook;

import java.util.*;

public class PhoneNumberLC {
    public List<String> letterCombinations(String digits) {
        List<String> output= new ArrayList<String>();


        if(digits!=null && !"".equals(digits)){
            Map<String,List<String>> map= new HashMap<>();
            map.put("1",Arrays.asList(new String[]{"~"}));
            map.put("2",Arrays.asList(new String[]{"a","b","c"}));
            map.put("3",Arrays.asList(new String[]{"d","e","f"}));
            map.put("4",Arrays.asList(new String[]{"g","h","i"}));
            map.put("5",Arrays.asList(new String[]{"j","k","l"}));
            map.put("6",Arrays.asList(new String[]{"m","n","o"}));
            map.put("7",Arrays.asList(new String[]{"p","q","r","s"}));
            map.put("8",Arrays.asList(new String[]{"t","u","v"}));
            map.put("9",Arrays.asList(new String[]{"w","x","y","z"}));
            map.put("0",Arrays.asList(new String[]{" "}));

            output.addAll(map.get(digits.charAt(0)+""));

            for(int i=1;i<digits.length();i++){
                List<String> temp= new ArrayList<String>();
                String next=digits.charAt(i)+"";
                for(String prefix: output){
                    for(String suffix: map.get(next)){
                        String nextStr=prefix+suffix;
                        temp.add(nextStr);

                    }



                }

                output=temp;



            }

        }


        return output;



    }
}
