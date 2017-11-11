package com.practice.leetcode.facebook;

public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        
        int h=haystack.length();
        int n= needle.length();
        if( haystack.equals(needle))
            return 0;
        
        if(n>h ){
            return -1;
            
        }
    int j=0;
        for(int i=0;i<=h-n;i++){
            
            for(j=0;j<n;j++){
                if(haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
                
                
            }
            
            if(j==n){
               return i; 
            }
            
        
        }
        
        return haystack.equals(needle)?0:-1;
        
    }

	
	
	public static void main(String[] args) {
		
		
		//new ImplementStrStr().strStr("mississippi" , 
			//	"issipi");
		new ImplementStrStr().strStr("hello" , 
				"ll");
		
		
	}
	
	
}
