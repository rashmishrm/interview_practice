package com.practice.leetcode;

public class Monotonic {
    public boolean isMonotonic(int[] A) {
        boolean mono=true;
        int store=0;
        int diff=0;
        int nstore=0;
        for(int i=1;i<A.length;i++){
            diff = A[i]-A[i-1];
            nstore = diff>0?1:diff<0?-1:0;
            if(nstore!=0){
            if(nstore!=store && store!=0){
                return false;
            }
            store=nstore;
            }
        }
        return mono;
    }
}
