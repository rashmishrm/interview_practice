package com.practice.leetcode;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        if(A==null ||A.length==0){
            return 0;
        }
        int sum=0;
        int rec=0;
          for(int i=2;i<A.length;i++){
              if(A[i-1]-A[i-2]==A[i]-A[i-1]){
                  rec=rec+1;
                  sum=sum+rec;
              }
              else{
                  rec=0;
              }
          }
           return sum;
    }
}
