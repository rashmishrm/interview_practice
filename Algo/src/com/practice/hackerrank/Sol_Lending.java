package com.practice.hackerrank;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sol_Lending {

    private static class Tracker {

        public Integer nextServerNumber(List<Integer> list) {
            int output=1;


          Set<Integer> set= new HashSet<Integer>(  );
    set.addAll( list );
    int i=1;
            while(true){

                if(!set.contains( i )){
                    output=i;
                   break;
                }
                i++;
            }

return output;

        }

        public String allocate(String host){
            if(hostMap.containsKey(host)) {
                List<Integer>nodes = hostMap.get(host);
                int val = nextServerNumber(nodes);
                nodes.add(val);
                Collections.sort(nodes);
                hostMap.put(host, nodes);
                return host+val;
            } else{
                List<Integer>nodes = new ArrayList<>();
                int val = 1;
                nodes.add(val);
                hostMap.put(host, nodes);
                return host+val;
            }
        }

        public Map<String, List<Integer>> hostMap = new HashMap<>();


        public void deallocate(String hostName) {

            String host= hostName.replaceAll("\\d*$", "");

            Integer n = 0;
            try {
                n = Integer.parseInt (hostName.replaceFirst("^.*\\D",""));
            } catch (Exception e) {}

            System.out.println(n);

            if(hostMap.containsKey( host )){
                List<Integer> nodes= hostMap.get( host );
                System.out.print(nodes);
                nodes.remove( n );

                hostMap.put( host,nodes);
                System.out.print(nodes);
            }



        }
    }

    public static void main(String[] args) {
Integer a[]={5,4,1,2};
        List<Integer> l = Arrays.asList( a );



       int m= new Tracker().nextServerNumber( l);

Tracker t= new Tracker();
        System.out.print(t.allocate( "abc" ));

        System.out.print(t.allocate( "abc" ));
   t.deallocate( "abc1" );
        System.out.print(t.allocate( "abc" ));







    }

}
