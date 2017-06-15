package com.practice;

import java.util.HashMap;
import java.util.Map;

public class HackerRankVMWareTest {

	
	   static int entryTime(String s, String keypad) {
	        char[] array=keypad.toCharArray();
	        int[][] matrix= new int[3][3];
	        int p=0;
	    
	        Map<Integer,String> posMap=new HashMap<Integer,String>();
	 
	        for(int i = 0; i<3; i++)
	            for(int j = 0; j<3; j++){
	                matrix[i][j] =Integer.parseInt(array[p]+"");
	                posMap.put(matrix[i][j], i+","+j);
	                p++;
	            }
	        
	        System.out.println(posMap);
	        char[] tArray= s.toCharArray();
	        String previous="";
	        int count=0;
	        for(int x=0;x<tArray.length;x++){
	        	
	        	String indexes= posMap.get(Integer.parseInt(tArray[x]+""));
	

	        	if(previous.equals("") || previous.equals(indexes)){
	        		previous=indexes;
	        	}else {
	        		String [] prev= previous.split(",");
	        		String [] now=indexes.split(",");
	        		
	        		if((Integer.parseInt(prev[0])-Integer.parseInt(now[0])>1) || (Integer.parseInt(prev[1])-Integer.parseInt(now[1])>1)){
	        			count=count+2;
	        		}
	        		else{
	        			count=count+1;

	        		}
	        		previous=indexes;

	        		System.out.println(count);
	        	}

	        	
	        }
	        
	        
	        
	        
	        return count;
	        
	        

	    }
	   
	   public static void main(String[] args) {
		System.out.println(entryTime("423692", "923857614"));
	}
}
