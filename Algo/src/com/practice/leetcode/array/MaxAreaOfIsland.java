package com.practice.leetcode.array;

public class MaxAreaOfIsland {
public int maxAreaOfIsland(int[][] grid) {
        
        int max=0;
        
        for(int i=0;i< grid.length;i++){
            for(int j=0;j < grid[0].length;j++){
                
                if(grid[i][j]==1){
                    int count = area(grid,i,j,0);
                    
                    if(max<count)
                        max=count;
                }
                
            }
        }
        return max;
    }
    
    public int  area(int[][]grid, int i,int j,int count){
        if(i<0 || j<0|| i>grid.length-1|| j> grid[0].length-1 || grid[i][j]==0){
            return 0;
        }
        
   grid[i][j]=0;
        
        return 1 + area(grid, i, j+1, count) + area(grid,i+1,j, count) + area(grid,i,j-1, count) + area(grid,i-1,j, count);

    }
}
