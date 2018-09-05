package com.practice.leetcode;

public class MaximizeVacationDays {
	public int maxVacationDays(int[][] flights, int[][] days) {
        if(days==null ||days.length==0){
            return 0;
        }
        int cities = days.length;
        int weeks =days[0].length;
        int memo[][] = new int[cities+1][weeks+1];

        for(int i=0;i<= cities;i++){
            for(int j=0;j<=weeks;j++){
                memo[i][j]=-1;
            }
        }
       return maxVacationDaysForCity(flights, days, 0,0,memo);
    }

     public int maxVacationDaysForCity(int[][] flights, int[][] days, int cityFrom, int week,int memo[][]) {
        //System.out.println("cityFrom"+cityFrom+"week"+week);
         if(week== days[0].length){
             return 0;    
         }
          if(memo[cityFrom][week]==-1){
              int max = 0;
             for(int i=0;i<days.length;i++){
                 if(cityFrom!=i && flights[cityFrom][i]==0){
                      continue;
                 }

             int vacationdays =  days[i][week] + maxVacationDaysForCity(flights, days,i,week+1, memo);
             max = Math.max(max, vacationdays);    
              
             }
            memo[cityFrom][week]=max;
          }
         
        return memo[cityFrom][week];
    }
}
