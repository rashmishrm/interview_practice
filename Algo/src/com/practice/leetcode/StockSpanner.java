package com.practice.leetcode;

import java.util.TreeMap;

public class StockSpanner {
	TreeMap<Integer, Integer> map= new TreeMap<Integer, Integer>();
    int count=0;
    
    public StockSpanner() {
        
  }
    
    public int next(int price) {
     int pricer =0;
                            System.out.println(map);


        if(map.ceilingEntry(price)!=null){
             System.out.println((map.ceilingEntry(price).getKey()));
            int highest=map.ceilingEntry(price).getValue();
             map.put(price,count);

            pricer= (count)-highest;
        }
        else{
            map.put(price,count);

          


            pricer= 1;
            
        }
                  count++;
       
return pricer;
    }
}
