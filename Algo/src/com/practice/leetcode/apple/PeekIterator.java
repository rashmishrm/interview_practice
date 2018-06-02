package com.practice.leetcode.apple;

import java.util.Iterator;

//Java Iterator interface reference:
//https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
 
 Integer peek=null;
 Iterator<Integer> iterator =null;
 
	public PeekingIterator(Iterator<Integer> iterator) {
     this.iterator=iterator;
     if(iterator.hasNext()) 
         peek=iterator.next();
     
     
	    // initialize any member here.
	    
	}

 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
     return peek;
     
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
     Integer safe= peek;
     
      if(iterator.hasNext()) 
         peek=iterator.next();
     
     else
         peek=null;
     return safe;
     
	    
	}

	@Override
	public boolean hasNext() {
     if(peek!=null){
         return true;
     }
     else{
	    return iterator.hasNext() ;
     }
	}
}
