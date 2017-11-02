package com.practice.leetcode.facebook;

import java.util.Stack;

class MyQueue {

    Stack<Integer> adder= null;
    Stack<Integer> remover=null;
    
    /** Initialize your data structure here. */
    public MyQueue() {
    this.adder= new Stack<Integer>();
    this.remover= new Stack<Integer>();  
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        adder.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(remover.isEmpty()){
            
            shiftStack();
        }
        
        //should throw exception
       return remover.pop();
        
    }
    
    private void shiftStack(){
    
            while(!adder.isEmpty()){
               remover.push(adder.pop()); 
                
            }
    }
    
    
    
    
    /** Get the front element. */
    public int peek() {
        
        if(remover.isEmpty()){
            
            shiftStack();   
        }
         return remover.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(remover.size()==0 && adder.size()==0){
            return true;
        }
       return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
