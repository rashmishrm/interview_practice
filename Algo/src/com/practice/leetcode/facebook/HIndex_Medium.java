package com.practice.leetcode.facebook;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HIndex_Medium {

    public int hIndexWrong(int[] citations) {
        int output=0;
        if(citations==null || citations.length==0){
            return 0;
        }

        Arrays.sort(citations);


        Map<Integer, Integer> treemap =
                new TreeMap<Integer, Integer>( Collections.reverseOrder());

        for(int i=0;i<citations.length;i++){
            int curr=citations[i];
            if(!treemap.containsKey(curr))
                treemap.put(curr, citations.length-i);
        }
        for(Integer ech:treemap.keySet()){
            if(ech<=treemap.get(ech)){
                output=ech;
                break;
            }

        }


        return output;


    }

    public int hIndex(int[] citations) {
    int hIndex=0;
    int n=citations.length;
    int mapper[]=new int [n+1];

    for(int i=0;i<n;i++){
        int curr=citations[i];
        if(curr>n){
            mapper[n]++;
        }
        else{
            mapper[curr]++;

        }
    }
int count=0;
        for(int i=n;i>=0;i--){
        count=count+mapper[i];
        if(count>=i){
            hIndex=i;
            break;

        }
        }




    return hIndex;

    }


        public static void main(String[] args) {
        System.out.println(new HIndex_Medium().hIndex( new int[]{100} ));
    }
}
