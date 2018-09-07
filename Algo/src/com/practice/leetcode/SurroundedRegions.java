package com.practice.leetcode;

public class SurroundedRegions {
	  public void solve(char[][] board) {
	        if(board==null ||board.length==0 )
	        {
	            return ;
	        }
	        
	         for(int i=0;i<board.length;i++){
	             if(board[i][0]=='O'){
	                color(board, i,0); 
	             }
	              if(board[i][board[0].length-1]=='O'){
	                color(board, i,board[0].length-1); 
	             }
	              
	         }
	          for(int j=0;j<board[0].length;j++){
	             if(board[0][j]=='O'){
	                color(board, 0,j); 
	             }

	              if(board[board.length-1][j] == Character.valueOf('O')){
	                color(board,board.length-1, j); 
	             }
	        }
	         for(int i=0;i<board.length;i++){
	          for(int j=0;j<board[0].length;j++){
	          if(board[i][j]=='O'){
	              board[i][j]='X';
	          }
	            if(board[i][j]=='1'){
	              board[i][j]='O';
	          }                


	          
	          }}

	        
	    }
	    
	    public void color(char[][] board, int i, int j) {
	          
	           if(i>= board.length || i<0 || j<0 || j>=board[0].length || board[i][j]=='X'||board[i][j]=='1' ){
	               return;
	           }
	         board[i][j]='1';
	         color(board, i+1,j);
	         color(board, i,j+1);
	         color(board, i-1,j);
	         color(board, i,j-1);
  }
}
