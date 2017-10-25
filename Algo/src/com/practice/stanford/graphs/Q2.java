package com.practice.stanford.graphs;

import java.util.*;

public class Q2 {

static class Value{

    List<String>  allValues= new ArrayList<String>();
    List<Integer>  indices= new ArrayList<Integer>();



    public Value(List<String> allValues) {
        this.allValues = allValues;
    }



    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public boolean equals(Object obj) {

       Value other= (Value)obj;

       List<String> temp= new ArrayList<>(other.allValues);

        temp.retainAll(this.allValues);
    if(temp.size()>0){
        return true;
    }


        return false;
    }



}

    static int[][] find_duplicates(String[][] user_info){

    Map<Value,Value> map = new LinkedHashMap<>();


        for(int i=0;i<user_info.length;i++){

            List<String> list= new ArrayList<String>(Arrays.asList(user_info[i]));
         Value val= new Value(list);

            if(map.containsKey(val)){
               Value value= map.get(val);
                value.indices.add(i);
            value.allValues.addAll(val.allValues);
             map.put(value,value);
            }
            else{
                val.indices.add(i);
                map.put(val,val);

            }

        }

        int i=0;
        int j=0;
        int[][] output= new int[map.values().size()][];

        for(Value  val:map.values()){
            j=0;
            Object[] ind=val.indices.toArray();
            output[i]=new int[ind.length];

            for(Integer k:val.indices){
                output[i][j] =k;
                System.out.print(output[i][j]);

                j++;
            }
            System.out.println("");

            i++;
        }

    return output;
    }


    public static void main(String[] args) {
        //String[][] input= {{"A", "B", "C"},{"D","C","E"},{"F","G","H"},{"I","B","J"}};
        String[][] input= null;
        int[][] arr= find_duplicates(input);

for(int i=0;i<arr.length;i++){
    System.out.println("lenghthg"+arr[i].length);
    for(int j=0;j<arr[i].length;j++){
        System.out.print(arr[i][j]);
    }
    System.out.println("");
}


    }

}


