package com.practice.leetcode.facebook;

public class PointsOnCircle {
	
	    $res = new int[];
	    for($x=-$r;$x<=$r;$x++){
	        for ($y=-$r; $y<=$r ; $y++) {
	            if($x*$x+$y*$y<=$r*$r){
	                $res[] = "({$x},{$y})";
	            }
	        }
	    }
	    return $res;
	
}
