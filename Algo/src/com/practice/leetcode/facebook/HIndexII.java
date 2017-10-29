package com.practice.leetcode.facebook;

public class HIndexII {
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



    public int hIndex(int[] citations) {
        int hIndex=0;
        int n=citations.length;
        int mapper[]=new int [n+1];

        int found=0;
        int high=citations.length-1;
        int low=0;

        while( low<=high){

            int mid= low+((high-low)/2);

            if(citations[mid]==(n-mid)){
            return mid;
            }
            else if(citations[mid]>(n-mid)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }





        }
        hIndex=n-(high+1);
        return hIndex;






    }

    public static void main(String[] args) {
        System.out.println(new HIndex_Medium().hIndex( new int[]{0,1,2,5,6} ));
    }

}
