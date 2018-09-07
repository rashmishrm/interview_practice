package com.practice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {

    /** Initialize your data structure here. */ 
    Queue<Integer> queue = new LinkedList<Integer>();
    int windowSize=0;
    int sum=0;
    
    public MovingAverage(int size) {
        this.windowSize=size;
    }
    
    public double next(int val) {
        double result=0.0;
        if(queue.size()==windowSize){
            int popped = queue.poll();
            sum=sum-popped; 
        }
        queue.offer(val);
        sum=sum+val;
        result = (double)sum/(double)queue.size();
        return result;
        
    }
}
