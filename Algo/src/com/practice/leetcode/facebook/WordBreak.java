package com.practice.leetcode.facebook;

import java.util.*;

public class WordBreak {

    public boolean wordBreak(String word, List<String> wordDict) {
        boolean istrue=false;

        Set<String> wordSet = new HashSet<String>(wordDict);
        Map<String,Boolean> map = new HashMap<>();
        istrue = wordBreaker(word,wordSet,map);

        return istrue;

    }



    public boolean wordBreaker(String word, Set<String> wordSet,Map<String,Boolean> map) {
        boolean istrue=false;



        for(int i=1;i<=word.length();i++){
            String wordp=word.substring(0,i);
            if(wordSet.contains(wordp)){
                if(word.substring(i,word.length()).equals("")){
                    return true;
                }

                if(map.get(word.substring(i))!=null){
                    istrue=  map.get(word.substring(i));
                }
                else{
                    istrue= wordBreaker(word.substring(i,word.length()),wordSet,map);
                }
                if(istrue){
                    break;
                }

            }


        }
        if(!istrue){
            map.put(word,istrue);
        }

        return istrue;

    }


    public static void main(String[] args) {
        new WordBreak().wordBreak( "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}) );

         }
}
