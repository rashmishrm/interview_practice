package com.practice.leetcode.facebook;

import java.util.*;
//
//Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
//
//For example, given
//s = "leetcode",
//dict = ["leet", "code"].
//
//Return true because "leetcode" can be segmented as "leet code".
//
//UPDATE (2017/1/4):
//The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.




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
