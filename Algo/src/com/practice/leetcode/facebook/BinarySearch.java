package com.practice.leetcode.facebook;

public class BinarySearch {

    int binarySearch(int [] a,int n){
    int found=0;
    int high=a.length-1;
    int low=0;

    while( low<=high){

        int mid= low+((high-low)/2);

            if(n>a[mid]){
              low=mid+1;

            }
            else if(n<a[mid]){
                high=mid-1;
            }
            else{
                found=1;
                break;
            }





    }
    return found;

    }

    public static void main(String[] args) {
        System.out.println(new BinarySearch().binarySearch( new int[] {1,6,7,89,450},450));
    }
}
