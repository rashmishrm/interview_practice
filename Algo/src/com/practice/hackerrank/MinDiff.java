package com.practice.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// The part of the program involving reading from STDIN and writing to STDOUT has been provided by us.

public class MinDiff {
    
    
    public static int fairness(Integer[] list, int k, int n){
        
        Arrays.sort(list);
        
        int moveFactor= k-1;
        int minDiff=-1;
     
        for(int i=0;i<=(n-k);i++){
            int diff =list[i+moveFactor]-list[i];
           if(minDiff>diff || minDiff==-1){
        	   minDiff=diff;
           }
        }
        return minDiff;
    }
    
   public static void main(String[] args) throws NumberFormatException, IOException {

      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(in.readLine());
      int K = Integer.parseInt(in.readLine());
      Integer[] list = new Integer[N];

      for(int i = 0; i < N; i ++)
         list[i] = Integer.parseInt(in.readLine());
      
      int unfairness = Integer.MAX_VALUE;
      
      /*
       * Write your code here, to process numPackets N, numKids K, and the packets of candies
       * Compute the ideal value for unfairness over here
      */
      
      System.out.println(fairness(list,K,N));
   }
}
