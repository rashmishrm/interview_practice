package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
//	TreeMap<Integer, Integer> map= new TreeMap<Integer, Integer>();
//    int count=0;
//    
//    public StockSpanner() {
//        
//  }
//    
//    public int next(int price) {
//     int pricer =0;
//                            System.out.println(map);
//
//
//        if(map.ceilingEntry(price)!=null){
//             System.out.println((map.ceilingEntry(price).getKey()));
//            int highest=map.ceilingEntry(price).getValue();
//             map.put(price,count);
//
//            pricer= (count)-highest;
//        }
//        else{
//            map.put(price,count);
//
//          
//
//
//            pricer= 1;
//            
//        }
//                  count++;
//       
//return pricer;
//    }

	   List<Integer> list;
	    Stack<Integer> stack;

	    public StockSpanner() {
	        list = new ArrayList<>();
	        stack = new Stack<>();

	    }
	    
	   public int next(int price) {

	        while(!stack.isEmpty() && list.get(stack.peek()) <= price) stack.pop();

	        int val;
	        if(stack.isEmpty()) {
	            val = list.size() +1;
	        } else {
	            val = list.size() - stack.peek();
	        }

	        stack.push(list.size());
	        list.add(price);

	        return val;
	        
	    }
}
